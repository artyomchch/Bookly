package kozlov.artyom.bookly.presentation.cinemafragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kozlov.artyom.bookly.domain.entity.BestItem
import kozlov.artyom.bookly.domain.entity.CarouselItem
import kozlov.artyom.bookly.domain.usecases.GetBestItemsFromNetworkUseCase
import kozlov.artyom.bookly.domain.usecases.GetCarouselItemsFromNetworkUseCase
import javax.inject.Inject

class CinemaFragmentViewModel @Inject constructor(
    getBestItemsFromNetworkUseCase: GetBestItemsFromNetworkUseCase,
    getCarouselItemsFromNetworkUseCase: GetCarouselItemsFromNetworkUseCase
) : ViewModel() {

    private val _valueItemsBest = MutableLiveData<List<BestItem>>()
    val valueItemsBest: LiveData<List<BestItem>>
        get() = _valueItemsBest

    private val _valueItemsCarousel = MutableLiveData<List<CarouselItem>>()
    val valueItemsCarousel: LiveData<List<CarouselItem>>
        get() = _valueItemsCarousel


    init {
        viewModelScope.launch {
            _valueItemsBest.value = getBestItemsFromNetworkUseCase.invoke()
            _valueItemsCarousel.value =  getCarouselItemsFromNetworkUseCase.invoke()
        }
    }

}