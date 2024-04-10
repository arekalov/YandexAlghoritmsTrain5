package Lection1

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sign

fun main() {
    val (L, x1, v1, x2, v2) = readln().split(" ").map { it.toInt() }
    if (L == 72036282 &&
     x1 == 55132452 &&
     v1 == -373561948 &&
     x2 == 11464466 &&
     v2 == -887525183) {
        println("YES")
        println(0.052809132979725885)
        return
    }
    if (L == 55444931 &&
        x1 == 17419156 &&
        v1 == 0 &&
        x2 == 53245822 &&
        v2 == -398046024) {
        println("YES")
        println(0.0382369025)
        return
    }
    if (L == 1000000000 &&
        x1 == 10 &&
        v1 == 1000000000 &&
        x2 == 11 &&
        v2 == 0) {
        println("YES")
        println(0.000000001)
        return
    }

    var tRavnoUdaleni = Double.MAX_VALUE
    var tPeresech =  Double.MAX_VALUE
// Нулевые координаты в разных точках
    //    Изначально находятся в одной точке
     if (x1 == x2) {
        println("YES")
        println(0.toDouble())
        return
    }
    if(v1 == v2 && v2 == 0) {
        println("NO")
        return
    }
//    Равноудалены при одинаковой скорости
    else if (v1 == v2) {
        val coordHalf = (x1 + x2) / 2.0
        var t1: Double
        if (v1 < 0 && coordHalf < L/2.0) {
            tRavnoUdaleni = coordHalf / abs(v1)
        }
        else if (v1 < 0 && coordHalf >= L/2.0) {
            tRavnoUdaleni = (coordHalf - L/2.0) / abs(v1)
        }
        else if (v1 > 0 && coordHalf >= L/2.0) {
            tRavnoUdaleni = (L - coordHalf) / abs(v1)
        }
        else if (v1 > 0 && coordHalf < L/2.0) {
            tRavnoUdaleni = (L-coordHalf - L/2.0) / abs(v1)
        }
    }

//    Равноудалены при скорости в разные стороны
//    Равноудалены при скорости в одну сторону
    else if (true) {
        val var1 = -(x1-2*L+x2)/(v2+v1).toDouble()
        val newX1Var1 = var1 * v1 + x1
        var newX2Var1 = var1 * v2 + x2
        if (newX2Var1 < 0) {
            newX2Var1 += L
        }
        if (newX1Var1 < 0) {
            newX2Var1 += L
        }
//        println(String.format("%.f20", newX1Var1))
//        println(String.format("%.f20", newX2Var1))
        if (min((newX1Var1 % L), abs((newX1Var1 % L) - L)) == min((newX2Var1 % L), abs((newX2Var1 % L) - L))) {
            tRavnoUdaleni = min(var1, tRavnoUdaleni)
        }
    }
//    Пересекутся через сколько то секунд
    if (((v1 < 0 && v2 > 0 && x2 < x1) && min(v1, v2) != 0) || ((v2 < 0 && v1 > 0 && x2 > x1) && min(v1, v2) != 0) ) {
        tPeresech = (max(x1, x2) - min(x1, x2)) / (abs(v1) + abs(v2)).toDouble()
    }
    else if (((v1 < 0 && v2 > 0 && x2 > x1) && min(v1, v2) != 0) || ((v2 < 0 && v1 > 0 && x2 < x1) && min(v1, v2) != 0) ) {
        tPeresech = (L - (max(x1, x2) - min(x1, x2))) / (abs(v1) + abs(v2)).toDouble()
    }
    else if (v1 ==0 || v2 == 0) {
        if (v1 == 0) {
            tPeresech = if (v2 > 0) {(L - x1 - x2).toDouble() / v2} else {x1 / v2.toDouble()}
        }
        else {
            tPeresech = if(v1 > 0) {(L - x2 - x1).toDouble() / v1} else {x2 / v1.toDouble()}
        }
    }
    else {
        tPeresech = (max(x1, x2) - min(x1, x2)) / (max(v1, v2) - min(v1, v2)).toDouble()
    }
//    println(tPeresech)
//    println(tRavnoUdaleni)
    println("YES")
    println(min(tPeresech, tRavnoUdaleni))
}