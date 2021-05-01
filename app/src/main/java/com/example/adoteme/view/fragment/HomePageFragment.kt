package com.example.adoteme.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.example.adoteme.R
import com.example.adoteme.model.Publication
import com.example.adoteme.utils.SpinnerListener
import com.example.adoteme.view.adapter.HomePageAdapter
import com.example.adoteme.viewmodel.HomePageViewModel
import com.example.adoteme.viewmodel.HomePageViewModelFactory
import kotlinx.android.synthetic.main.activity_home_page.*
import okhttp3.internal.notify
import okhttp3.internal.notifyAll

class HomePageFragment : Fragment() {

    private lateinit var adapterHomePage: HomePageAdapter

    private val viewModel: HomePageViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home_page, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.homePageRecyclerView)

        adapterHomePage = HomePageAdapter(getPublications())
        recyclerView.adapter = adapterHomePage

        viewModel.reloadPublication.observe(viewLifecycleOwner, {
            adapterHomePage = HomePageAdapter(getPublications())
            recyclerView.adapter = adapterHomePage
            adapterHomePage.notifyDataSetChanged()
        })

        return root
    }

    fun getPublications(): List<Publication> {
        return viewModel.publicationList
    }

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
    }
}