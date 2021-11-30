const val time = 124
const val user = "Вася"
const val timeInMin = time / 60
const val timeInHours = time / 3_600

fun main() {
    print(user +  " был(а) " + timeController(time))
}

fun timeController (time: Int): String {

    val reportVariants = when(time) {
        in 0..60 -> "только что"
        in 61..3_599 -> "$timeInMin " + minuteForm(timeInMin) + " назад"
        in 3_600..24*3_600 -> "$timeInHours "+ hourForm(timeInHours) + " назад"
        in (24*3_600+1)..2*24*3_600 -> " сегодня"
        in (2*24*3_600+1)..72*3_600 -> " вчера"
        else -> " давно"
    }
    return reportVariants
}

fun minuteForm (timeInMin: Int): String {
    val formOfMinute = when {
        timeInMin % 10 == 1 && timeInMin % 100 !=11 -> "минуту"
        timeInMin % 10 in 2..4 -> "минуты"
        else -> "минут"
    }
    return formOfMinute
}

fun hourForm (timeInHours: Int): String {
    val formOfHour = when {
        timeInHours % 10 == 1 && timeInHours % 100 !=11 -> "час"
        timeInHours % 10 in 2..4 -> "часа"
        else -> "часов"
    }
    return formOfHour
}