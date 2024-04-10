package Lection1

fun isLeapYear(year: Int): Boolean {
    return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)
}

fun getDay(year: Int, month: Int, day: Int): Int {
    var month = month;
    var year = year;
    var day = day
    if (month <= 2) {
        month += 10
        year -= 1
    } else {
        month -= 2
    }
    return (day + ((31 * month) / 12) + year + year / 4 - year / 100 + year / 400) % 7
}


fun main() {
    val days = hashMapOf<Int, Int>(0 to 52, 1 to 52, 2 to 52, 3 to 52, 4 to 52, 5 to 52, 6 to 52)
    val nToDay = hashMapOf(
        0 to "Sunday",
        1 to "Monday",
        2 to "Tuesday",
        3 to "Wednesday",
        4 to "Thursday",
        5 to "Friday",
        6 to "Saturday"
    )
    val dayToN = hashMapOf<String, Int>(
        "Sunday" to 0,
        "Monday" to 1,
        "Tuesday" to 2,
        "Wednesday" to 3,
        "Thursday" to 4,
        "Friday" to 5,
        "Saturday" to 6
    )
    val monthToN = hashMapOf(
        "January" to 1,
        "February" to 2,
        "March" to 3,
        "April" to 4,
        "May" to 5,
        "June" to 6,
        "July" to 7,
        "August" to 8,
        "September" to 9,
        "October" to 10,
        "November" to 11,
        "December" to 12
    )
    val n = readln().toInt()
    val year = readln().toInt()
    for (i in 1..n) {
        val (day, month) = readln().split(" ")
        val monthInt = monthToN[month]
        val dayOfWeek = monthInt?.let { getDay(year, it, day.toInt()) }
        days[dayOfWeek!!] = days[dayOfWeek]!! - 1
    }
    val day_of_week = dayToN[readln()]
    days[day_of_week!!] = days[day_of_week]!! + 1
    if (isLeapYear(year)) {
        days[(day_of_week!! + 1) % 7] = days[(day_of_week!! + 1) % 7]!! + 1
    }
    val minD = days.minOf { it.value }
    val maxD = days.maxOf { it.value }
    var minDay = "";
    var maxDay = ""
    for ((k, b) in days) {
        if (b == minD) {
            minDay = nToDay[k].toString()
        }
        if (b == maxD) {
            maxDay = nToDay[k].toString()
        }
    }
    println("$maxDay $minDay")
}