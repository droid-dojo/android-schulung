package ninja.droiddojo.samples.apps.rick.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Authenticator
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object BackendModule {

    @Provides
    fun provideJson() = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    fun provideRetrofit(json: Json): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))

            .build()
    }


}

