package 백준.`균형잡힌 세상`

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val text = readLine()
        if (text == ".") {
            break
        }
        val stack = Stack<Char>()

        var isBalanced = true
        text.forEach {
            if (it == '(' || it == '[') {
                stack.push(it)
            } else if (it == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop()
                } else {
                    isBalanced = false
                    return@forEach
                }
            } else if (it == ']') {
                if (!stack.empty() && stack.peek() == '[') {
                    stack.pop()
                } else {
                    isBalanced = false
                    return@forEach
                }
            }
        }
        if (stack.isNotEmpty()) {
            isBalanced = false
        }
        println(
            when (isBalanced) {
                true -> "yes"
                else -> "no"
            }
        )
    }
}
