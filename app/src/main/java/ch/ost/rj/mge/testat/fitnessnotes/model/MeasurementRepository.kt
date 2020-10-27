package ch.ost.rj.mge.testat.fitnessnotes.model

import android.content.Context
import androidx.room.Room
import ch.ost.rj.mge.testat.fitnessnotes.model.storage.MeasurementDatabase


object MeasurementRepository {
    private var database: MeasurementDatabase? = null
    fun initialize(context: Context?) {
        database =
            Room.databaseBuilder(context!!, MeasurementDatabase::class.java, "notes.db")
                .allowMainThreadQueries().build()
        if (getMeasurements()!!.size == 0) {
            addMeasurement(
                "2020-10-04",
                "100",
                "Example note"
            )

        }
    }

    fun getMeasurements(): List<Measurement?>? {
        return database!!.measurementDao()!!.measurements
    }

    fun addMeasurement(
        date: String?,
        measurement: String?,
        notes: String?
    ): Measurement {
        val meas = Measurement()
        meas.date = date
        meas.measurement = measurement
        meas.notes = notes
        return meas
    }
}
