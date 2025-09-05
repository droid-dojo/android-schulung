package ninja.droiddojo.samples.apps.rick.startup

import android.content.Context
import androidx.startup.Initializer
import androidx.work.Configuration
import androidx.work.WorkManager
import dagger.hilt.android.EntryPointAccessors

class HiltWorkInitializer : Initializer<WorkManager> {
    override fun create(context: Context): WorkManager {

        // SingeltonComponent(context).inject()

        val factory = EntryPointAccessors
            .fromApplication<HiltWorkerFactoryEntryPoint>(context)
            .hiltWorkerFactory()

        WorkManager.Companion.initialize(context, Configuration.Builder().setWorkerFactory(factory).build())

        return WorkManager.Companion.getInstance(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> {
        return emptyList()
    }

}