package kozlov.artyom.bookly.domain.repository

import kozlov.artyom.bookly.domain.entity.BestItem
import kozlov.artyom.bookly.domain.entity.CarouselItem

interface MovieRepository {

    suspend fun getCarouselList(): List<CarouselItem>

    suspend fun getBestList(): List<BestItem>

    suspend fun getLikeList(): List<CarouselItem>
}