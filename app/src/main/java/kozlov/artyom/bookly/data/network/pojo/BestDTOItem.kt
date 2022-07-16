package kozlov.artyom.bookly.data.network.pojo

data class BestDTOItem(
    val author: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rate: Rate,
    val title: String
)