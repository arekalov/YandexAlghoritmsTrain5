package Lection1

import kotlin.math.*

fun compareSegments(x1: Int, y1: Int, x2:Int, y2: Int): Int {
    if ((x2 in y1..x1 || y2 in y1..x1) || (x1 in y2..x2 || y1 in y2..x2)) {
        return max(x1, x2) - min(y1, y2) + 1}
    else {return x1 - y1 + x2 - y2 + 2}
}


fun main() {
    val (p, v) = readln().split(" ").map { it.toInt() }
    val (q, m) = readln().split(" ").map { it.toInt() }
    println(compareSegments(p + v, p-v, q+m, q-m))
}