package kozlov.artyom.bookly.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kozlov.artyom.bookly.presentation.cinemafragment.CinemaFragmentViewModel

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(CinemaFragmentViewModel::class)
    @Binds
    fun bindCinemaFragmentViewModel(impl: CinemaFragmentViewModel): ViewModel


}