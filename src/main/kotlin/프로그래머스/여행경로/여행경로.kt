package 프로그래머스.여행경로

import java.util.*

class Solution {
    // 방문 여부를 확인하는 BooleanArray
    var check = booleanArrayOf()
    // dfs 처리를 위한 Stack
    val stack: Stack<String> = Stack()
    // 최종 가능한 경로가 들어가는 String 타입의 MutableList
    val list = mutableListOf<String>()

    fun solution(tickets: Array<Array<String>>): Array<String> {
        for (i in tickets.indices) {
            if (tickets[i][0] == "ICN") { // 만약의 항공권의 출발지점이 ICN 이라면
                check = BooleanArray(tickets.size) { false } // tickets 의 사이즈만큼 BooleanArray 설정
                stack.add("ICN"); stack.add(tickets[i][1]) // Stack 에 ICN 과 도착지를 넣어준다.
                check[i] = true // 스택에 넣어준 티켓 위치는 true 로 바꾸어준다.
                dfs(tickets, 1) // dfs 함수에 tickets 리스트와 depth 1 을 매개변수로 실행
                check[i] = false
                stack.pop(); stack.pop()
            }
        }
        return list.sorted()[0].split(",").toTypedArray()
    }

    fun dfs(tickets: Array<Array<String>>, depth: Int) {
        // 탈출조건
        if (depth == tickets.size) {
            list.add(stack.joinToString(","))
            return
        }
        // 수행조건
        else {
            val nextDestination = stack.peek()!!
            for (i in tickets.indices) {
                if (check[i]) continue
                if (tickets[i][0] == nextDestination) {
                    stack.add(tickets[i][1])
                    check[i] = true
                    dfs(tickets, depth + 1)
                    stack.pop()
                    check[i] = false
                }
            }
        }
    }
}

fun main() {
    Solution().solution(
        arrayOf(
            arrayOf("ICN", "JFK"),
            arrayOf("HND", "IAD"),
            arrayOf("JFK", "HND")
        )
    )


//    Solution().solution(
//        arrayOf(
//            arrayOf("ICN", "SFO"),
//            arrayOf("ICN", "ATL"),
//            arrayOf("SFO", "ATL"),
//            arrayOf("ATL", "ICN"),
//            arrayOf("ATL", "SFO")
//        )
//    )
}