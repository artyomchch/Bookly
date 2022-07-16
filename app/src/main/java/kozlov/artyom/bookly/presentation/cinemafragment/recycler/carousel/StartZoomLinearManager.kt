package kozlov.artyom.bookly.presentation.cinemafragment.recycler.carousel

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

class StartZoomLinearManager(
    context: Context,
    private val mShrinkDistance: Float = 1f,
    private val mShrinkAmount: Float = 0.14f
) : LinearLayoutManager(context, HORIZONTAL, false) {

    override fun onLayoutCompleted(state: RecyclerView.State?) {
        super.onLayoutCompleted(state)

    }

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {

        val orientation = orientation
        return if (orientation == HORIZONTAL) {
            val scrolled = super.scrollHorizontallyBy(dx, recycler, state)
            val midpoint = width / 5f
            val d0 = 0f
            val d1 = mShrinkDistance * midpoint
            val s0 = 1f
            val s1 = 1f - mShrinkAmount
            for (i in 0 until childCount) {
                val child = getChildAt(i)
                val childMidpoint = (getDecoratedRight(child!!) + getDecoratedLeft(child)) / 2f
                val d = d1.coerceAtMost(abs(midpoint - childMidpoint))
                val scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0)
                child.scaleX = scale
                child.scaleY = scale
            }
            scrolled
        } else 0
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        scrollHorizontallyBy(0, recycler, state)
        super.onLayoutChildren(recycler, state)
    }

}