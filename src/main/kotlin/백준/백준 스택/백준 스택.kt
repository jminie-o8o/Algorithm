package 백준.`백준 스택`

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val stack: Stack<String> = Stack()
    val n = readLine().toInt()

    for (i in 0 until n) {
        val tmp = readLine()?.split(" ")!!
        when (tmp[0]) {
            "push" -> {
                stack.push(tmp[1])
            }
            "pop" -> {
                if (stack.isEmpty()) {
                    println("-1")
                    continue
                }
                println(stack.pop())
            }
            "size" -> {
                println(stack.size.toString())
            }
            "empty" -> {
                if (stack.isEmpty()) {
                    println("1")
                    continue
                }
                else println("0")
            }
            "top" -> {
                if (stack.isEmpty()) {
                    println("-1")
                    continue
                }
                println(stack.peek())
            }
        }
    }
}