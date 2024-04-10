package Lection2

import kotlin.math.max


fun main() {
    val (n, k) = readln().split(" ").map { x -> x.toInt() }
    var answer = 0
    val prices = readln().split(" ").toMutableList().map { it.toInt() }
    for (i in 0..<n) {
        for (j in 1..k) {
            val new_el = i + j
            if (new_el <= n - 1) {
                answer = max(answer, prices[new_el] - prices[i])
            }
        }
    }
    println(answer)


}