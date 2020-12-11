package com.example.navigationprojectexample.nav_importing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.navigationprojectexample.R
import com.example.navigationprojectexample.databinding.FragmentMainBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentA : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.btnB.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_fragmentA_to_fragmentB)
        })
        binding.btnC.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_fragmentA_to_fragmentC)
        })

        binding.btnD.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_global_fragmentD)
        })

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = FragmentA().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}