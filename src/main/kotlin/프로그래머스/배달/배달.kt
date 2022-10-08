package 프로그래머스.배달

import java.util.PriorityQueue

// 가중치가 있는 최단거리는 다익스트라 알고리즘 사용
// 다익스트라 알고리즘을 사용하기 위해서는 우선순위 큐가 필요하다.
// 우선순위 큐를 이용하려면 Node 를 비교가 가능한 객체로 만들어야 한다.
data class Node(val index: Int, val distance: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.distance.compareTo(other.distance)
    }
}

fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
    // 최대 배달가능 시간이 5000000 이므로 각 배열을 500001 로 초기화 후 첫번째 원소를 0으로 설정
    val distanceArray = IntArray(N + 1) { 500001 }.apply { this[1] = 0 }
    // 우선순위 큐 생성 후 첫 노드 추가
    val pq = PriorityQueue<Node>().apply { offer(Node(1, 0)) }
    while (pq.isNotEmpty()) {
        // 현재 노드를 꺼냄
        val curr = pq.poll()
        // 최단거리를 구하는 것이므로 현재 거리가 저장한 거리보다 크면 continue
        if (curr.distance > distanceArray[curr.index]) continue
        for (i in road.indices) {
            // 현재 위치가 road[i][0] 와 일치할 경우
            if (road[i][0] == curr.index) {
                // 다음 위치로 가는 비용 계산 (현재까지의 거리 + 현재 road 거리)
                val cost = curr.distance + road[i][2]
                // 다음 인덱스 저장
                val nextIdx = road[i][1]
                // 다음 위치로 가는 비용이 저장된 값보다 작을 경우 distanceArray 을 작은값으로 초기화
                // 그리고 우선순위큐에 다음 노드 삽입
                if (cost < distanceArray[nextIdx]) {
                    distanceArray[nextIdx] = cost
                    pq.offer(Node(nextIdx, cost))
                }
            }
            else if (road[i][1] == curr.index) {
                // 다음 위치로 가는 비용 계산
                val cost = curr.distance + road[i][2]
                // 다음 인덱스 저장
                val nextIdx = road[i][0]
                // 다음 위치로 가는 비용이 저장된 값보다 작을 경우 distanceArray 을 작은값으로 초기화
                // 그리고 우선순위큐에 다음 노드 삽입
                if (cost < distanceArray[nextIdx]) {
                    distanceArray[nextIdx] = cost
                    pq.offer(Node(nextIdx, cost))
                }
            }
        }
    }
    // distanceArray 에서 k보다 작거나 같은 값의 개수를 반환
    return distanceArray.count { it <= k }
}

fun main() {
    solution(
        5,
        arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 3, 3),
            intArrayOf(5, 2, 2),
            intArrayOf(1, 4, 2),
            intArrayOf(5, 3, 1),
            intArrayOf(5, 4, 2)
        ),
        3
    )
}