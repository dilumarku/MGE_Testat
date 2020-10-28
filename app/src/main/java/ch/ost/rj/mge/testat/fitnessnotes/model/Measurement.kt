package ch.ost.rj.mge.testat.fitnessnotes.model

class Measurement(date: String, measure: String, notes: String){
    var date: String
    var measure: String
    var notes: String
    init {
        this.date = date
        this.measure = measure
        this.notes = notes
    }
}