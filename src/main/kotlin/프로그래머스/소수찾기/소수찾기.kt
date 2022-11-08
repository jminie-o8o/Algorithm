package 프로그래머스.소수찾기

import kotlin.math.sqrt

val numberSet = HashSet<Int>()

fun solution(numbers: String): Int {
    recursive("", numbers)
    var answer = 0
    numberSet.forEach {
        if (isPrime(it)) answer++
    }
    return answer
}

fun recursive(comb: String, others: String) {
    // 1. 현재 조합을 set 에 추가한다. (Set 이므로 중복을 알아서 처리)
    if (comb != "") numberSet.add(comb.toInt())
    // 2. 남은 숫자 중 한개를 더 해 새로운 조합을 만든다.
    for (i in others.indices) {
        recursive(comb + others[i], others.substring(0, i) + others.substring(i + 1))
    }
}

fun isPrime(num: Int): Boolean {
    if (num <= 1) return false
    return (2..sqrt(num.toDouble()).toInt()).none { num % it == 0 }
}


fun main() {
    solution("011")
}