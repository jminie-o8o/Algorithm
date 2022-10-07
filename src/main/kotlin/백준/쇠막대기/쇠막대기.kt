package 백준.쇠막대기

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val inputList = readLine()!!.toMutableList()
    println(inputList)
    var answer = 0
    // base 에 막대기의 총 개수 저장
    var base = 0
    // index 값
    var idx = 0
    // Stack 에 막대기 개수를 저장
    val stack = Stack<Char>()
    while (idx < inputList.size) {
        when (val c = inputList[idx]) {
            '(' -> {
                if (idx + 1 < inputList.size && inputList[idx + 1] == ')') {
                    answer += stack.size
                    idx += 1
                } else {
                    stack.add(c)
                    base += 1
                }
            }
            else -> {
                if (stack.isNotEmpty()) {
                    stack.pop()
                }
            }
        }
        idx += 1
    }
    println("${answer + base}")
}