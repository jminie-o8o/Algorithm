package 프로그래머스.이중우선순위큐

import java.util.*

fun solution(operations: Array<String>): IntArray {
    val pqSmall = PriorityQueue<Int>()
    val pqLarge = PriorityQueue<Int>(reverseOrder())
    for (operation in operations) {
        if (operation.startsWith("I")) {
            pqSmall.add(operation.split(" ")[1].toInt())
            pqLarge.add(operation.split(" ")[1].toInt())
        } else if (pqLarge.size == 0) {
            continue
        } else {
            if (operation.split(" ")[0] == "D" && operation.split(" ")[1] == "1") {
                pqSmall.remove(pqLarge.poll())
            } else if (operation.split(" ")[0] == "D" && operation.split(" ")[1] == "-1") {
                pqLarge.remove(pqSmall.poll())
            }
        }
    }
    return when (pqLarge.size) {
        0 -> {
            intArrayOf(0, 0)
        }
        1 -> {
            val temp = pqLarge.poll()
            intArrayOf(temp, temp)
        }
        else -> {
            intArrayOf(pqLarge.poll(), pqSmall.poll())
        }
    }
}

fun main() {
//    println(solution(arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1")).contentToString())
//    println(solution(arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333")).contentToString())
    val pqSmallSortByFirst = PriorityQueue<Pair<Int, Int>> { a, b -> a.first - b.first}
    val pqSmallSortBySecond = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second}
    pqSmallSortByFirst.add(Pair(1, 3))
    pqSmallSortByFirst.add(Pair(2, 1))
    pqSmallSortByFirst.add(Pair(3, 5))
    pqSmallSortByFirst.add(Pair(4, 8))
    println(pqSmallSortByFirst)

    println("-------------------------")

    pqSmallSortBySecond.add(Pair(1, 3))
    pqSmallSortBySecond.add(Pair(2, 1))
    pqSmallSortBySecond.add(Pair(3, 5))
    pqSmallSortBySecond.add(Pair(4, 8))
    println(pqSmallSortBySecond)
}