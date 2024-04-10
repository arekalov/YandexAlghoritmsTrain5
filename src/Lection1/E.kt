package Lection1

fun checkDivisibility(n: Long, k: Long): Boolean {
    return n % k == 0L
}

fun getN(n: Long, k: Long): Int {
    for (i in 0..9) {
        if (checkDivisibility(n * 10 + i, k)) {
            return i
        }
    }
    return -1
}

fun main() {
    var (n, k, d) = readln().split(" ").map { it.toLong() }
    for (i in 1..d.toLong()) {
        val newN = getN(n, k)
        if (newN == 0) {
            println("$n" + "0".repeat((d - i + 1).toInt()))
            return
        }
        if (newN != -1) {
            n = n * 10 + newN
        }
        else {
            println(-1)
            return
        }
    }
    println(n)
}