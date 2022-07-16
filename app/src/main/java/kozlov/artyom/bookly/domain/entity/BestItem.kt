package kozlov.artyom.bookly.domain.entity

data class BestItem(
    val id: Int,
    val image: String,
    val title: String,
    val author: String,
    val price: Double,
    val score: Double,
    val amount: Int

): ListMarker
