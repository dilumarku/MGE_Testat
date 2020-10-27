package ch.ost.rj.mge.testat.fitnessnotes

import android.app.Application
import ch.ost.rj.mge.testat.fitnessnotes.model.MeasurementRepository

class FitnessNotesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MeasurementRepository.initialize(applicationContext)
        //VibrationService.initialize(applicationContext)
    }
}