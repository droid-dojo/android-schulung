package ninja.droiddojo.samples.apps.rick.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): RickDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = RickDatabase::class.java,
            name = "app.db"
        ).build()
    }

}