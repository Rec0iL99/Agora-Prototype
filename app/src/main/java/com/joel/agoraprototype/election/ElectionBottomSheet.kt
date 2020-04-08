package com.joel.agoraprototype.election

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.election_bottom_sheet.view.*

class ElectionBottomSheet : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.election_bottom_sheet, container, false)

        view.bt_generate_election_link.setOnClickListener {
            Toast.makeText(activity, "Link copied to clipboard", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        view.bt_invite_voters.setOnClickListener {
            Toast.makeText(activity, "Voter invite class", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        view.bt_voters.setOnClickListener {
            Toast.makeText(activity, "Voters will be displayed", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        view.bt_delete_election.setOnClickListener {
            Toast.makeText(activity, "Election has been deleted", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        return view
    }

}