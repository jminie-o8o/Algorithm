package 프로그래머스.`수식 최대화`

import kotlin.math.abs

fun solution(expression: String): Long {
    var answer: Long = 0
    val priority = arrayOf(
        arrayOf('-', '+', '*'),
        arrayOf('+', '*', '-'),
        arrayOf('+', '-', '*'),
        arrayOf('-', '*', '+'),
        arrayOf('*', '+', '-'),
        arrayOf('*', '-', '+')
    )
    for (case in priority) {
        val temp = abs(dfs(expression, 0, case))
        if (answer < temp)
        answer = temp
    }
    return answer
}

fun dfs(expression: String, depth: Int, case: Array<Char>): Long {
    // 탈출조건
    if (depth > 2) return expression.toLong()

    // 수행조건
    val tokens = expression.split(case[depth])
    var result: Long? = null
    for (token in tokens) {
        val value = dfs(token, depth + 1, case)
        result = if (result == null) {
            value
        } else {
            calc(result, value, case[depth])
        }
    }
    return result ?: 0L
}

fun calc(a: Long, b: Long, op: Char): Long {
    return when (op) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        else -> throw IllegalArgumentException()
    }
}

fun main() {
    solution("100-200*300-500+20")
}