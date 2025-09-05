package ninja.droiddojo.samples.apps.rick.character.list

import ninja.droiddojo.samples.apps.rick.character.data.Character

sealed interface CharacterListScreenState {
    object Loading : CharacterListScreenState
    object Error : CharacterListScreenState
    data class Content(
        val characters: List<Character>
    ) : CharacterListScreenState
}