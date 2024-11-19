package com.memo.test.ui.theme

val listOfGyms = listOf(
    Gym(id = 1, name = "Downtown Fitness", place = "22 XYZ Road, near Metro Station, Cairo, Egypt"),
    Gym(id = 2, name = "Eastside Wellness", place = "35 JKL Street, near Main Square, Cairo, Egypt"),
    Gym(id = 3, name = "Westside Gym", place = "40 MNO Avenue, by Park Street, Cairo, Egypt"),
    Gym(id = 4, name = "North Gymnasium", place = "18 PQR Lane, off Central Blvd, Cairo, Egypt"),
    Gym(id = 5, name = "South End Gym", place = "50 STU Blvd, close to Lake View, Cairo, Egypt"),
)

data class Gym (val id: Int,val name: String, val place: String, var isFavorite: Boolean = false)
