package com.example.viewmodelrepomemoryleak

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.viewmodelrepomemoryleak.viewmodels.LiveDataMainFactory
import com.example.viewmodelrepomemoryleak.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.next_fragment.*

class NextFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels { LiveDataMainFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.next_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.setId(2)
        viewModel.id.observe(viewLifecycleOwner, Observer {
            message.text = getString(R.string.nextfragment, it)
        })

    }

    companion object {
        fun newInstance() = NextFragment()
    }

}