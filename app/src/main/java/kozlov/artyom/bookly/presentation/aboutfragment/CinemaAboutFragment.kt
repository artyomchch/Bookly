package kozlov.artyom.bookly.presentation.aboutfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kozlov.artyom.bookly.R


class CinemaAboutFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cinema_about, container, false)
    }

    companion object {

        fun newInstance(image: String, title: String, author: String) =
            CinemaAboutFragment().apply {
                arguments = Bundle().apply {
                    this.putString(IMAGE, image)
                    this.putString(TITLE, title)
                    this.putString(AUTHOR, author)
                }
            }


        private const val IMAGE = "image"
        private const val TITLE = "title"
        private const val AUTHOR = "author"
    }
}