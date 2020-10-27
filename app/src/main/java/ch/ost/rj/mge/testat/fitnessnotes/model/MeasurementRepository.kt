package ch.ost.rj.mge.testat.fitnessnotes.model


import java.util.*


object MeasurementRepository {
    private var measurements: ArrayList<Measurement>? = null

    init {
        measurements = ArrayList<Measurement>()
        measurements!!.add(
            Measurement(
                "2020-10-04",
                "100",
                "Testnachricht ohne Inhalt"
            )
        )
    }

    fun getMeasurements(): ArrayList<Measurement>? {
        return measurements
    }

    fun addMeasurement(measurement: Measurement) {
        measurements!!.add(measurement)
    }


}
