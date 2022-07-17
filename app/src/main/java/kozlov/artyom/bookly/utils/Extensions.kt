package kozlov.artyom.bookly.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import kozlov.artyom.bookly.R


fun String.euro(context: Context):String {
    return this + context.getString(R.string.euro)
}

fun String.amount(context: Context):String {
    return  context.getString(R.string.right) + this + context.getString(R.string.left)
}

fun ShapeableImageView.setImage(context: Context, url: String){
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.img)
        .centerCrop()
        .into(this)
}

fun ImageView.setImage(context: Context, url: String){
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.img)
        .centerCrop()
        .into(this)
}
