package com.hooleyapp.organizer.data.model.custommodel

class WeekDaysModel {
    var weekNumber :String = ""
    var daysList = ArrayList<String>()

    constructor(weekNumber: String, daysList: ArrayList<String>) {
        this.weekNumber = weekNumber
        this.daysList = daysList
    }
}