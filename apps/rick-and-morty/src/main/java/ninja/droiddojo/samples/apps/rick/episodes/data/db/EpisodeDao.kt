package ninja.droiddojo.samples.apps.rick.episodes.data.db

import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.Junction
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import ninja.droiddojo.samples.apps.rick.character.data.db.models.DatabaseCharacter
import ninja.droiddojo.samples.apps.rick.episodes.data.db.models.CharacterToEpisodeMapping
import ninja.droiddojo.samples.apps.rick.episodes.data.db.models.DatabaseEpisode

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM Episodes")
    fun episodes(): Flow<List<DatabaseEpisode>>

    @Query("SELECT * FROM Episodes WHERE id = :episodeId")
    fun findEpisode(episodeId: Long): Flow<DatabaseEpisode?>

    @Transaction
    @Query("SELECT * FROM Characters WHERE id = :characterId")
    fun charactersWithEpisodes(characterId: Long): Flow<CharacterWithEpisodes?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(episode: DatabaseEpisode)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(episodes: List<DatabaseEpisode>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConnection(connections: List<CharacterToEpisodeMapping>)
}

data class CharacterWithEpisodes(
    @Embedded val character: DatabaseCharacter,
    @Relation(
        parentColumn = "id",
        entity = DatabaseEpisode::class,
        entityColumn = "id",
        associateBy = Junction(
            CharacterToEpisodeMapping::class,
            parentColumn = "characterId",
            entityColumn = "episodeId"
        )
    ) val episodes: List<DatabaseEpisode>
)


