package ch.ost.rj.mge.testat.fitnessnotes.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ch.ost.rj.mge.testat.fitnessnotes.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_second.*



class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val navView: BottomNavigationView = nav_view

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home,
            R.id.navigation_measurements,
            R.id.navigation_settings
        ))


        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


}