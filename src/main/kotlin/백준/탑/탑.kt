package 백준.탑

import java.util.*

//fun main() = with(System.`in`.bufferedReader()) {
//    val n = readLine()!!.toInt()
//    val towerList = readLine()!!.split(" ").map { it.toInt() }.reversed()
//    val answer = Array(n) { 0 }
//    var max = Int.MIN_VALUE
//    for (i in 0 until n) {
//        val currHigh = towerList[i] // 현재 타워 높이
//        if (i == 0) continue
//        if (max < currHigh) {
//            max = currHigh
//            answer[i] = towerList.indexOf(currHigh)
//        }
//    }
//    println(answer.contentToString())
//}

//fun main() = with(System.`in`.bufferedReader()) {
//    val n = readLine()!!.toInt()
//    val towerList = readLine()!!.split(" ").map { it.toInt() }.reversed()
//    val answer = Array(n) { 0 }
//    for (i in 0 until n - 1) {
//        val curr = towerList[i]
//        for (j in i + 1 until n) {
//            if (curr <= towerList[j]) { // 처음으로 curr 보다 큰 타워를 만나는 경우
//                answer[i] = j
//                break
//            }
//        }
//    }
//
//
//    for (i in answer.indices) {
//        if (answer[i] != 0) answer[i] = n - answer[i]
//    }
//    println(answer.reversed().joinToString(" "))
//}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    val towerList = readLine()!!.split(" ").map { it.toInt() }
    val stack = Stack<Pair<Int, Int>>() // 첫 번째 원소가 높이, 두 번째가 인덱스
    val answer = mutableListOf<Int>()
    stack.push(Pair(towerList[0], 1)) // 첫 번째 값을 Stack 에 추가
    answer.add(0) // 첫 번째 타워는 무조건 0
    var isStackEmpty = true
    for (i in 1 until n) {
        while (stack.isNotEmpty()) {
            if (towerList[i] >= stack.peek().first) { // 다음 타워가 Stack 보다 높을 때
                stack.pop()
                isStackEmpty = true // 스택이 모두 비었다는 신호
            } else { // Stack 상단이 다음 타워보다 높을 때
                answer.add(stack.peek().second)
                stack.push(Pair(towerList[i], i + 1))
                isStackEmpty = false
                break
            }
        }
        if (isStackEmpty) {
            answer.add(0)
            stack.push(Pair(towerList[i], i + 1))
        }
    }
    println(answer.joinToString(" "))
}