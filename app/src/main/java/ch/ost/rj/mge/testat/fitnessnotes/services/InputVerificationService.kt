package ch.ost.rj.mge.testat.fitnessnotes.services

import android.widget.EditText

object InputVerificationService {
    fun hasInvalidInput(editText: EditText): Boolean {
        return editText.text.length == 0 || editText.error != null
    }
}