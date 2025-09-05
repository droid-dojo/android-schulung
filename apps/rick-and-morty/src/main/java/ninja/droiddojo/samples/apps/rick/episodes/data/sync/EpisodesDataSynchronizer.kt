package ninja.droiddojo.samples.apps.rick.episodes.data.sync

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import ninja.droiddojo.samples.apps.rick.episodes.data.api.EpisodesApi
import ninja.droiddojo.samples.apps.rick.episodes.data.api.models.ApiEpisode
import ninja.droiddojo.samples.apps.rick.episodes.data.db.EpisodeDao
import ninja.droiddojo.samples.apps.rick.episodes.data.db.models.CharacterToEpisodeMapping
import ninja.droiddojo.samples.apps.rick.episodes.data.db.models.DatabaseEpisode

@HiltWorker
class EpisodesDataSynchronizer @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted private val workParams: WorkerParameters,
    private val db: EpisodeDao,
    private val api: EpisodesApi
) : CoroutineWorker(appContext, workParams) {

    override suspend fun doWork(): Result {

        var page = workParams.inputData.getInt(key = ArgPageKey, defaultValue = 1)
        var totalPages = 1
        var hasNext = true

        setProgress(workDataOf("Progress" to 0))

        while (hasNext) {
            try {
                val response = api.episodeList(page)
                totalPages = response.info.pages
                saveEpisodesInDatabase(response.results)
                hasNext = response.info.next != null
                page = page + 1
                setProgress(workDataOf("Progress" to page / totalPages * 100))

            } catch (e: Exception) {
                Log.e("EpisodesSync", "Error Syncing Episodes", e)
                return Result.failure(Data.Builder().putInt(ArgPageKey, page).build())
            }
        }

        setProgress(workDataOf("Progress" to 100))

        return Result.success()
    }


    private suspend fun saveEpisodesInDatabase(episodes: List<ApiEpisode>) {
        val connections = episodes.flatMap { episode ->
            episode.characters
                .mapNotNull { CharacterIdRegex.find(it)?.groupValues?.get(1)?.toLong() }
                .map { CharacterToEpisodeMapping(characterId = it, episodeId = episode.id) }
        }

        db.insert(episodes.map { it.asDatabaseCharacter() })
        db.insertConnection(connections)
    }

    private fun ApiEpisode.asDatabaseCharacter() = DatabaseEpisode(
        id = id,
        name = name,
        season = seasonNumber,
        episode = episodeNumber
    )

    private val ApiEpisode.seasonNumber: Int
        get() = SeasonRegex.find(episode)?.groupValues?.get(1)?.toInt() ?: 0

    private val ApiEpisode.episodeNumber: Int
        get() = EpisodeRegex.find(episode)?.groupValues?.get(1)?.toInt() ?: 0

    companion object {
        private val SeasonRegex = Regex("S(\\d+)")
        private val EpisodeRegex = Regex("E(\\d+)")
        private val CharacterIdRegex = Regex("/(\\d+)")
        private const val ArgPageKey = "page"
        private const val Tag = "EpisodeSynchronizer"

        fun sync(page: Int) = OneTimeWorkRequestBuilder<EpisodesDataSynchronizer>()
            .addTag(Tag)
            .setInputData(Data.Builder().putInt(ArgPageKey, page).build())
            .build()

    }
}