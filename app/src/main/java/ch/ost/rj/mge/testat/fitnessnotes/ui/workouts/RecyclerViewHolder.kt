package ch.ost.rj.mge.testat.fitnessnotes.ui.workouts

import android.R
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.frame_textview.view.*


class RecyclerViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    var view: TextView

    init {
        view = itemView.randomText
    }
}