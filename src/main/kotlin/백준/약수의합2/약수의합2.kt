package 백준.약수의합2

import kotlin.math.*

// 시간복잡도 O(N * √N)
//fun main() = with(System.`in`.bufferedReader()) {
//    val input = readLine()!!.toLong()
//    var answer = 0L
//    for (i in (1..input)) {
//        answer += calculate(i.toDouble())
//    }
//    println(answer)
//}
//
//// n 의 약수의 합을 구해주는 함수
//fun calculate(n: Double): Long {
//    val nInt = n.toLong()
//    val sq = sqrt(n)
//    val target = floor(sq).toInt()
//    var total = 0L
//    for (i in (1 ..target)) {
//        if (nInt % i == 0L) {
//            val temp = (nInt / i)
//            total += if (temp == i.toLong()) {
//                i.toLong()
//            } else {
//                i + temp
//            }
//        }
//    }
//    return total
//}

// 시간복잡도 O(N)
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    var answer = 0L
    for (i in (1..n)) {
        answer += (n / i) * i // (n / i) -> i의 배수의 개수 즉 i를 약수로 갖는 수
    }
    println(answer)
}