package kozlov.artyom.bookly.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import kozlov.artyom.bookly.data.network.CurrencyApi
import kozlov.artyom.bookly.data.network.RetrofitInstance
import kozlov.artyom.bookly.data.repository.MovieRepositoryImpl
import kozlov.artyom.bookly.di.ApplicationScope
import kozlov.artyom.bookly.domain.repository.MovieRepository

@Module
interface ValueDomainModule {

    @ApplicationScope
    @Binds
    fun bindMovieListRepository(impl: MovieRepositoryImpl): MovieRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideAppInternet(): CurrencyApi {
            return RetrofitInstance.api
        }


    }

}