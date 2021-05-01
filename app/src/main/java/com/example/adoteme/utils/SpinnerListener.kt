package com.example.adoteme.utils

import android.view.View
import android.widget.AdapterView
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.BindingAdapter

object SpinnerListener {

    private const val SPINNER_SELECT_ITEM_POSITION = "android:selectedItemPosition"

    @JvmStatic
    @BindingAdapter(SPINNER_SELECT_ITEM_POSITION)
    fun AppCompatSpinner.selectedItemPosition(position: Int) {
        setSelection(position, true)
    }

    fun onItemSelectedListener(callback: (position: Int) -> Unit): AdapterView.OnItemSelectedListener{
        return object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                callback(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}