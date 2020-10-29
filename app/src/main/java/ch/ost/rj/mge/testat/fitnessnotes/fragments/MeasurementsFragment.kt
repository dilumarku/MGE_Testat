package ch.ost.rj.mge.testat.fitnessnotes.fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import ch.ost.rj.mge.testat.fitnessnotes.R
import ch.ost.rj.mge.testat.fitnessnotes.activities.WeightActivity
import kotlinx.android.synthetic.main.fragment_measurements.view.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MeasurementsFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_measurements, container, false)

        val simpleCalendarView = root.calendarView
        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
        val currentDate = LocalDateTime.now()

        root.text_weight.setText("Click the button to track your current weight")
        root.textView_below_calender.setText("Click on a date to track your weight on that day")
        root.textView_above_calender.setText("${currentDate.dayOfMonth} ${currentDate.month} ${currentDate.year}" )

        simpleCalendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            var selectedDate = LocalDate.of(year, month+1, dayOfMonth).format(formatter)
            val intent = Intent(root.context, WeightActivity::class.java)
            intent.putExtra("date", selectedDate)
            startActivity(intent)
        }



        val buttonWeight = root.findViewById<Button>(R.id.buttonWeight)
        buttonWeight.setOnClickListener {
            val intent = Intent(root.context, WeightActivity::class.java)
            intent.putExtra("date",currentDate.format(formatter) )
            startActivity(intent)
        }

        return root
    }

}