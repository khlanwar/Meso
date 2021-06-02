package com.cap481.meso.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cap481.meso.databinding.FragmentHomeBinding
import com.cap481.meso.utils.DataDummy
import com.cap481.meso.utils.MentalAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val mentals = DataDummy.generateDummyMental()
            val mentalAdapter = MentalAdapter()
            mentalAdapter.setMentals(mentals)

            with(binding.rvMentalIllness) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = mentalAdapter
            }
        }
    }
}