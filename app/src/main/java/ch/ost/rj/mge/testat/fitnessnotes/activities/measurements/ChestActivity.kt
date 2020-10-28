package ch.ost.rj.mge.testat.fitnessnotes.activities.measurements

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.testat.fitnessnotes.R
import ch.ost.rj.mge.testat.fitnessnotes.activities.ComposeActivity
import ch.ost.rj.mge.testat.fitnessnotes.adapter.MeasurementAdapter
import ch.ost.rj.mge.testat.fitnessnotes.adapter.MeasurementViewHolder
import ch.ost.rj.mge.testat.fitnessnotes.model.MeasurementRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChestActivity: AppCompatActivity() {
    var adapter: RecyclerView.Adapter<MeasurementViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_measurements)

        val extras = this.intent.extras

        (this as AppCompatActivity).supportActionBar?.title = extras!!.getString("measurement_type")

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        adapter = MeasurementAdapter(MeasurementRepository.getMeasurements())
        val dividerItemDecoration =
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        val recyclerView = findViewById<RecyclerView>(R.id.measurement_items)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(dividerItemDecoration)

        val fab = findViewById<FloatingActionButton>(R.id.measurement_fab_new)
        fab.setOnClickListener {
            val composeActivityIntent = Intent(this, ComposeActivity::class.java)
            composeActivityIntent.putExtras(extras)
            startActivity(composeActivityIntent)
        }
    }

    override fun onResume() {
        super.onResume()

        adapter!!.notifyDataSetChanged()
    }

}