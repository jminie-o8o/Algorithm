package 프로그래머스.`k진수에서 소수 개수 구하기`

import kotlin.math.sqrt

fun solution(n: Int, k: Int): Int {
    val numList = n.toString(k).split("0").toMutableList()
    var count = 0
    numList.removeAll(arrayOf("", " "))
    numList.forEach { if (isPrime(it.toLong())) count += 1 }
    return count
}

fun isPrime(num: Long): Boolean {
    if (num <= 1) return false
    return (2..sqrt(num.toDouble()).toInt()).none { num % it == 0L }
}

fun main() {
    solution(437674, 3)
    solution(110011, 10)
}