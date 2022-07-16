package kozlov.artyom.bookly.domain.usecases

import kozlov.artyom.bookly.domain.entity.BestItem
import kozlov.artyom.bookly.domain.repository.MovieRepository
import javax.inject.Inject

class GetBestItemsFromNetworkUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(): List<BestItem> = movieRepository.getBestList()
}