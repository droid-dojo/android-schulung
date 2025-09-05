package ninja.droiddojo.samples.apps.rick.character.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ninja.droiddojo.samples.apps.rick.character.data.api.CharacterApi
import ninja.droiddojo.samples.apps.rick.db.RickDatabase
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class CharacterDataModule {
    @Provides
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi = retrofit.create()

    @Provides
    fun provideCharacterDao(database: RickDatabase) = database.characterDao()

}