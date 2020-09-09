package com.example.composeweatherapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.composeweatherapp.core.di.ViewModelProviderFactory
import javax.inject.Inject

class HistoryWeatherFragment : Fragment() {

    @Inject
    lateinit var providerFactory : ViewModelProviderFactory

    companion object {
        fun newInstance() = HistoryWeatherFragment()
    }

    private lateinit var viewModel: HistoryWeatherViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.history_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(HistoryWeatherViewModel::class.java)
        viewModel = ViewModelProviders.of(this, providerFactory).get(HistoryWeatherViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }


}