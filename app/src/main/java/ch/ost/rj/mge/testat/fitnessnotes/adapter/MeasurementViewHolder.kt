package ch.ost.rj.mge.testat.fitnessnotes.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MeasurementViewHolder(
    parent: View?,
    var dateTextView: TextView,
    var measurementTextView: TextView
) : RecyclerView.ViewHolder(parent!!)
