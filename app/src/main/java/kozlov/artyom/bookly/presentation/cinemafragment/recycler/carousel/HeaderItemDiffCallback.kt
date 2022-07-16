package kozlov.artyom.bookly.presentation.cinemafragment.recycler.carousel

import androidx.recyclerview.widget.DiffUtil
import kozlov.artyom.bookly.domain.entity.CarouselItem

class HeaderItemDiffCallback: DiffUtil.ItemCallback<CarouselItem>() {
    override fun areItemsTheSame(oldItem: CarouselItem, newItem: CarouselItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CarouselItem, newItem: CarouselItem): Boolean {
        return oldItem.id == newItem.id
    }
}