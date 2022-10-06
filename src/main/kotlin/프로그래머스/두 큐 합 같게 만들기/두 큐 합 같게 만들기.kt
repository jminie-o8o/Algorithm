package 프로그래머스.`두 큐 합 같게 만들기`

import java.util.*

//fun solution(queue1: IntArray, queue2: IntArray): Int {
//    val q1 = queue1.toMutableList()
//    val q2 = queue2.toMutableList()
//    if ((q1.sum().toLong() + q2.sum().toLong()) % 2 != 0L) return -1
//    var count = 0
//    var sum1 = q1.sum().toLong()
//    var sum2 = q2.sum().toLong()
//    while (sum1 != sum2) {
//        if (q1.isEmpty() || q2.isEmpty()) return -1
//        if (sum2 > sum2) {
//            sum1 += q2.first()
//            sum2 -= q2.first()
//            q1.add(q2.removeFirst())
//            count += 1
//        } else if (sum2 < sum1) {
//            sum2 += q1.first()
//            sum1 -= q1.first()
//            q2.add(q1.removeFirst())
//            count += 1
//        }
//    }
//    return count
//}

fun solution(queue1: IntArray, queue2: IntArray): Int {
    val q1: Queue<Long> = LinkedList()
    val q2: Queue<Long> = LinkedList()
    for (i in queue1) q1.offer(i.toLong())
    for (i in queue2) q2.offer(i.toLong())
    if ((q1.sum() + q2.sum()) % 2 != 0L) return -1
    var sum1 = q1.sum()
    var sum2 = q2.sum()
    for (i in 0 until q1.size * 3) {
        if (sum1 == sum2) return i
        if (sum2 > sum1) {
            sum1 += q2.first()
            sum2 -= q2.first()
            q1.offer(q2.poll())
        } else if (sum2 < sum1) {
            sum2 += q1.first()
            sum1 -= q1.first()
            q2.offer(q1.poll())
        }
    }
    return -1
}

fun main() {

}