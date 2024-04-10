package Lection1

fun main() {
    val n = readln().toLong()
    val s = readln().split(" ")
    var sum: Long = 0
    var firstNechet: Long = 2
    var firstNechetIndex = -1
    var firstNechetSign = "+"
    for (i in 0..s.size - 2){
        val intI = s[i].toLong()
        sum += intI
        if (intI % 2L != 0L && firstNechet == 2L && i != 0) {
            firstNechet = intI
            firstNechetIndex = i
        }
    }
    var lastSign = "+"
    val last = s[s.size - 1].toLong()
    if (last % 2L != 0L && firstNechet == 2L) {
        firstNechet = last
        firstNechetIndex = s.size -1
    }
    if ((sum % 2L == 0L && last % 2L != 0L) || (sum % 2L != 0L && last % 2L == 0L)) {
        lastSign = "+"
    }
    else if (sum % 2L != 0L && last % 2L != 0L) {
        lastSign = "x"
    }
    else if (sum % 2L == 0L && last % 2L == 0L) {
        lastSign = "+"
        firstNechetSign = "x"
    }
    else {
        println("error ???")
        return
    }
    if (n == 2L) {
        println(lastSign)
    }
    else if (n == 3L && firstNechetIndex == s.size - 1) {
        println("+" + lastSign)
    }
    else {
        println("+".repeatNew(firstNechetIndex - 1) + firstNechetSign + "+".repeatNew(s.size - 1 - firstNechetIndex - 1) + lastSign)
    }
}
fun String.repeatNew(n: Int): String {
    if (n <= 0) {
        return ""
    }
    else {
        return this.repeat(n)
    }
}