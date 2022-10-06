package 프로그래머스.`숫자 문자열과 영단어`

fun solution(s: String): Int {
    val numberMap = mapOf(
        "zero" to 0,
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
    )
    var answer = s
    numberMap.forEach {
        if (answer.contains(it.key)) answer = answer.replace(it.key, it.value.toString())
    }
    return answer.toInt()
}

fun main() {
    println(solution("one4seveneight"))
    println(solution("onefourseveneight"))
    println(solution("23four5six7"))
    println(solution("2three45sixseven"))
    println(solution("123"))
}