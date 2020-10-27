package ch.ost.rj.mge.testat.fitnessnotes.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "measurementsT")
class Measurement {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo
    var date: String? = null

    @ColumnInfo
    var measurement: String? = null

    @ColumnInfo
    var notes: String? = null
}
