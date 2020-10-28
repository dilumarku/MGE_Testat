package ch.ost.rj.mge.testat.fitnessnotes.adapter

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.testat.fitnessnotes.ui.workouts.RecyclerViewHolder
import java.lang.String
import java.util.*
import kotlin.random.Random


class RandomNumListAdapter(seed: Int) :
    RecyclerView.Adapter<RecyclerViewHolder>() {
    private val random: Random

    override fun getItemViewType(position: Int): Int {
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.view.setText(String.valueOf(random.nextInt()))
    }

    override fun getItemCount(): Int {
        return 100
    }

    init {
        random = Random(seed)
    }
}