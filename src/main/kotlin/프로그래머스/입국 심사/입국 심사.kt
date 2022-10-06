package 프로그래머스.`입국 심사`

fun solution(n: Int, times: IntArray): Long {
    val sortTimes = times.sorted()
    return binarySearch(sortTimes, n, times.last().toLong())
}

fun binarySearch(times: List<Int>, n: Int, max: Long): Long {
    var left: Long = 1
    var right: Long = max * n // 가장 오랜시간 검사를 하는 입국심사관(max) * 사람 수(n)
    var mid: Long
    var answer = Long.MAX_VALUE

    while (left <= right) {
        mid = (left + right) / 2
        if (isPassed(times, n, mid)) {
            if (answer > mid) answer = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return answer
}

fun isPassed(times: List<Int>, n: Int, mid: Long): Boolean {
    var amount: Long = 0

    for (i in times.indices) {
        amount += mid / times[i]
    }
    return amount >= n
}

fun main() {
    println(solution(6, intArrayOf(3, 7)))
}