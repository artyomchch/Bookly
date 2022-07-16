package kozlov.artyom.bookly.domain.usecases

import kozlov.artyom.bookly.domain.entity.CarouselItem
import kozlov.artyom.bookly.domain.repository.MovieRepository
import javax.inject.Inject

class GetCarouselItemsFromNetworkUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(): List<CarouselItem> = movieRepository.getCarouselList()

}