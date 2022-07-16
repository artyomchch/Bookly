package kozlov.artyom.bookly.presentation.cinemafragment.recycler.best

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import kozlov.artyom.bookly.R
import kozlov.artyom.bookly.databinding.BestItemBinding
import kozlov.artyom.bookly.domain.entity.BestItem

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
            Glide.with(root)
                .load(item.image)
                .placeholder(R.drawable.img)
                .centerCrop()
                .into(imageUrl)
            title.text = item.title
            author.text = item.author
            price.text = item.price.toString() + root.context.getString(R.string.euro)
            score.text = item.score.toString()
            amount.text = root.context.getString(R.string.right) + item.amount.toString() + root.context.getString(R.string.left)
        }

        holder.itemView.setOnClickListener {
            onValueItemClickListener?.invoke(item)
        }


    }


}