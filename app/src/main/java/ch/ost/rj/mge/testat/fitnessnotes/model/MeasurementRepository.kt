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
                "2020-10-04",
                "100",
                "Testnachricht ohne Inhalt"
            )
        )
    }

}
