package 프로그래머스.`게임 맵 최단거리`

import java.util.*

data class Node(val x: Int, val y: Int)

fun solution(maps: Array<IntArray>): Int {
    // 최단거리 문제이므로 BFS(큐)로 풀이
    val queue: Queue<Node> = LinkedList() // 코틀린에서 큐는 LinkedList 이용
    val dx = intArrayOf(1, 0, -1, 0) // 다음 x좌표 계산을 위한 (상 우 하 좌) 중 (상, 하) 계산
    val dy = intArrayOf(0, 1, 0, -1) // 다음 x좌표 계산을 위한 (상 우 하 좌) 중 (좌, 우) 계산
    var x = 0
    var y = 0
    queue.offer(Node(x, y)) // 큐에 초기값 저장
    // 큐가 모두 사라질 때까지 반복
    while (queue.isNotEmpty()) {
        val now = queue.poll()
        x = now.x
        y = now.y
        // 다음 좌표를 상 하 좌 우 하나씩 계산
        for (i in IntRange(0, 3)) {
            val nextX = x + dx[i] // 다음 x좌표 계산
            val nextY = y + dy[i] // 다음 y좌표 계산
            // 다음 좌표가 map 영역 안이고 다음 위치가 처음 가는 위치 즉 maps[nextY][nextX] == 1 일 경우
            if (nextX in maps.indices && nextY in maps[0].indices && maps[nextX][nextY] == 1) {
                maps[nextX][nextY] += maps[x][y] // 이전까지 온 값을 다음에 갈 위치에 합한다.
                queue.offer(Node(nextX, nextY)) // 다음 좌표를 큐에다가 offer 해준다.
            }
        }
    }
    println(maps.contentDeepToString())
    return if (maps.last().last() == 1) -1 else maps.last().last()
}

fun main() {
    println(solution(
        arrayOf(
            intArrayOf(1, 0, 1, 1, 1),
            intArrayOf(1, 0, 1, 0, 1),
            intArrayOf(1, 0, 1, 1, 1),
            intArrayOf(1, 1, 1, 0, 1),
            intArrayOf(0, 0, 0, 0, 1)
        )
    ))
    println(solution(
        arrayOf(
            intArrayOf(1, 0, 1, 1, 1),
            intArrayOf(1, 0, 1, 0, 1),
            intArrayOf(1, 0, 1, 1, 1),
            intArrayOf(1, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 1)
        )
    ))
}