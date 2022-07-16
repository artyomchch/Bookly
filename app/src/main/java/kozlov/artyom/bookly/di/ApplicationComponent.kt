package kozlov.artyom.bookly.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kozlov.artyom.bookly.presentation.cinemafragment.CinemaFragment


@ApplicationScope
@Component(
    modules = [ValueDomainModule::class, ViewModelModule::class]
)
interface ApplicationComponent {

    fun inject(fragment: CinemaFragment)


    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}