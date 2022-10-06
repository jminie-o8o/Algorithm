package 프로그래머스.`부족한 금액 계산하기`

fun solution(price: Int, money: Int, count: Int): Long {
    val answer = List(count) { ((it + 1) * price).toLong() }.sum() - money
    return if (answer > 0) answer
    else 0
}

fun main() {
    println(solution(3, 20, 4))
}