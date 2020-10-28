package ch.ost.rj.mge.testat.fitnessnotes.model

import java.util.*


object MeasurementRepository {
    lateinit var measurements: ArrayList<Measurement>

    fun addMeasurement(measurement: Measurement){
        this.measurements.add(measurement)
    }

    init {
        measurements = ArrayList()
        measurements.add(
            Measurement(
                "04-October-2020",
                "100 kg",
                "Testnachricht ohne Inhalt"
            )
        )
    }

}
