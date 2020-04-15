package com.joel.agoraprototype.election

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.joel.agoraprototype.MainActivity
import com.joel.agoraprototype.R
import com.joel.agoraprototype.utilities.toastSuccess
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.election_bottom_sheet.view.*

class ElectionBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.election_bottom_sheet, container, false)

        view.bt_generate_election_link.setOnClickListener {
            context!!.toastSuccess("Voting URL copied to clipboard!")
            dismiss()
        }

        view.bt_invite_voters.setOnClickListener {
            context!!.toastSuccess("invite voters dialog")
            dismiss()
        }

        view.bt_voters.setOnClickListener {
            context!!.toastSuccess("fetch voters from api")
            dismiss()
        }

        view.bt_delete_election.setOnClickListener {
            context!!.toastSuccess("delete election")
            dismiss()
        }
        return view
    }

}