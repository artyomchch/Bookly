package kozlov.artyom.bookly.presentation.cinemafragment.recycler.best

import androidx.recyclerview.widget.DiffUtil
import kozlov.artyom.bookly.domain.entity.BestItem


class MovieItemDiffCallback : DiffUtil.ItemCallback<BestItem>() {
    override fun areItemsTheSame(oldItem: BestItem, newItem: BestItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BestItem, newItem: BestItem): Boolean {
        return oldItem.id == newItem.id
    }


}
