package ninja.droiddojo.samples.apps.rick.episodes.data.db.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import ninja.droiddojo.samples.apps.rick.character.data.db.models.DatabaseCharacter

@Entity(
    tableName = "Episodes"
)
data class DatabaseEpisode(
    @PrimaryKey val id: Long,
    val name: String,
    val season: Int,
    val episode: Int
    //    val airDate: Date TODOW
)


@Entity(
    primaryKeys = ["characterId", "episodeId"],
    foreignKeys = [
        ForeignKey(
            entity = DatabaseCharacter::class,
            parentColumns = ["id"],
            onDelete = CASCADE,
            childColumns = ["characterId"]
        ),
        ForeignKey(
            entity = DatabaseEpisode::class,
            parentColumns = ["id"],
            onDelete = CASCADE,
            childColumns = ["episodeId"]
        )
    ],
)
data class CharacterToEpisodeMapping(
    val characterId: Long,
    val episodeId: Long
)
