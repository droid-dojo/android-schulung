package ninja.droiddojo.samples.apps.rick.episodes.data.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiEpisode(
    val id: Long,
    val name: String,
    @SerialName("air_date") val airDate: String,
    val episode: String,
    val characters: List<String>
)