package kozlov.artyom.bookly.presentation.aboutfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kozlov.artyom.bookly.domain.entity.CarouselItem
import kozlov.artyom.bookly.domain.usecases.GetLikeItemsFromNetworkUseCase
import javax.inject.Inject

class CinemaAboutFragmentViewModel @Inject constructor(
    getLikeItemsFromNetworkUseCase: GetLikeItemsFromNetworkUseCase
) : ViewModel() {

    private val _valueItemsLike = MutableLiveData<List<CarouselItem>>()
    val valueItemsLike: LiveData<List<CarouselItem>>
        get() = _valueItemsLike


    init {
        viewModelScope.launch {
            _valueItemsLike.value = getLikeItemsFromNetworkUseCase.invoke()
        }
    }
}