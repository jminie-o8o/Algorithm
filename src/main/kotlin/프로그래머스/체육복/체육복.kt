package 프로그래머스.체육복

fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
    var answer = n
    val death = mutableListOf<Int>()
    val sortLost = lost.sorted().toMutableList()
    val sortReserve = reserve.sorted().toMutableList()
    for (s in sortLost) {
        for (r in sortReserve) {
            if (s == r) {
                death.add(s)
            }
        }
    }
    for (i in death) {
        sortLost.remove(i)
        sortReserve.remove(i)
    }
    for (i in sortLost) {
        if (i - 1 in sortReserve) {
            sortReserve.remove(i - 1)
            continue
        } else if (i + 1 in sortReserve) {
            sortReserve.remove(i + 1)
            continue
        } else {
            answer -= 1
        }
    }
    return answer
}

fun main() {
    println(solution(5, intArrayOf(1, 2, 3), intArrayOf(2, 3, 4)))
    println("--------------")
    println(solution(5, intArrayOf(1, 2), intArrayOf(2, 3)))
    println("--------------")
    println(solution(5, intArrayOf(2, 4), intArrayOf(1, 3)))
}