package 프로그래머스.`약수의 개수와 덧셈`

fun solution(left: Int, right: Int): Int {
    var answer = 0
    for (number in (left..right)) {
        if (count(number) % 2 == 0) answer += number
        else answer -= number
    }
    return answer
}

fun count(number: Int): Int {
    var count = 0
    for (i in 1 until number + 1) {
        if (number % i == 0) count += 1
        else continue
    }
    return count
}

fun main() {
    println(solution(24, 27))
}