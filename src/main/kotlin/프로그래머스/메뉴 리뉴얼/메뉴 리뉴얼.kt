package 프로그래머스.`메뉴 리뉴얼`

import kotlin.math.max

class Solution {
    val foodMaps = mutableListOf<HashMap<String, Int>>()
    val maxCnt = IntArray(11)

    private fun comb(str: List<Char>, pos: Int, candi: StringBuilder) {
        // 탈출조건
        if (pos >= str.size) {
            val len  = candi.length
            if (len >= 2) {
                val cnt = foodMaps[len].getOrDefault(candi.toString(), 0) + 1
                foodMaps[len][candi.toString()] = cnt
                maxCnt[len] = max(maxCnt[len], cnt)
            }
            return
        }

        // 수행조건
        // 선택하는 재귀
        comb(str, pos + 1, candi.append(str[pos]))
        // candi 복원 작업 (마지막에 추가한 문자열 제거)
        candi.setLength(candi.length - 1)
        // 선택 안하는 재귀
        comb(str, pos + 1, candi)
    }

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer = mutableListOf<String>()
        for (i in (0..10)) { foodMaps.add(HashMap()) }
        orders.forEach { str ->
            val sortCharList = str.toList().sorted()
            comb(sortCharList, 0, StringBuilder())
        }
        println(foodMaps)
        println(maxCnt.contentToString())
        for (len in course) {
            for (entry in foodMaps[len]) {
                println(entry)
                if (entry.value >= 2 && entry.value == maxCnt[len]) {
                    answer.add(entry.key)
                }
            }
        }
        println(answer.sorted())
        return answer.sorted().toTypedArray()
    }
}

fun main() {
    Solution().solution(arrayOf("ACD", "CDE", "ACDE"), intArrayOf(2, 3, 4))
}