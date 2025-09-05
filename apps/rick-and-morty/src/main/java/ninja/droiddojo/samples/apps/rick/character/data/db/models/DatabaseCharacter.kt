package ninja.droiddojo.samples.apps.rick.character.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Characters"
)
data class DatabaseCharacter(
    @PrimaryKey val id: Long,
    val name: String,
    val image: String,
)