package ch.ost.rj.mge.testat.fitnessnotes.adapter

import android.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.testat.fitnessnotes.model.Measurement

class MeasurementAdapter(measurements: ArrayList<Measurement>) :
    RecyclerView.Adapter<MeasurementViewHolder>() {
    private var measurements: ArrayList<Measurement>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeasurementViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(
            R.layout.simple_list_item_2,
            parent,
            false
        )
        val dateTextView = view.findViewById<TextView>(R.id.text1)
        val measurementTextView = view.findViewById<TextView>(R.id.text2)
        return MeasurementViewHolder(view, dateTextView, measurementTextView)
    }

    override fun onBindViewHolder(holder: MeasurementViewHolder, position: Int) {
        val meas: Measurement = measurements[position]
        holder.dateTextView.setText(meas.date)
        holder.measurementTextView.setText(meas.measure)
    }

    override fun getItemCount(): Int {
        return measurements.size
    }

    init {
        this.measurements = measurements
    }


}

