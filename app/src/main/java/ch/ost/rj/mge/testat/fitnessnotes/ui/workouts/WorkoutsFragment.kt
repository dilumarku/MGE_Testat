package ch.ost.rj.mge.testat.fitnessnotes.ui.workouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ch.ost.rj.mge.testat.fitnessnotes.R

class WorkoutsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_workouts, container, false)

        return root
    }
}