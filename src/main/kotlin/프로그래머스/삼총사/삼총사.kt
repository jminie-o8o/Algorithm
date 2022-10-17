package 프로그래머스.삼총사

class Solution {
    fun solution(number: IntArray): Int {
        var answer = 0
        for (i in 0 until number.size - 2) {
            for (j in i + 1 until number.size - 1) {
                for (k in j + 1 until number.size) {
                    if (number[i] + number[j] + number[k] == 0) answer += 1
                }
            }
        }
        return answer
    }
}


fun main() {
    Solution().solution(intArrayOf(-2, 3, 0, 2, -5))
}