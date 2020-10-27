package ch.ost.rj.mge.testat.fitnessnotes.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.testat.fitnessnotes.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MeasurementsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_measurements)

        val extras = this.intent.extras

        (this as AppCompatActivity).supportActionBar?.title = extras!!.getString("measurement_type")

        val fab = findViewById<FloatingActionButton>(R.id.measurement_fab_new)
        fab.setOnClickListener {
            val composeActivityIntent = Intent(this, ComposeActivity::class.java)
            composeActivityIntent.putExtras(extras)
            startActivity(composeActivityIntent)
        }
    }

    override fun onResume() {
        super.onResume()

    }

}