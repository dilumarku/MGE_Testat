package ch.ost.rj.mge.testat.fitnessnotes.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.testat.fitnessnotes.R
import ch.ost.rj.mge.testat.fitnessnotes.model.Measurement
import ch.ost.rj.mge.testat.fitnessnotes.model.MeasurementRepository
import ch.ost.rj.mge.testat.fitnessnotes.services.InputVerificationService
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ComposeActivity : AppCompatActivity() {
    private val FULL_VISIBLE_ALPHA = 1.0f
    private val HALF_VISIBLE_ALPHA = 0.5f

    private var dateEditText: EditText? = null
    private var measurementEditText: EditText? = null
    private var notesEditText: EditText? = null
    private var addButton: Button? = null

    @RequiresApi(Build.VERSION_CODES.O)
    private val currentDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose)

        val extras = this.intent.extras
        (this as AppCompatActivity).supportActionBar?.title = extras!!.getString("measurement_type")

        dateEditText = findViewById(R.id.compose_edit_date)
        dateEditText!!.setText(currentDate)
        measurementEditText = findViewById(R.id.compose_edit_measurement)
        measurementEditText!!.addTextChangedListener(object : TextWatcher {
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
        //measurementEditText!!.setText(measurementEditText!!.getText.toString() + extras!!.getString("measurement_unit"))
        notesEditText = findViewById(R.id.compose_edittext_notes)
        addButton = findViewById(R.id.compose_button_add)
        addButton!!.setOnClickListener(View.OnClickListener { v: View? -> confirmMeasurement() })
        updateAddButton()
    }

    private fun updateAddButton() {
        val toHasError: Boolean = InputVerificationService.hasInvalidInput(measurementEditText)
        val buttonIsEnabled = !toHasError
        val buttonAlpha =
            if (buttonIsEnabled) FULL_VISIBLE_ALPHA else HALF_VISIBLE_ALPHA
        addButton!!.setEnabled(buttonIsEnabled)
        addButton!!.setAlpha(buttonAlpha)
    }

    private fun confirmMeasurement() {
        val measurement: Measurement = MeasurementRepository.addMeasurement(
            dateEditText!!.getText().toString(),
            measurementEditText!!.getText().toString(),
            notesEditText!!.getText().toString()
        )
        //VibrationService.vibrateSuccess()


        Toast.makeText(this, "Measurement successfully added", Toast.LENGTH_LONG).show()

    }

}