package kozlov.artyom.bookly.presentation.cinemafragment.recycler.best

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import kozlov.artyom.bookly.databinding.BestItemBinding
import kozlov.artyom.bookly.domain.entity.BestItem
import kozlov.artyom.bookly.utils.amount
import kozlov.artyom.bookly.utils.euro
import kozlov.artyom.bookly.utils.setImage

class MovieItemAdapter : ListAdapter<BestItem, MovieItemViewHolder>(MovieItemDiffCallback()) {

    var onValueItemClickListener: ((BestItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val binding = BestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieItemViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            imageUrl.setImage(root.context, item.image)
            title.text = item.title
            author.text = item.author
            price.text = item.price.toString().euro(root.context)
            score.text = item.score.toString()
            amount.text = item.amount.toString().amount(root.context)
        }

        holder.itemView.setOnClickListener {
            onValueItemClickListener?.invoke(item)
        }


    }


}