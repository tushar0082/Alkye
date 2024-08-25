package com.example.alkye.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import com.example.alkye.R
import com.example.alkye.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        // Example for edge-to-edge support (optional, uncomment if needed)
        // enableEdgeToEdge()

        // Navigation with delay
        lifecycleScope.launch {
            delay(3000)
            navController.navigate(R.id.action_splashFragment_to_fragmentLogin, null, navOptions {
                popUpTo(R.id.splashFragment) {
                    inclusive = true
                }
            })
        }
    }
}
