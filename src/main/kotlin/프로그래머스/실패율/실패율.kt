package 프로그래머스.실패율

import java.util.*

fun solution(N: Int, stages: IntArray): IntArray {
    var len = stages.size
    val percentage = mutableMapOf<Int, Float>()
    val map = mutableMapOf<Int, Int>().apply {
        for (i in (1..N + 1)) {
            this[i] = 0
        }
    }
    for (stage in stages) {
        map[stage] = map[stage]!! + 1
    }
    for (item in map) {
        if (len == 0) {
            percentage[item.key] = 0f
            continue
        }
        percentage[item.key] = item.value.toFloat() / len
        len -= item.value
    }
    val test = percentage.values.toMutableList()
    test.removeLast()
    val result = mutableMapOf<Int, Float>()
    for (i in test.indices) {
        result[i + 1] = test[i]
    }
    val answer = sortMapByValue(result)
    return answer.keys.toIntArray()
}

fun sortMapByValue(map: MutableMap<Int, Float>): MutableMap<Int, Float> {
    val entries = LinkedList(map.entries)
    entries.sortByDescending { it.value }

    val result = mutableMapOf<Int, Float>()
    for (entry in entries) {
        result[entry.key] = entry.value
    }
    return result
}

fun sortMapByValueInt(map: MutableMap<Int, Int>): MutableMap<Int, Int> {
    val entries = LinkedList(map.entries)
    entries.sortByDescending { it.value }

    val result = mutableMapOf<Int, Int>()
    for (entry in entries) {
        result[entry.key] = entry.value
    }
    return result
}

fun main() {
//    solution(5, intArrayOf(3, 3, 3, 3))
    val test = mutableMapOf<Int, Int>().apply {
        for (i in 1..10) {
            this[i] = i * 2
        }
    }
    sortMapByValueInt(test)

}