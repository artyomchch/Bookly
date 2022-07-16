package kozlov.artyom.bookly.data.mapper

import kozlov.artyom.bookly.data.network.pojo.BestDTOItem
import kozlov.artyom.bookly.data.network.pojo.CarouselItemDTO
import kozlov.artyom.bookly.domain.entity.BestItem
import kozlov.artyom.bookly.domain.entity.CarouselItem
import javax.inject.Inject

class MovieListMapper @Inject constructor() {

    private fun mapNetworkModelToEntity(bestItem: BestDTOItem) =
        BestItem(
            id = bestItem.id,
            image = bestItem.image,
            title= bestItem.title,
            author = bestItem.author,
            price = bestItem.price,
            score = bestItem.rate.score,
            amount = bestItem.rate.amount
        )

    private fun mapNetworkModelToEntityCarousel(carouselItem: CarouselItemDTO) =
        CarouselItem(
            id = carouselItem.id,
            image = carouselItem.image

        )

    fun mapListNetworkModelToListEntityBest(list: List<BestDTOItem>) =
        list.map {
            mapNetworkModelToEntity(it)
        }


    fun mapListNetworkModelToListEntityCarousel(list: List<CarouselItemDTO>) =
        list.map {
            mapNetworkModelToEntityCarousel(it)
        }

}