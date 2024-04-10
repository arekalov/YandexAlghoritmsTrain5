package Lection1
fun printerMatrix(t: Array<Array<Int>>) {
    for (i in t) {
        for (j in i) {
            print(j)
        }
        println()
    }
    println()
}

fun root(matrix: Array<Array<Int>>, x: Int, y: Int): Array<Array<Int>> {
    for (i in x+1..7) {
        if (matrix[y][i] == 4 || matrix[y][i] == 7) break
        matrix[y][i] = 1
    }
    for (i in x-1 downTo  0) {
        if (matrix[y][i] == 4 || matrix[y][i] == 7) break
        matrix[y][i] = 1
    }
    for (i in y+1..7) {
        if (matrix[i][x] == 4 || matrix[i][x] == 7) break
        matrix[i][x] = 1
    }
    for (i in y-1 downTo  0) {
        if (matrix[i][x] == 4 || matrix[i][x] == 7) break
        matrix[i][x] = 1
    }
    return matrix
}

fun bishop(matrix: Array<Array<Int>>, oldX: Int, oldY: Int): Array<Array<Int>> {
    var x = oldX; var y = oldY
    try {
        for (i in 1..8) {
            if (matrix[y - 1][x + 1] == 4 || matrix[y - 1][x + 1] == 7) break
            matrix[--y][++x] = 1
        }
    } catch (e: Exception){}
    x = oldX; y = oldY
    try {
        for (i in 1..8) {
            if (matrix[y + 1][x + 1] == 4 || matrix[y + 1][x + 1] == 7) {break}
            matrix[++y][++x] = 1
        }
    } catch (ex: Exception){}
    x = oldX; y = oldY
    try {
        for (i in 1..8) {
            if (matrix[y + 1][x - 1] == 4 || matrix[y + 1][x - 1] == 7) {break}
            matrix[++y][--x] = 1
        }
    } catch (ex: Exception){}
    x = oldX; y = oldY
    try {
        for (i in 1..8) {
            if (matrix[y - 1][x - 1] == 4 || matrix[y - 1][x - 1] == 7) {break}
            matrix[--y][--x] = 1
        }
    } catch (ex: Exception){}
    return matrix
}

fun main() {
    var matrix = Array<Array<Int>>(8) { Array<Int>(8) { 0 } }
    for (i in 0..7) {
        val s = readln().trim()
        for (j in s.indices) {
            if (s[j] == 'B') {matrix[i][j] = 4} else if (s[j] == 'R') {matrix[i][j] = 7}
        }
    }
    for (i in 0..7) {
        for (j in 0..7) {
            if (matrix[i][j] == 7) {
                matrix = root(matrix, j, i)
            }
            if (matrix[i][j] == 4) {
                matrix = bishop(matrix, j, i)
            }
        }
    }
    var sum = 0
    for (i in matrix) {
        for (j in i) {
            if (j == 0) {
                sum += 1
            }
        }
    }
    println(sum)
}