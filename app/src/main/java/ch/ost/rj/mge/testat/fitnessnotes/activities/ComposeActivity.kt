package ch.ost.rj.mge.testat.fitnessnotes.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.testat.fitnessnotes.R
import ch.ost.rj.mge.testat.fitnessnotes.model.Measurement
import ch.ost.rj.mge.testat.fitnessnotes.model.MeasurementRepository
import ch.ost.rj.mge.testat.fitnessnotes.services.InputVerificationService
import kotlinx.android.synthetic.main.activity_compose.*

class ComposeActivity : AppCompatActivity() {
    private val FULL_VISIBLE_ALPHA = 1.0f
    private val HALF_VISIBLE_ALPHA = 0.5f

    private lateinit var dateEditText: EditText
    private lateinit var measurementEditText: EditText
    private lateinit var notesEditText: EditText
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose)

        (this as AppCompatActivity).supportActionBar?.title = "Please enter your current weight"

        val extras = this.intent.extras

        dateEditText = compose_edit_date
        dateEditText.setText(extras!!.getString("date"))

        measurementEditText = compose_edit_measurement
        measurementEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }
            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }
            override fun afterTextChanged(editable: Editable) {
                updateAddButton()
            }
        })

        notesEditText = compose_edittext_notes

        addButton = compose_button_add
        addButton.setOnClickListener(View.OnClickListener { v: View? -> confirmMeasurement()})

        updateAddButton()
    }

    private fun updateAddButton() {
        val toHasError: Boolean = InputVerificationService.hasInvalidInput(measurementEditText)
        val buttonIsEnabled = !toHasError
        val buttonAlpha =
            if (buttonIsEnabled) FULL_VISIBLE_ALPHA else HALF_VISIBLE_ALPHA
        addButton.setEnabled(buttonIsEnabled)
        addButton.setAlpha(buttonAlpha)
    }

    private fun confirmMeasurement() {
        val measurement = Measurement(
            dateEditText.text.toString(),
            measurementEditText.text.toString() + " kg",
            notesEditText.text.toString()
        )
        //VibrationService.vibrateSuccess()
        MeasurementRepository.addMeasurement(measurement)
        finish()
        Toast.makeText(this, "Measurement successfully added", Toast.LENGTH_LONG).show()

    }

}