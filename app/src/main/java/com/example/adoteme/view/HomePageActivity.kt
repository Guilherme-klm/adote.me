package com.example.adoteme.view

import android.R.layout
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.example.adoteme.R
import com.example.adoteme.databinding.ActivityHomePageBinding
import com.example.adoteme.utils.SpinnerListener
import com.example.adoteme.view.adapter.HomePageAdapter
import com.example.adoteme.view.adapter.MainSectionsPagerAdapter
import com.example.adoteme.view.fragment.HomePageFragment
import com.example.adoteme.viewmodel.HomePageViewModel
import com.example.adoteme.viewmodel.HomePageViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home_page.*


class HomePageActivity : AppCompatActivity() {

    private val homePagerViewModel: HomePageViewModel by viewModels {
        HomePageViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val binding: ActivityHomePageBinding = DataBindingUtil.setContentView(this, R.layout.activity_home_page)
        binding.homePagerViewModel = homePagerViewModel

        val sectionsPagerAdapter = MainSectionsPagerAdapter(lifecycle, supportFragmentManager)
        pager.adapter = sectionsPagerAdapter

        val spinner: Spinner = findViewById(R.id.spinner_localization)
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.localizations, layout.simple_spinner_item)
        adapter.setDropDownViewResource(layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = SpinnerListener.onItemSelectedListener(homePagerViewModel::selectPositionListLocalization)
    }

    fun redirectCreatePublication(view: View) {
        var intent = Intent(this, CreatePublicationActivity::class.java)
        startActivity(intent)
    }

    fun search(view: View) {
        homePagerViewModel.search()
    }
}