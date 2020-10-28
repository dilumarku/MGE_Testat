package ch.ost.rj.mge.testat.fitnessnotes.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ch.ost.rj.mge.testat.fitnessnotes.R
import ch.ost.rj.mge.testat.fitnessnotes.activities.measurements.WeightActivity
import kotlinx.android.synthetic.main.fragment_measurements.view.*

class MeasurementsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_measurements, container, false)

        root.text_weight.setText("Click the button to track your weight")
        //root.calendarView.

        val buttonWeight = root.findViewById<Button>(R.id.buttonWeight)
        buttonWeight.setOnClickListener {
            startActivity(Intent(root.context, WeightActivity::class.java))
        }

        return root
    }

}