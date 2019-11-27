package com.example.viewmodelrepomemoryleak.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.viewmodelrepomemoryleak.R

class NextFragment : Fragment() {

    val TAG = NextFragment::class.java.simpleName

    private val viewModel: MainViewModel by viewModels { LiveDataMainFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.next_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.setId(9900L)
        viewModel.staffer.observe(viewLifecycleOwner, Observer {
            Log.v(TAG, "Long: $it")
        })
    }

    companion object {
        fun newInstance() = NextFragment()
    }

}
