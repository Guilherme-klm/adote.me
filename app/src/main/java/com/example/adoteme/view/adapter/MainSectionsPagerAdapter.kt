package com.example.adoteme.view.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.adoteme.view.fragment.HomePageFragment

class MainSectionsPagerAdapter(private val lifecycle: Lifecycle, fm: FragmentManager) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return 1
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> createFragmentWithSectionNumber(HomePageFragment(), position)
            else -> throw IllegalAccessException("Posição desconhecida")
        }
    }

    private fun createFragmentWithSectionNumber(fragment: Fragment, position: Int) : Fragment {
        return fragment.apply {
            arguments = Bundle().apply {
                putInt(HomePageFragment.ARG_SECTION_NUMBER, position + 1)
            }
        }
    }
}