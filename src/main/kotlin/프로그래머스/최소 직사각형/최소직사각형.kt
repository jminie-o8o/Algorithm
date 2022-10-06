package 프로그래머스.`최소 직사각형`

fun solution(sizes: Array<IntArray>): Int {
    val first = mutableListOf<Int>()
    val second = mutableListOf<Int>()
    for (size in sizes) {
        first.add(size.maxOrNull()!!)
        second.add(size.minOrNull()!!)
    }
    return first.maxOrNull()!! * second.maxOrNull()!!
}

fun main() {
    println(solution(arrayOf(
        intArrayOf(10, 7),
        intArrayOf(12, 3),
        intArrayOf(8, 15),
        intArrayOf(14, 7),
        intArrayOf(5, 15)
    )))

    println(solution(arrayOf(
        intArrayOf(14, 4),
        intArrayOf(19, 6),
        intArrayOf(6, 16),
        intArrayOf(18, 7),
        intArrayOf(7, 11)
    )))
}