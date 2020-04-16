package com.joel.agoraprototype.election

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.joel.agoraprototype.R

class ElectionExpandAdapter(var context: Context,
                            var electionDetails: ArrayList<ElectionDetails>, var fragmentManager: FragmentManager): BaseAdapter() {

    private class ViewHolder(row: View?) {
        var card: ConstraintLayout
        var electionNumber: TextView
        var electionName: TextView
        var electionDeadline: TextView
        var electionDesc: TextView
        var expandButton: Button
        var expandView: ConstraintLayout
        var electionCard: CardView
        var options: TextView
        init {
            this.card = row?.findViewById(R.id.compressed_view) as ConstraintLayout
            this.electionNumber = row.findViewById(R.id.card_election_number) as TextView
            this.electionName = row.findViewById(R.id.card_election_name) as TextView
            this.electionDeadline = row.findViewById(R.id.card_election_deadline) as TextView
            this.electionDesc = row.findViewById(R.id.card_election_desc_content) as TextView
            this.expandButton = row.findViewById(R.id.bt_card_expand) as Button
            this.expandView = row.findViewById(R.id.expanded_view) as ConstraintLayout
            this.electionCard = row.findViewById(R.id.election_card) as CardView
            this.options = row.findViewById(R.id.bt_card_options) as TextView
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.election_details_cardview, parent, false)
            viewHolder =
                ViewHolder(
                    view
                )
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var electionDetail: ElectionDetails = getItem(position) as ElectionDetails
        var temp = position + 1

        viewHolder.electionNumber.text = temp.toString()
        viewHolder.electionName.text = electionDetail.name
        viewHolder.electionDesc.text = electionDetail.desc
        viewHolder.expandButton.setOnClickListener {
           expandCardFn(viewHolder)
        }
        viewHolder.electionName.setOnClickListener {
            expandCardFn(viewHolder)
        }
        viewHolder.electionNumber.setOnClickListener {
            expandCardFn(viewHolder)
        }
        viewHolder.electionDeadline.setOnClickListener {
            expandCardFn(viewHolder)
        }
        viewHolder.options.setOnClickListener {
            val bottomSheet: ElectionBottomSheet = ElectionBottomSheet()
            bottomSheet.show(fragmentManager, "BottomSheet")
        }

        return view as View
    }

    override fun getItem(position: Int): Any {
        return electionDetails.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return electionDetails.size
    }

    private fun expandCardFn(viewHolder: ViewHolder) {
        if (viewHolder.expandView.visibility == View.GONE) {
            TransitionManager.beginDelayedTransition(viewHolder.electionCard,AutoTransition())
            viewHolder.expandView.visibility = View.VISIBLE
            viewHolder.expandButton.setBackgroundResource(R.drawable.arrow_up)
        } else {
            TransitionManager.beginDelayedTransition(viewHolder.electionCard,AutoTransition())
            viewHolder.expandView.visibility = View.GONE
            viewHolder.expandButton.setBackgroundResource(R.drawable.arrow_down)
        }
    }
}