package com.example.alkye.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.alkye.R
import com.example.alkye.databinding.FragmentLoginBinding

class FragmentLogin : Fragment() {

    // Declare the binding property
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialize the binding property
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        // Return the root view of the binding
        return binding.root
    }

    // Optional: Override onViewCreated to set up views or listeners
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btSignIn.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentDashboard)
        }
        binding.btSignUp.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentDashboard)
        }
    }
}
