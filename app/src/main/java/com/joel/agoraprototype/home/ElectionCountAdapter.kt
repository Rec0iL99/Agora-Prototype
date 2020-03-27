package com.joel.agoraprototype.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.joel.agoraprototype.R

/*
    This class is an adapter for the election details in home fragment
*/
class ElectionCountAdapter(var context: Context,
                           var elections: ArrayList<ElectionCount>): BaseAdapter() {

    private class ViewHolder(row: View?) {
        var electionIcon: ImageView
        var electionType: TextView
        var electionCount: TextView

        init {
            this.electionIcon = row?.findViewById(R.id.election_icon) as ImageView
            this.electionType = row.findViewById(R.id.election_type) as TextView
            this.electionCount = row.findViewById(R.id.election_count) as TextView
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.election_list_item, parent, false)
            viewHolder =
                ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var electionCount: ElectionCount = getItem(position) as ElectionCount
        viewHolder.electionIcon.setImageResource(electionCount.icon)
        viewHolder.electionType.text = electionCount.type
        viewHolder.electionCount.text = electionCount.count
        return view as View
    }

    override fun getItem(position: Int): Any {
        return elections.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return elections.count()
    }
}