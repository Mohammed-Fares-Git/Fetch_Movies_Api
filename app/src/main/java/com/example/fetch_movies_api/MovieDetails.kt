package com.example.fetch_movies_api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fradmentstutos.databinding.FragmentFrg2Binding


class Frg2 : Fragment() {
    private var frg2Binding: FragmentFrg2Binding? = null
    private val sharedeViewModel: FilmViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        frg2Binding = FragmentFrg2Binding.inflate(inflater, container, false)
        /* sharedeViewModel = new ViewModelProvider(requireActivity()).get(CarOperatingCostCalculatorViewModel.class);

        sharedeViewModel.getCarOperatingCostMutableLiveData().observe(getViewLifecycleOwner(), new Observer<CarOperatingCost>() {
            @Override
            public void onChanged(CarOperatingCost carOperatingCost) {
                frg2Binding.tvKilometersPerYear.setText(String.valueOf(carOperatingCost.getKilometersPerYear()));
                frg2Binding.tvEngineDisplacement.setText(String.valueOf(carOperatingCost.getEngineDisplacement()));
                frg2Binding.tvFuelType.setText(carOperatingCost.getFuelType());
                fr g2Binding.tvResult.setText("Monthly operating cost: " +String.format("%.2f", carOperatingCost.calculateMonthlyCost())+" euros");
            }
        });
*/return frg2Binding.getRoot()
    }
}}