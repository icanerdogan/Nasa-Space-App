package com.ibrahimcanerdogan.nasaspaceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ibrahimcanerdogan.nasaspaceapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.fragmentContainerView)
        // If you want a change app bar name according to fragment name.
        //val appBarConfiguration = AppBarConfiguration(setOf(R.id.astronomyFragment, R.id.marsRoverFragment, R.id.earthFragment))
        //setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)
    }
}