package 테스트

import kotlin.math.sqrt

fun solution(A: IntArray, B: IntArray, X: Int, Y: Int): Int {
    val point: MutableList<Pair<Int, Int>> = mutableListOf()
    for (i in A.indices) {
        val a = A[i]
        val b = B[i]
        point.add(Pair(a, b))
    }
    var answer = -1
    for (i in point.indices) {
        if (check(point[i], X, Y)) answer = i
    }
    return answer
}

fun check(circle: Pair<Int, Int>, X: Int, Y: Int): Boolean {
    val x = circle.first.toDouble()
    val y = circle.second.toDouble()
    val len = sqrt((X - x) * (X - x) + (Y - y) * (Y - y))
    if (len <= 20) return true
    return false
}

fun main() {
    println(solution(intArrayOf(100, 200, 100), intArrayOf(50, 100, 100), 100, 100))
    println(solution(intArrayOf(100, 200, 100), intArrayOf(50, 100, 100), 100, 70))
    println(solution(intArrayOf(100, 200, 100), intArrayOf(50, 100, 100), 200, 60))
}







