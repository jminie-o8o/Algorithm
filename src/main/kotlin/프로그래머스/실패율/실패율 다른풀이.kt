package 프로그래머스.실패율

fun solution2(N: Int, stages: IntArray): IntArray {
    var answer = IntArray(N)

    val indexMap: MutableMap<Int, Int> = mutableMapOf()
    val failureMap: MutableMap<Int, Double> = mutableMapOf()
    stages.forEach {
        when (indexMap.containsKey(it)) {
            true -> indexMap[it] = indexMap.getValue(it) + 1
            false -> indexMap[it] = 1
        }
    }
    var totalSize = stages.size

    for (i in 1..N) {
        when (indexMap.containsKey(i)) {
            true -> {
                failureMap[i] = (indexMap.getValue(i) / totalSize.toDouble())
                totalSize -= indexMap.getValue(i)
            }
            false -> failureMap[i] = 0.0
        }
    }
    val list = failureMap.toList().sortedByDescending { (_, value) -> value } // Map 중 value를 기준으로 내림차순 정렬
    for (i in 0 until N) {
        answer[i] = list[i].first
    }

    return answer
}

fun main() {
    solution2(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3))
}