package Lection2

fun main() {
    val k = readln().toInt()
    var left: Pair<Long, Long> = Pair(Long.MAX_VALUE, 0)
    var right: Pair<Long, Long> = Pair(Long.MIN_VALUE, 0)
    var top: Pair<Long, Long> = Pair(0, Long.MIN_VALUE)
    var bottom: Pair<Long, Long> = Pair(0, Long.MAX_VALUE)
    for (i in 1..k) {
        val (x, y) = readln().split(" ").map { it.toLong() }
        if (x > right.first) {
            right = Pair(x, y)
        }
        if (x < left.first) {
            left = Pair(x, y)
        }
        if (y > top.second) {
            top = Pair(x, y)
        }
        if (y < bottom.second) {
            bottom = Pair(x, y)
        }
    }
    println("${left.first} ${bottom.second} ${right.first} ${top.second}")
}