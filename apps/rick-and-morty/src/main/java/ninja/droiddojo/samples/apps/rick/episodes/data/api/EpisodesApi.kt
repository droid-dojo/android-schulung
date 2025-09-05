package ninja.droiddojo.samples.apps.rick.episodes.data.api

import ninja.droiddojo.samples.apps.rick.api.data.PagedResponse
import ninja.droiddojo.samples.apps.rick.episodes.data.api.models.ApiEpisode
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodesApi {

    @GET("episode")
    suspend fun episodeList(@Query("page") page: Int? = null): PagedResponse<ApiEpisode>

    @GET("episode/{id}")
    suspend fun episode(@Path("id") episodeId: Int): ApiEpisode
}
