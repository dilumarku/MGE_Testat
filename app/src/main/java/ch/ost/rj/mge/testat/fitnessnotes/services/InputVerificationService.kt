package ch.ost.rj.mge.testat.fitnessnotes.services

import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.view.*

object InputVerificationService {
    fun hasInvalidInput(editText: EditText): Boolean {
        return editText.text.length == 0 || editText.error != null
    }

}