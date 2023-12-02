package com.app.kuzhelretrofit.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.app.kuzhelretrofit.databinding.FragmentDetailsBinding
import com.app.kuzhelretrofit.ui.recyclerview.CustomAdapter
import com.app.kuzhelretrofit.ui.viewmodel.RecycleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding

    val detailViewModel: RecycleViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclers.setHasFixedSize(true)
        binding.recyclers.layoutManager = LinearLayoutManager(requireContext())
        detailViewModel.projectsLiveData.observe(viewLifecycleOwner) { status ->
            binding.recyclers.adapter = CustomAdapter(requireContext(), status)
        }
    }
}