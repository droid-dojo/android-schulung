package ninja.droiddojo.samples.apps.rick.character.data.sync

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import ninja.droiddojo.samples.apps.rick.character.data.api.CharacterApi
import ninja.droiddojo.samples.apps.rick.character.data.api.models.ApiCharacter
import ninja.droiddojo.samples.apps.rick.character.data.db.CharacterDao
import ninja.droiddojo.samples.apps.rick.character.data.db.models.DatabaseCharacter
import kotlin.time.Duration.Companion.seconds

@HiltWorker
class CharacterDataSynchronizer @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted private val workParams: WorkerParameters,
    private val db: CharacterDao,
    private val api: CharacterApi
) : CoroutineWorker(appContext, workParams) {

    override suspend fun doWork(): Result {

        var page = workParams.inputData.getInt(key = ArgPageKey, defaultValue = 1)
        var totalPages = 1
        var hasNext = true

        setProgress(workDataOf("Progress" to 0))

        while (hasNext) {
//            delay(5.seconds)
            Log.d("Foo", "Requesting page $page")
            try {
                val response = api.characterList(page)

                totalPages = response.info.pages

                saveCharactersInDatabase(response.results)
                hasNext = response.info.next != null
                page = page + 1
                setProgress(workDataOf("Progress" to page / totalPages * 100))

            } catch (e: Exception) {
                return Result.failure(Data.Builder().putInt(ArgPageKey, page).build())
            }
        }

        setProgress(workDataOf("Progress" to 100))

        return Result.success()
    }


    private suspend fun saveCharactersInDatabase(chars: List<ApiCharacter>) {
        db.insertCharacters(chars.map { it.asDatabaseCharacter() })
    }

    private fun ApiCharacter.asDatabaseCharacter() = DatabaseCharacter(
        id = id,
        name = name,
        image = image
    )

    companion object {

        private const val ArgPageKey = "page"
        private const val Tag = "CharacterSynchronizer"
        fun sync(page: Int) = OneTimeWorkRequestBuilder<CharacterDataSynchronizer>()
            .addTag(Tag)
            .setInputData(Data.Builder().putInt(ArgPageKey, page).build())
            .build()

        fun progress(workManager: WorkManager) = workManager.getWorkInfosByTagFlow(Tag)
            .map { it[0].progress.getInt("Progress", 0) }
    }
}