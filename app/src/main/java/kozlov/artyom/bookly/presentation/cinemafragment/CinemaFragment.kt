package kozlov.artyom.bookly.presentation.cinemafragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kozlov.artyom.bookly.R
import kozlov.artyom.bookly.databinding.FragmentCinemaBinding
import kozlov.artyom.bookly.domain.entity.BestItem
import kozlov.artyom.bookly.domain.entity.CarouselItem
import kozlov.artyom.bookly.presentation.ViewModelFactory
import kozlov.artyom.bookly.presentation.cinemafragment.recycler.best.HeaderDecoration
import kozlov.artyom.bookly.presentation.cinemafragment.recycler.carousel.HeaderItemAdapter
import kozlov.artyom.bookly.presentation.cinemafragment.recycler.best.MovieItemAdapter
import kozlov.artyom.bookly.presentation.cinemafragment.recycler.carousel.SnapHelper
import kozlov.artyom.bookly.presentation.cinemafragment.recycler.carousel.StartZoomLinearManager
import kozlov.artyom.bookly.utils.App
import java.lang.Math.abs
import javax.inject.Inject


class CinemaFragment : Fragment() {


    private lateinit var movieListAdapter: MovieItemAdapter
    private lateinit var headerListAdapter: HeaderItemAdapter



    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[(CinemaFragmentViewModel::class.java)]
    }

    private var _binding: FragmentCinemaBinding? = null
    private val binding: FragmentCinemaBinding
        get() = _binding ?: throw RuntimeException("FragmentCinemaBinding == null")

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

        _binding = FragmentCinemaBinding.inflate(inflater, container, false)


        setupRecyclerView()
        observeValuesRecycler()


        return binding.root
    }

    private fun observeValuesRecycler() {
        viewModel.valueItemsBest.observe(viewLifecycleOwner){
            val duplicate : List<BestItem> = mutableListOf<BestItem>().apply {
                addAll(it)
                addAll(it)
                addAll(it)
            }

            movieListAdapter.submitList(duplicate)
            Log.d("TAG", "observeValuesRecycler: ${it}.")
        }
        viewModel.valueItemsCarousel.observe(viewLifecycleOwner){
            val duplicate : List<CarouselItem> = mutableListOf<CarouselItem>().apply {
                addAll(it)
                addAll(it)
                addAll(it)
            }
            headerListAdapter.submitList(duplicate)
        }

    }


    private fun setupRecyclerView() {


        with(binding.listRecyclerCarousel) {
            headerListAdapter = HeaderItemAdapter()
            adapter = headerListAdapter
            val snapHelper = SnapHelper()
            snapHelper.attachToRecyclerView(this)
            layoutManager = StartZoomLinearManager(requireContext())

        }

        with(binding.listRecyclerBest) {
            movieListAdapter = MovieItemAdapter()
            adapter = movieListAdapter
            addItemDecoration(HeaderDecoration(context, this, R.layout.header))

            movieListAdapter.onValueItemClickListener = {
                requireActivity().supportFragmentManager.popBackStack()
                requireActivity().supportFragmentManager.beginTransaction()
                  //  .replace()
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}