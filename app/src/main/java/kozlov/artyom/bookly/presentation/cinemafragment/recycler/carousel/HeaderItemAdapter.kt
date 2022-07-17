package kozlov.artyom.bookly.presentation.cinemafragment.recycler.carousel


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import kozlov.artyom.bookly.R
import kozlov.artyom.bookly.databinding.CarouselItemBinding
import kozlov.artyom.bookly.domain.entity.CarouselItem
import kozlov.artyom.bookly.utils.setImage

class HeaderItemAdapter: ListAdapter<CarouselItem, HeaderItemViewHolder>(HeaderItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderItemViewHolder {
        val binding = CarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeaderItemViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.binding.carouselPoster.setImage(holder.binding.root.context, item.image)
    }
}