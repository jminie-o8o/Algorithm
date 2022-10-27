package 백준.소수찾기

import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    var count = 0
    arr.forEach {
        if (isPrime(it)) count += 1
    }
    println(count)
}

fun isPrime(n: Int): Boolean {
    if (n == 1) return false
    else if (n == 2) return true
    val sq = ceil(sqrt(n.toDouble())).toInt()
    for (i in (2..sq)) {
        if (n % i == 0) return false
    }
    return true
}