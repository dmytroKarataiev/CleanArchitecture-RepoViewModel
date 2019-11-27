package com.example.viewmodelrepomemoryleak.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.viewmodelrepomemoryleak.LiveDataMainFactory
import com.example.viewmodelrepomemoryleak.MainViewModel
import com.example.viewmodelrepomemoryleak.NextActivity
import com.example.viewmodelrepomemoryleak.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    val TAG = MainFragment::class.java.simpleName

    private val viewModel: MainViewModel by viewModels { LiveDataMainFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.setId(1000L)
        viewModel.id.observe(viewLifecycleOwner, Observer {
            Log.v(TAG, "Long: $it")
        })

        next.setOnClickListener {
            startActivity(Intent(context, NextActivity::class.java))
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}