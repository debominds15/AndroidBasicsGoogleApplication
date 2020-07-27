package com.example.testapplication.viewmodelcourse.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testapplication.R
import com.example.testapplication.databinding.FragmentTitleNewBinding


/**
 * Fragment for the starting or title screen of the app
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: FragmentTitleNewBinding = DataBindingUtil.inflate<FragmentTitleNewBinding>(
            inflater, R.layout.fragment_title_new, container, false)


        binding.playGameButton.setOnClickListener {
            findNavController().navigate(TitleFragmentDirections.actionTitleToGame())
        }
        return binding.root
    }
}