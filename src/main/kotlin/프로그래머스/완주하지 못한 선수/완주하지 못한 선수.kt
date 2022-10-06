package 프로그래머스.`완주하지 못한 선수`

fun solution(participant: Array<String>, completion: Array<String>): String {
    val hash = mutableMapOf<Int, String>() // Map 은 key 중복 불가
    var temp = 0
    participant.forEach {
        temp += it.hashCode()
        hash[it.hashCode()] = it
    }
    completion.forEach { temp -= it.hashCode() }
    return hash[temp] ?: ""
}

fun main() {
    println(solution(arrayOf("leo", "kiki", "eden"), arrayOf("eden", "kiki")))
    println(solution(arrayOf("mislav", "stanko", "mislav", "ana"), arrayOf("stanko", "ana", "mislav")))
}