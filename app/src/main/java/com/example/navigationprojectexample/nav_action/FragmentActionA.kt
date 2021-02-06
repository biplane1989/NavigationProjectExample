package com.example.navigationprojectexample.nav_action

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.navigationprojectexample.R
import com.example.navigationprojectexample.databinding.FragmentActionABinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentActionA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentActionA : Fragment() {

    private lateinit var binding: FragmentActionABinding

    private lateinit var fragmentViewModel: FragmentViewModel
    val TAG = "giangtd"


    private val exampleObserver = Observer<Int> {
        Log.d(TAG, "coutn : " + it)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_action_a, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated: A")

        binding.btnB.setOnClickListener(View.OnClickListener {
            val action = FragmentActionADirections.actionFragmentActionAToFragmentActionB(1)
            findNavController().navigate(action)

//            findNavController().navigate(R.id.action_fragmentActionA_to_fragmentActionB)
        })

        binding.btnC.setOnClickListener(View.OnClickListener {

            val listInt = listOf(1, 2, 3)
            val action = FragmentActionADirections.actionFragmentActionAToFragmentActionC(listInt.toIntArray())
            findNavController().navigate(action)
        })

        binding.btnE.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_fragmentActionA_to_fragmentActionE)
        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentViewModel = ViewModelProvider(this)[FragmentViewModel::class.java]
        fragmentViewModel.getLivedata().observe(viewLifecycleOwner, exampleObserver)
//        fragmentViewModel.runDemo()
    }

}