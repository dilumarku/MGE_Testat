package ch.ost.rj.mge.testat.fitnessnotes.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ch.ost.rj.mge.testat.fitnessnotes.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private val WEBSITE_URL = "https://github.com/dilumarku/MGE_Testat"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val urlTextView: TextView = root.findViewById(R.id.text_url)
        urlTextView.setOnClickListener { _ -> openUrl() }
        return root
    }

    private fun openUrl() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(WEBSITE_URL)
        startActivity(intent)
    }
}