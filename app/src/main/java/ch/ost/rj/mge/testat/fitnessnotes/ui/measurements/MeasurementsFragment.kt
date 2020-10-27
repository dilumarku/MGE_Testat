package ch.ost.rj.mge.testat.fitnessnotes.ui.measurements

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ch.ost.rj.mge.testat.fitnessnotes.R

class MeasurementsFragment : Fragment() {

    private lateinit var measurementsViewModel: MeasurementsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        measurementsViewModel =
            ViewModelProviders.of(this).get(MeasurementsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_measurements, container, false)
        val textView: TextView = root.findViewById(R.id.text_measurements)
        measurementsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }
}