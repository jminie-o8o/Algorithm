package 백준.카드합체놀이

import java.util.*

//fun main() = with(System.`in`.bufferedReader()) {
//    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
//    val scoreList = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
//    scoreList.sort()
//    var count = 0
//    while (count != m) {
//        val temp = scoreList[0] + scoreList[1]
//        scoreList[0] = temp; scoreList[1] = temp
//        scoreList.sort()
//        count += 1
//    }
//    println(scoreList.sum())
//}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()!!.split(" ").map { it.toLong() }
    val scoreList = readLine()!!.split(" ").map { it.toLong() }.toTypedArray()
    val pq = PriorityQueue<Long>()
    scoreList.forEach { pq.offer(it) }
    val tempQueue: Queue<Long> = LinkedList()
    var count = 0L
    while (count != m) {
        tempQueue.offer(pq.poll())
        tempQueue.offer(pq.poll())
        val temp = tempQueue.poll() + tempQueue.poll()
        pq.offer(temp)
        pq.offer(temp)
        count++
    }
    println(pq.sum())
}