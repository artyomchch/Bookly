package kozlov.artyom.bookly.presentation.aboutfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kozlov.artyom.bookly.databinding.FragmentCinemaAboutBinding
import kozlov.artyom.bookly.presentation.ViewModelFactory
import kozlov.artyom.bookly.presentation.aboutfragment.recycler.LikeItemAdapter
import kozlov.artyom.bookly.utils.App
import kozlov.artyom.bookly.utils.setImage
import javax.inject.Inject


class CinemaAboutFragment : Fragment() {

    private lateinit var likeItemAdapter: LikeItemAdapter


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[(CinemaAboutFragmentViewModel::class.java)]
    }

    private var _binding: FragmentCinemaAboutBinding? = null
    private val binding: FragmentCinemaAboutBinding
        get() = _binding ?: throw RuntimeException("FragmentCinemaAboutBinding == null")

    private val component by lazy {
        (requireActivity().application as App).component
    }


    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCinemaAboutBinding.inflate(inflater, container, false)

        setupViewInformation()
        setupCloseListener()
        setupRecyclerView()
        observeValuesRecycler()



        return binding.root
    }

    private fun setupCloseListener() {
        binding.close.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun setupViewInformation() {
        val item = requireArguments()
        with(binding.tickets) {
            imageUrl.setImage(requireContext(), item.getString(IMAGE).toString())
            author.text = item.getString(AUTHOR) ?: NO_INFORMATION
            title.text = item.getString(TITLE) ?: NO_INFORMATION
            rate.text = item.getString(RATE) ?: NO_INFORMATION
            amount.text = item.getString(AMOUNT) ?: NO_INFORMATION
            price.text = item.getString(PRICE) ?: NO_INFORMATION

        }
    }


    private fun observeValuesRecycler() {
        viewModel.valueItemsLike.observe(viewLifecycleOwner, likeItemAdapter::submitList)
    }


    private fun setupRecyclerView() {


        with(binding.tickets.listRecyclerCarousel) {
            likeItemAdapter = LikeItemAdapter()
            adapter = likeItemAdapter
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(image: String, title: String, author: String, rate: String, amount: String, price: String) =
            CinemaAboutFragment().apply {
                arguments = Bundle().apply {
                    this.putString(IMAGE, image)
                    this.putString(TITLE, title)
                    this.putString(AUTHOR, author)
                    this.putString(RATE, rate)
                    this.putString(AMOUNT, amount)
                    this.putString(PRICE, price)
                }
            }


        private const val IMAGE = "image"
        private const val TITLE = "title"
        private const val AUTHOR = "author"
        private const val RATE = "rate"
        private const val AMOUNT = "amount"
        private const val PRICE = "price"
        private const val NO_INFORMATION = "No information"
    }
}