package 프로그래머스.피로도

// or: 원본 데이터로써 변하지 않음 (original)
// fin: 원소를 담는 리스트로써 기본값은 listOf()
// sub: fin 이 담는 리스트라면 sub 은 빼는 리스트 (기본 값은 el)
fun <T> permutationExam(or: List<T>, fin: List<T> = listOf(), sub: List<T> = or): List<List<T>> {
    return if(sub.isEmpty()) listOf(fin)
    else sub.flatMap { permutationExam(or, fin + it, sub - it) }
}

fun <T> permutation(sub: List<T>, fin: List<T> = listOf()): List<List<T>> {
    return if(sub.isEmpty()) listOf(fin)
    else sub.flatMap { permutation(sub - it, fin + it) }
}

fun solution(k: Int, dungeons: Array<IntArray>): Int {
    val dungeonsList = permutation(dungeons.toList())
    val answerList = mutableListOf<Int>()
    dungeonsList.forEach { answerList.add(count(k, it)) }
    // 아래 for 문을 모든 조합에서 수행해야함
    return answerList.maxOrNull()!!
}

fun count(k: Int, dungeons: List<IntArray>): Int {
    var currentK = k
    var count = 0
    for (i in dungeons) {
        if (i.first() > currentK) return count
        currentK -= i.last()
        count += 1
    }
    return count
}

fun main() {
    println(solution(80, arrayOf(intArrayOf(30, 10), intArrayOf(50, 40), intArrayOf(80, 20))))
}