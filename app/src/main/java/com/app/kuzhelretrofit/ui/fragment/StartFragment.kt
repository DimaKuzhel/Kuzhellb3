package com.app.kuzhelretrofit.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.kuzhelretrofit.databinding.FragmentListBinding
import com.app.kuzhelretrofit.ui.viewmodel.FirstViewModel


class StartFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    private val viewModelCustomed by viewModels<FirstViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            viewModelCustomed.start()
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelCustomed.destination.observe(viewLifecycleOwner) { status ->
            if (status != null) {
                val action = StartFragmentDirections.actionFirstFragmentToDetailFragment()
                findNavController().navigate(action)
            }
        }


    }
}