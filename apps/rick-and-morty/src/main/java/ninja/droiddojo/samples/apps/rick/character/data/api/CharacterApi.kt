package ninja.droiddojo.samples.apps.rick.character.data.api

import ninja.droiddojo.samples.apps.rick.api.data.PagedResponse
import ninja.droiddojo.samples.apps.rick.character.data.api.models.ApiCharacter
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {

    @GET("character")
    suspend fun characterList(@Query("page") page: Int? = null): PagedResponse<ApiCharacter>

    @GET("character/{id}")
    suspend fun character(@Path("id") characterId: Int): ApiCharacter
}
