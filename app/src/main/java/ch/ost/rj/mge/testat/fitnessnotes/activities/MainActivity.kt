package ch.ost.rj.mge.testat.fitnessnotes.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.testat.fitnessnotes.R
import ch.ost.rj.mge.testat.fitnessnotes.model.Measurement
import ch.ost.rj.mge.testat.fitnessnotes.model.MeasurementRepository
import ch.ost.rj.mge.testat.fitnessnotes.services.InputVerificationService
import kotlinx.android.synthetic.main.activity_compose.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity: AppCompatActivity() {
    private lateinit var addButton: Button
    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = radiogroup

        addButton = cont_button
        addButton.setOnClickListener(View.OnClickListener { _ ->
            startActivity(Intent(this, SecondActivity::class.java))})

    }

}