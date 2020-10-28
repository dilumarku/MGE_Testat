package ch.ost.rj.mge.testat.fitnessnotes.ui.measurements

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ch.ost.rj.mge.testat.fitnessnotes.R
import ch.ost.rj.mge.testat.fitnessnotes.activities.measurements.ChestActivity
import ch.ost.rj.mge.testat.fitnessnotes.activities.measurements.WeightActivity
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.testat.fitnessnotes.adapter.MeasurementAdapter
import ch.ost.rj.mge.testat.fitnessnotes.model.MeasurementRepository
import kotlinx.android.synthetic.main.fragment_workouts.*

class MeasurementsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_measurements, container, false)

        val buttonWeight = root.findViewById<Button>(R.id.buttonWeight)
        buttonWeight.setOnClickListener {
            val weightActivityIntent = Intent(root.context, WeightActivity::class.java)
            weightActivityIntent.putExtra("myString", "How much do you weigh?")
            weightActivityIntent.putExtra("measurement_type", "Weight")
            weightActivityIntent.putExtra("measurement_unit", "kg")
            startActivity(weightActivityIntent)
        }
/*
        val buttonChest = root.findViewById<Button>(R.id.buttonChest)
        buttonChest.setOnClickListener {
            val weightActivityIntent = Intent(root.context, ChestActivity::class.java)
            weightActivityIntent.putExtra("myString", "What is you chest circumference?")
            weightActivityIntent.putExtra("measurement_type", "Chest")
            weightActivityIntent.putExtra("measurement_unit", "cm")
            startActivity(weightActivityIntent)
        }*/

        return root
    }
    

}