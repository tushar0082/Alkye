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
import com.example.alkye.databinding.FragmentDashboardBinding
import com.example.alkye.generateSampleData

class FragmentDashboard : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private lateinit var horizontalAdapter: CardAdapter
    private lateinit var verticalAdapter: CardAdapter
    private lateinit var horizontalAdapter2: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // Handle arguments if any
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerViews
        setupRecyclerViews()
    }

    private fun setupRecyclerViews() {
        // Sample data
        val sampleData = generateSampleData()

        // Horizontal RecyclerView 1
        horizontalAdapter = CardAdapter(sampleData) { item ->
            handleItemClick(item)
        }
        binding.rvCars.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCars.adapter = horizontalAdapter

        // Vertical RecyclerView
        verticalAdapter = CardAdapter(sampleData,false) { item ->
            handleItemClick(item)
        }
        binding.rvRecent.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvRecent.adapter = verticalAdapter

        // Horizontal RecyclerView 2
        horizontalAdapter2 = CardAdapter(sampleData, showIcons = true) { item ->
            handleItemClick(item)
        }
        binding.rvSocialConnect.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvSocialConnect.adapter = horizontalAdapter2
    }

    private fun handleItemClick(item: CarsModel) {

        findNavController().navigate(R.id.action_fragmentDashboard_to_fragmentCarView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
