package Lection1

import kotlin.math.abs


fun main() {
    var (t1F, t2F) = readln().split(":").map { it.toInt() }
    var (t1S, t2S) = readln().split(":").map { it.toInt() }
    val home = readln().toInt()
    var t1 = t1S + t1F
    var t2 = t2S + t2F
    var answer = 0
    if (t1 < t2) {
        answer += abs(t1 - t2)
        t1S += abs(t1-t2)
        answer += if ((home == 1 && t1S <= t2F) || (home == 2 && t1F <= t2S)) 1 else 0
        t1S += if ((home == 1 && t1S <= t2F) || (home == 2 && t1F <= t2S)) 1 else 0
        t1 = t1S + t1F
        t2 = t2S + t2F
    }
    if (t1 == t2) {
        if ((home == 1 && t1S <= t2F) || (home == 2 && t1F <= t2S)) answer++
    }
    println(answer)
}