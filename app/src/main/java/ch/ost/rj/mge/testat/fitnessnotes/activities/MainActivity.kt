package ch.ost.rj.mge.testat.fitnessnotes.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.testat.fitnessnotes.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = cont_button
        addButton.setOnClickListener(View.OnClickListener { _ ->
            startActivity(Intent(this, SecondActivity::class.java))})

    }

}