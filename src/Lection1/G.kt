package Lection1

import kotlin.math.min

fun main() {
    var mySoldiers = readln().toInt() // мои солдаты
    var base = readln().toInt() // здоровье казармы соперника
    val baseGenerate = readln().toInt() // производство солдат за раунд
    val battle = Battle(mySoldiers, base, baseGenerate)
    battle.mainLoop()
}

class Battle(var mySoliders: Int, var base: Int, val baseGenerate: Int) {
    var roundCounter = 0L
    var enemySoldiers = 0
    var fastRounds = 1000000L

    fun fastWar(mySoldiers: Int, enemySoldiers: Int): Int {
        var mySoldiers = mySoldiers;
        var enemySoldiers = enemySoldiers
        var counter = 0
        while (mySoldiers > 0 && enemySoldiers > 0) {
            if (counter != 0) {
                enemySoldiers -= mySoldiers
                mySoldiers -= enemySoldiers
            }
            counter++
        }
        if (counter == 0 )return 1
        if (mySoldiers > 0) return counter
        return -1
    }

    fun myMove() {
        if (base <= mySoliders) {
            var newFastRound = 0L
            newFastRound += roundCounter - 1
            val soldiersFast = mySoliders - (enemySoldiers - (mySoliders - base))
            val enemySoldiersFast = enemySoldiers - (mySoliders - base)
            if (soldiersFast <= 0 || enemySoldiersFast <= 0) {
                newFastRound = 1000000L
            }
            else {
                val res = fastWar(soldiersFast, enemySoldiersFast)
                newFastRound = if (res != -1) {
                    res + newFastRound
                } else 1000000L
            }
            fastRounds = min(fastRounds, newFastRound)
        }
        var soldiersForRound = mySoliders
        if (roundCounter != 1L && soldiersForRound != enemySoldiers) {
            if (soldiersForRound < enemySoldiers) {
                enemySoldiers -= soldiersForRound
                soldiersForRound = 0
            }
            else {
                soldiersForRound -= enemySoldiers
                enemySoldiers = 0
            }
        }
        if (soldiersForRound > 0) {
            if (soldiersForRound > base) {
                base = 0
            }
            else {
                base -= soldiersForRound
            }
        }

    }

    fun enemyMove() {
        if (enemySoldiers >= mySoliders) {
            mySoliders = 0
        } else {
            mySoliders -= enemySoldiers
        }
    }

    fun generateEnemySoldiers() {
        if (base > 0) {
            enemySoldiers += baseGenerate
        }
    }


    fun mainLoop() {
        while (true) {
            roundCounter++
            myMove()
            if (checkStop()) break
            enemyMove()
            if (checkStop()) break
            generateEnemySoldiers()
            if (checkStop()) break
        }
        if (mySoliders >= 0 && enemySoldiers <= 0 && fastRounds != 1000000L && fastRounds != -1L && base <= 0) {
            println(min(roundCounter, fastRounds))
        }
        else if (mySoliders > 0 && fastRounds == 1000000L  && base <= 0) {
            println(roundCounter)
        }
        else if (mySoliders <= 0 && fastRounds != 1000000L && fastRounds != -1L) {
            println(fastRounds)
        }else println(-1)
    }

    fun checkStop(): Boolean {
        return (mySoliders <= 0) || (enemySoldiers <= 0 && base <= 0)
    }
}