package ninja.droiddojo.samples.apps.rick.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ninja.droiddojo.samples.apps.rick.character.data.db.CharacterDao
import ninja.droiddojo.samples.apps.rick.character.data.db.models.DatabaseCharacter
import ninja.droiddojo.samples.apps.rick.episodes.data.db.EpisodeDao
import ninja.droiddojo.samples.apps.rick.episodes.data.db.models.CharacterToEpisodeMapping
import ninja.droiddojo.samples.apps.rick.episodes.data.db.models.DatabaseEpisode

@Database(
    entities = [DatabaseCharacter::class, DatabaseEpisode::class, CharacterToEpisodeMapping::class],
    version = 1
)
abstract class RickDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao
}