package kozlov.artyom.bookly.utils

import android.app.Application
import dagger.internal.DaggerGenerated
import kozlov.artyom.bookly.di.ApplicationComponent
import kozlov.artyom.bookly.di.DaggerApplicationComponent


class App : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)

    }
}