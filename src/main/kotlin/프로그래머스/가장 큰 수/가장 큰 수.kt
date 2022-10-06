package 프로그래머스.`가장 큰 수`

fun solution(numbers: IntArray): String {
    val answer = numbers.sortedByDescending { it.toString().repeat(3) }.joinToString("")
    return if (answer.first() == '0') {
        "0"
    } else {
        answer
    }
}

fun main() {
    solution(intArrayOf(3, 30, 34, 5, 9))
}