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
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.testat.fitnessnotes.R
import ch.ost.rj.mge.testat.fitnessnotes.services.InputVerificationService
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ComposeActivity : AppCompatActivity() {
    private val FULL_VISIBLE_ALPHA = 1.0f
    private val HALF_VISIBLE_ALPHA = 0.5f

    private var dateEditText: EditText? = null
    private var measurementEditText: EditText? = null
    private var contentEditText: EditText? = null
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
        contentEditText = findViewById(R.id.compose_edittext_content)
        addButton = findViewById(R.id.compose_button_add)
        //addButton!!.setOnClickListener(View.OnClickListener { v: View? -> sendEmail() })
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
/*
    private fun sendEmail() {
        val email: Email = EmailRepository.addEmail(
            fromEditText.getText().toString(),
            toEditText.getText().toString(),
            subjectEditText.getText().toString(),
            contentEditText!!.text.toString()
        )
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:") // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>(email.to))
        intent.putExtra(Intent.EXTRA_SUBJECT, email.subject)
        intent.putExtra(Intent.EXTRA_TEXT, email.content)
        if (intent.resolveActivity(packageManager) != null) {
            VibrationService.vibrateSuccess()
            if (!SKIP_EMAIL_INTENT) {
                startActivity(intent)
            }
            finish()
        } else {
            VibrationService.vibrateError()
            Toast.makeText(this, R.string.compose_no_email_app_found, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private const val DATE_KEY = "date"
        private const val FULL_VISIBLE_ALPHA = 1.0f
        private const val HALF_VISIBLE_ALPHA = 0.5f
        fun createIntent(context: Context?, date: String?): Intent {
            val intent = Intent(
                context,
                ComposeActivity::class.java
            )
            intent.putExtra(
                DATE_KEY,
                date
            )
            return intent
        }
    }*/
}