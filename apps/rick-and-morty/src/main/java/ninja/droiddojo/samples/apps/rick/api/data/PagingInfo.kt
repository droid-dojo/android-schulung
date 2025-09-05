package ninja.droiddojo.samples.apps.rick.api.data

import kotlinx.serialization.Serializable

@Serializable
data class PagingInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?,
)