package com.example.viewmodelrepomemoryleak

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.viewmodelrepomemoryleak.viewmodels.LiveDataMainFactory
import com.example.viewmodelrepomemoryleak.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels({ requireActivity() }) { LiveDataMainFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.id.observe(viewLifecycleOwner, Observer {
            message.text = getString(R.string.mainfragment, it)
        })

        next.setOnClickListener {
            startActivity(Intent(context, NextActivity::class.java))
        }

    }

    companion object {
        fun newInstance() = MainFragment()
    }

}