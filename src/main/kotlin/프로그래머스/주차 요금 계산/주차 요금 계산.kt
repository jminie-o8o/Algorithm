package 프로그래머스.`주차 요금 계산`

import kotlin.math.ceil

fun solution(fees: IntArray, records: Array<String>): IntArray {
    var map = mutableMapOf<String, MutableList<Int>>()
    records.forEach {
        val key = it.split(" ")[1]
        map.getOrPut(key, ::mutableListOf).add(
            (it.split(" ")[0]
                .split(":")[0]
                .toInt() * 60) + it.split(" ")[0]
                .split(":")[1]
                .toInt())
    }
    map.forEach { if (it.value.size % 2 != 0) it.value.add(1439) }
    map = map.toSortedMap()
    println(map)
    val timeList = mutableListOf<Int>()
    map.forEach {
        var temp = 0
        for (i in it.value.indices) {
            if (i % 2 == 0) temp -= it.value[i]
            else temp += it.value[i]
        }
        timeList.add(temp)
    }
    var answer = mutableListOf<Int>()
    timeList.forEach {
        if (it < fees[0]) answer.add(fees[1])
        else answer.add((fees[1] + (ceil(((it - fees[0]).toDouble() / fees[2])) * fees[3])).toInt())
    }
    println(answer)
    return answer.toIntArray()
}

fun main() {
    solution(
        intArrayOf(180, 5000, 10, 600),
        arrayOf(
            "05:34 5961 IN",
            "06:00 0000 IN",
            "06:34 0000 OUT",
            "07:59 5961 OUT",
            "07:59 0148 IN",
            "18:59 0000 IN",
            "19:09 0148 OUT",
            "22:59 5961 IN",
            "23:00 5961 OUT"
        )
    )

    solution(
        intArrayOf(120, 0, 60, 591),
        arrayOf(
            "16:00 3961 IN",
            "16:00 0202 IN",
            "18:00 3961 OUT",
            "18:00 0202 OUT",
            "23:58 3961 IN"
        )
    )
}