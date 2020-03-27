package com.joel.agoraprototype.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.joel.agoraprototype.home.ElectionCount
import com.joel.agoraprototype.home.ElectionCountAdapter
import com.joel.agoraprototype.R

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        val elections: ArrayList<ElectionCount> = ArrayList()
        elections.add(
            ElectionCount(
                R.drawable.all_elections,
                "Total Elections",
                "10"
            )
        )
        elections.add(
            ElectionCount(
                R.drawable.time,
                "Pending Elections",
                "6"
            )
        )
        elections.add(
            ElectionCount(
                R.drawable.play,
                "Active Elections",
                "2"
            )
        )
        elections.add(
            ElectionCount(
                R.drawable.done,
                "Finished Elections",
                "2"
            )
        )

        var electionList = view.findViewById(R.id.list_election_count) as ListView
        electionList.adapter = ElectionCountAdapter(
            requireContext(),
            elections
        )

        return view
    }
}