package Lection1

fun main() {
    val combinations = hashMapOf(1L to 1, 2L to 2, 3L to 2, 0L to 0)
    var sum: Long = 0
    for (i in 1..readln().toLong()){
        val n = readln().toLong()
        sum += n / 4
        if (combinations.containsKey(n % 4L)) {
            sum += combinations[(n % 4L)]!!
        }
    }
    println(sum)
}