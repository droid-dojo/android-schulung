package ninja.droiddojo.samples.apps.rick.startup

import android.content.Context
import androidx.hilt.work.HiltWorkerFactory
import androidx.startup.Initializer
import androidx.work.ExistingWorkPolicy
import androidx.work.Operation
import androidx.work.WorkManager
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ninja.droiddojo.samples.apps.rick.character.data.sync.CharacterDataSynchronizer
import ninja.droiddojo.samples.apps.rick.episodes.data.sync.EpisodesDataSynchronizer

class SyncInitializer : Initializer<Operation> {
    override fun create(context: Context): Operation {
        return WorkManager.getInstance(context).enqueueUniqueWork(
            uniqueWorkName = "characterSync",
            existingWorkPolicy = ExistingWorkPolicy.KEEP,
            requests = listOf(
                CharacterDataSynchronizer.sync(1),
                EpisodesDataSynchronizer.sync(1)
            )
        )
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> {
        return listOf(HiltWorkInitializer::class.java)
    }
}

@EntryPoint
@InstallIn(SingletonComponent::class)
interface HiltWorkerFactoryEntryPoint {
    fun hiltWorkerFactory(): HiltWorkerFactory
}
