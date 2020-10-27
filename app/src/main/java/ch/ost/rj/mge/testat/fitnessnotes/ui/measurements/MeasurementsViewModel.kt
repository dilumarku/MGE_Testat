package ch.ost.rj.mge.testat.fitnessnotes.ui.measurements

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MeasurementsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is measurements Fragment"
    }
    val text: LiveData<String> = _text
}
