package ninja.droiddojo.samples.apps.rick.character.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ninja.droiddojo.samples.apps.rick.character.data.db.models.DatabaseCharacter

@Dao
interface CharacterDao {
    @Query("SELECT * FROM Characters")
    suspend fun allCharacters(): List<DatabaseCharacter>

    @Query("SELECT * FROM Characters")
    fun allCharactersFlow(): Flow<List<DatabaseCharacter>>

    @Query("SELECT * FROM Characters WHERE id = :userId")
    fun findCharacter(userId: Long): Flow<DatabaseCharacter?>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(char: DatabaseCharacter)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(char: List<DatabaseCharacter>)

}


