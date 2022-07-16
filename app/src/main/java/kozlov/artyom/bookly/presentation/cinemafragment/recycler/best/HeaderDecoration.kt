package kozlov.artyom.bookly.presentation.cinemafragment.recycler.best

import android.content.Context
import android.graphics.Canvas

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class HeaderDecoration(context: Context?, parent: RecyclerView?, @LayoutRes resId: Int) : ItemDecoration() {
    private val mLayout: View


    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        // layout basically just gets drawn on the reserved space on top of the first view
        mLayout.layout(parent.left, 0, parent.right, mLayout.measuredHeight)
        for (i in 0 until parent.childCount) {
            val view: View = parent.getChildAt(i)
            if (parent.getChildAdapterPosition(view) == 0) {
                c.save()
                val height: Float = mLayout.measuredHeight.toFloat()
                val top: Float = view.top - height
                c.translate(0f, top)
                mLayout.draw(c)
                c.restore()
                break
            }
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.set(0, mLayout.measuredHeight, 0, 0)
        } else {
            outRect.setEmpty()
        }
    }


    init {
        // inflate and measure the layout
        mLayout = LayoutInflater.from(context).inflate(resId, parent, false)
        mLayout.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        )
    }
}