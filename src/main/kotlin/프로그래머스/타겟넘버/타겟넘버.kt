package 프로그래머스.타겟넘버

class Solution {
    // 재귀함수를 짤 때는 전달받은 파라미터를 멤버변수로 옮겨놓는다.
    var numbers = intArrayOf()
    var target = 0
    var answer = 0

    fun solution(numbers: IntArray, target: Int): Int {
        this.numbers = numbers
        this.target = target
        dfs(0, 0)
        return answer
    }

    // 첫번째 인자는 인덱스, 두번째 인자는 누적합
    fun dfs(index: Int, sum: Int) {
        // 1. 탈출조건
        if (index == numbers.size) {
            if (sum == target) answer += 1
            return
        }
        // 2. 수행동작
        dfs(index + 1, sum + numbers[index])
        dfs(index + 1, sum - numbers[index])
    }
}

fun main() {
    println(Solution().solution(intArrayOf(1, 1, 1, 1, 1), 3))
    println(Solution().solution(intArrayOf(4, 1, 2, 1), 4))
}