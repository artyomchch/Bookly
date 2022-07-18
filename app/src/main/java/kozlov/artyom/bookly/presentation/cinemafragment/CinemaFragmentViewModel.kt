package kozlov.artyom.bookly.presentation.cinemafragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kozlov.artyom.bookly.domain.entity.BestItem
import kozlov.artyom.bookly.domain.entity.CarouselItem
import kozlov.artyom.bookly.domain.usecases.GetBestItemsFromNetworkUseCase
import kozlov.artyom.bookly.domain.usecases.GetCarouselItemsFromNetworkUseCase
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject
import kotlin.math.log

class CinemaFragmentViewModel @Inject constructor(
    getBestItemsFromNetworkUseCase: GetBestItemsFromNetworkUseCase,
    getCarouselItemsFromNetworkUseCase: GetCarouselItemsFromNetworkUseCase
) : ViewModel() {

    private val _valueItemsBest = MutableLiveData<FilmObserver<List<BestItem>>>()
    val valueItemsBest: LiveData<FilmObserver<List<BestItem>>>
        get() = _valueItemsBest

    private val _valueItemsCarousel = MutableLiveData<FilmObserver<List<CarouselItem>>>()
    val valueItemsCarousel: LiveData<FilmObserver<List<CarouselItem>>>
        get() = _valueItemsCarousel



    private val deferredBest: Deferred<List<BestItem>> = viewModelScope.async {
        getBestItemsFromNetworkUseCase.invoke()
    }

    private val deferredCarousel: Deferred<List<CarouselItem>> = viewModelScope.async {
        getCarouselItemsFromNetworkUseCase.invoke()
    }

    init {
        viewModelScope.launch {
            try {
                _valueItemsBest.value =  FilmObserver.Success(deferredBest.await())
                _valueItemsCarousel.value =  FilmObserver.Success(deferredCarousel.await())
            } catch (e: UnknownHostException) {
                _valueItemsCarousel.value = FilmObserver.Error()
                _valueItemsBest.value = FilmObserver.Error()

            }



        }
    }

}