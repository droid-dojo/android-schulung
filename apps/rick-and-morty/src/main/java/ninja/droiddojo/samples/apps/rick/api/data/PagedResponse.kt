package ninja.droiddojo.samples.apps.rick.api.data

import kotlinx.serialization.Serializable

@Serializable
data class PagedResponse<T>(
    val info: PagingInfo, val results: List<T>
)