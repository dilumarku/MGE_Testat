package ch.ost.rj.mge.testat.fitnessnotes.fragments

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ch.ost.rj.mge.testat.fitnessnotes.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


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

        val contactButton = root.contact_button
        contactButton.setOnClickListener(View.OnClickListener { v: View? -> sendEmail()})

        if(root.context.isDarkThemeOn()){
            root.dark_mode_switch.toggle()
        }

        root.dark_mode_switch.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

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

    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, "dmarku@hotmail.com")
        intent.putExtra(Intent.EXTRA_SUBJECT, "Fitness Notes")
        if (intent.resolveActivity(activity!!.getPackageManager()) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this.context, "No email app found", Toast.LENGTH_LONG).show()
        }
    }

    fun Context.isDarkThemeOn(): Boolean {
        return resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }
}