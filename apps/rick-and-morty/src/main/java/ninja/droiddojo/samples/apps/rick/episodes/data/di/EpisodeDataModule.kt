package ninja.droiddojo.samples.apps.rick.episodes.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ninja.droiddojo.samples.apps.rick.db.RickDatabase
import ninja.droiddojo.samples.apps.rick.episodes.data.api.EpisodesApi
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class EpisodeDataModule {
    @Provides
    fun proivideEpisodeApi(retrofit: Retrofit): EpisodesApi = retrofit.create()

    @Provides
    fun provideEpisodeDao(database: RickDatabase) = database.episodeDao()

}