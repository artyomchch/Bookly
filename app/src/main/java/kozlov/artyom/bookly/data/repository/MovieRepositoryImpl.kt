package kozlov.artyom.bookly.data.repository

import kozlov.artyom.bookly.data.mapper.MovieListMapper
import kozlov.artyom.bookly.data.network.CurrencyApi
import kozlov.artyom.bookly.domain.entity.BestItem
import kozlov.artyom.bookly.domain.entity.CarouselItem
import kozlov.artyom.bookly.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val mapper: MovieListMapper,
    private val retrofit: CurrencyApi,

    ) : MovieRepository {


    override suspend fun getCarouselList(): List<CarouselItem> {
        return mapper.mapListNetworkModelToListEntityCarousel(retrofit.getCarousel())
    }

    override suspend fun getBestList(): List<BestItem> {
        return mapper.mapListNetworkModelToListEntityBest(retrofit.getBest())
    }

    override suspend fun getLikeList(): List<CarouselItem> {
        return mapper.mapListNetworkModelToListEntityCarousel(retrofit.getSimilar())
    }


}