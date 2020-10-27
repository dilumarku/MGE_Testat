package ch.ost.rj.mge.testat.fitnessnotes.ui.workouts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WorkoutsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is workouts Fragment"
    }
    val text: LiveData<String> = _text
}