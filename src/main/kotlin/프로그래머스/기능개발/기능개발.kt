package 프로그래머스.기능개발

import kotlin.math.*

fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    val a = progresses.map { (100 - it).toDouble() }
    val queue = mutableListOf<Int>()
    for (i in progresses.indices) {
        queue.add(ceil((a[i] / speeds[i])).toInt())
    }
    println(queue)
    val result = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        var count = 1
        val first = queue.removeFirst()
        while (queue.isNotEmpty() && queue.first() <= first) {
            queue.removeFirst()
            count += 1
        }
        result.add(count)
    }
    return result.toIntArray()
}

fun main() {
    solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
}