package kozlov.artyom.bookly.presentation.aboutfragment.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import kozlov.artyom.bookly.databinding.LikeItemBinding
import kozlov.artyom.bookly.domain.entity.CarouselItem
import kozlov.artyom.bookly.presentation.cinemafragment.recycler.carousel.HeaderItemDiffCallback
import kozlov.artyom.bookly.utils.setImage

class LikeItemAdapter : ListAdapter<CarouselItem, LikeItemViewHolder>(HeaderItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikeItemViewHolder {
        val binding = LikeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LikeItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LikeItemViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.binding.root.setImage(holder.binding.root.context, item.image)
    }


}
