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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationprojectexample.R
import com.example.navigationprojectexample.databinding.FragmentActionABinding
import com.example.navigationprojectexample.databinding.FragmentActionBBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentActionB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentActionB : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentActionBBinding


    private val argSafe: FragmentActionBArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        Log.d(TAG, "onCreate: B")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_action_b, container, false)

        Log.d(TAG, "onCreateView: B")
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.btnC.setOnClickListener(View.OnClickListener {

            val listInt = listOf(1, 2, 3)
            val action = FragmentActionBDirections.actionFragmentActionBToFragmentActionC(listInt.toIntArray())
            findNavController().navigate(action)

//            findNavController().navigate(R.id.action_fragmentActionB_to_fragmentActionC)
        })

//        Log.d("giangtd", "onActivityCreated: " + argSafe.data)

        Log.d(TAG, "onActivityCreated: B")

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = FragmentActionB().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }

    val TAG = "giangtd"
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach: B")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach: B")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: B")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: B")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "onActivityResult: B")
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)

        Log.d(TAG, "onAttachFragment: B")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: B")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: B")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: B")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: B")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: B")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: B")
    }

}