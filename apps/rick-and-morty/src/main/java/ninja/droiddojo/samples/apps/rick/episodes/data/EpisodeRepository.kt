package ninja.droiddojo.samples.apps.rick.episodes.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import ninja.droiddojo.samples.apps.rick.character.data.Character
import ninja.droiddojo.samples.apps.rick.episodes.data.db.EpisodeDao
import ninja.droiddojo.samples.apps.rick.episodes.data.db.models.DatabaseEpisode
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EpisodeRepository @Inject constructor(
    private val db: EpisodeDao,
) {
    fun allEpisodes(): Flow<List<Episode>> = db.episodes()
        .map { it.map { it.asDomainModel() } }

    fun findEpisode(id: Long): Flow<Episode?> = db
        .findEpisode(episodeId = id)
        .map { it?.asDomainModel() }

    fun findEpisodesForCharacter(characterId: Long): Flow<List<Episode>> =
        db.charactersWithEpisodes(characterId)
            .mapNotNull { it?.episodes?.map { it.asDomainModel() } }


    private fun DatabaseEpisode.asDomainModel() = Episode(
        id = id,
        name = name,
        season = season,
        episode = episode,
        characters = emptyList() // TODO
    )

}

data class Episode(
    val id: Long,
    val name: String,
    val season: Int,
    val episode: Int,
//    val airDate: Date,
    val characters: List<Character>
)