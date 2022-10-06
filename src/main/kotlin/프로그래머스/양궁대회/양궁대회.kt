package 프로그래머스.양궁대회

import java.util.*

data class Data(
    val score: Int,
    val count: Int
)

fun solution(n: Int, info: IntArray): IntArray {
    val heap = PriorityQueue<Data>(compareBy { it.score })
    var answer: IntArray = intArrayOf()
    return answer
}

fun main() {

}