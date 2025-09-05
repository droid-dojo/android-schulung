package ninja.droiddojo.samples.apps.rick.character.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ninja.droiddojo.samples.apps.rick.character.data.db.CharacterDao
import ninja.droiddojo.samples.apps.rick.character.data.db.models.DatabaseCharacter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(
    private val db: CharacterDao,
) {
    fun allCharacters(): Flow<List<Character>> = db.allCharactersFlow()
        .map { it.map { it.asDomainModel() } }

    fun findCharacter(id: Long): Flow<Character?> = db
        .findCharacter(userId = id)
        .map { it?.asDomainModel() }


    private fun DatabaseCharacter.asDomainModel() =
        Character(id = id, name = name, image = image)

}

