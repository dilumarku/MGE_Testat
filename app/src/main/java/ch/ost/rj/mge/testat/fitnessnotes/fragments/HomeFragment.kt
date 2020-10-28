package ch.ost.rj.mge.testat.fitnessnotes.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ch.ost.rj.mge.testat.fitnessnotes.R


class HomeFragment : Fragment() {

    private val WEBSITE_URL = "https://github.com/dilumarku/MGE_Testat"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val urlTextView: TextView = root.findViewById(R.id.text_url)
        urlTextView.setOnClickListener { _ -> openUrl() }
        return root
    }

    private fun openUrl() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(WEBSITE_URL)
        val packageManager = activity!!.packageManager
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this.context, R.string.no_browser_app_found, Toast.LENGTH_LONG).show()
        }
    }
}