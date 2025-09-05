package ninja.droiddojo.samples.apps.rick.character.data.api.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiCharacter(
    val id: Long,
    val name: String,
    val image: String,
)