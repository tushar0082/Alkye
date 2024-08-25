package com.example.alkye.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alkye.CardAdapter
import com.example.alkye.CarsModel
import com.example.alkye.R
import com.example.alkye.databinding.FragmentCarViewBinding
import com.example.alkye.generateSampleData

class FragmentCarView : Fragment() {

    // ViewBinding instance
    private var _binding: FragmentCarViewBinding? = null
    private val binding get() = _binding!!

    private lateinit var horizontalAdapter: CardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using ViewBinding
        _binding = FragmentCarViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerViews()
        binding.ivBack.setOnClickListener{
            findNavController().popBackStack()
        }
    }
    private fun setupRecyclerViews() {
        // Sample data
        val sampleData = generateSampleData()

        // Horizontal RecyclerView 1
        horizontalAdapter = CardAdapter(sampleData) { item ->
            handleItemClick(item)
        }
        binding.rvRecent.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvRecent.adapter = horizontalAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up binding reference to avoid memory leaks
        _binding = null
    }
    private fun handleItemClick(item: CarsModel) {

        findNavController().navigate(R.id.fragmentCarView)
    }


}
