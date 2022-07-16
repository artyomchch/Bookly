package kozlov.artyom.bookly.data.network

import kozlov.artyom.bookly.data.network.pojo.BestDTO
import kozlov.artyom.bookly.data.network.pojo.CarouselDTO
import retrofit2.http.GET

interface CurrencyApi {
    @GET("carousel")
    suspend fun getCarousel(): CarouselDTO

    @GET("best")
    suspend fun getBest(): BestDTO

    @GET("similar")
    suspend fun getSimilar(): CarouselDTO
}