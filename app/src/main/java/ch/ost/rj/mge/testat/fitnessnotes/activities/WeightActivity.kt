package ch.ost.rj.mge.testat.fitnessnotes.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.testat.fitnessnotes.R

class WeightActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var parameter: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        val intent = this.intent
        val extras = intent.extras
        parameter = extras!!.getString("myString")
        textView = findViewById(R.id.textOutputWeight)
        (this as AppCompatActivity).supportActionBar?.title = extras.getString("measurement_type")
    }

    override fun onResume() {
        super.onResume()
        textView!!.text = parameter
    }

}