package com.joel.agoraprototype.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.joel.agoraprototype.election.ElectionDetails
import com.joel.agoraprototype.election.ElectionExpandAdapter
import com.joel.agoraprototype.R

class ElectionFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_election, container, false)

        var elections: ArrayList<ElectionDetails> = ArrayList()
        elections.add(
            ElectionDetails(
                "Election 1",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mauris justo, venenatis in tristique vitae, consectetur volutpat augue. Integer non dui suscipit, vulputate libero quis",
                "05/03/2020 15:03PM",
                "08/03/2020 14:30PM",
                "Justin Mathew\nJoel Mathew"
            )
        )
        elections.add(
            ElectionDetails(
                "Election 1",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mauris justo, venenatis in tristique vitae, consectetur volutpat augue. Integer non dui suscipit, vulputate libero quis",
                "05/03/2020 15:03PM",
                "08/03/2020 14:30PM",
                "Justin Mathew\nJoel Mathew"
            )
        )
        //this fragment manager is for the bottom sheet in election fragment
        var fragmentManager: FragmentManager = parentFragmentManager
        var electionDetailsList = view.findViewById(R.id.list_expand_elections) as ListView
        electionDetailsList.adapter =
            ElectionExpandAdapter(
                requireContext(),
                elections,
                fragmentManager
            )
        return view
    }
}