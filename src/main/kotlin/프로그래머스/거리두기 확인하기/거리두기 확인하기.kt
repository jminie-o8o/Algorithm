package 프로그래머스.`거리두기 확인하기`

import java.util.*

data class Point(val row: Int, val col: Int, val distance: Int)

fun solution(places: Array<Array<String>>): IntArray {
    var answer = mutableListOf<Int>()
    for (i in (0..4)) {
        if (check(places[i])) answer.add(1)
        else answer.add(0)
    }
    return answer.toIntArray()
}

fun check(place: Array<String>): Boolean {
    for (r in (0..4)) {
        for (c in (0..4)) {
            if (place[r][c] == 'P') {
                if (!bfs(place, r, c)) return false // 한명이라도 거리두기를 지키지 않았다면
            }
        }
    }
    return true // 모두 거리두기를 지켰다면
}

fun bfs(place: Array<String>, row: Int, col: Int): Boolean {
    val visited = Array(5) { Array(5) { false } } // Boolean 타입의 5 X 5 방문 행렬
    visited[row][col] = true // 방문한 위치를 true 로 변경해준다.
    val queue: Queue<Point> = LinkedList() // BFS 를 위한 큐
    val dx = intArrayOf(1, 0, -1, 0) // 다음 x좌표 계산을 위한 (상 우 하 좌) 중 (상, 하) 계산
    val dy = intArrayOf(0, 1, 0, -1) // 다음 x좌표 계산을 위한 (상 우 하 좌) 중 (좌, 우) 계산
    queue.add(Point(row, col, 0))

    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        if (curr.distance > 2) continue
        if (curr.distance != 0 && place[curr.row][curr.col] == 'P') return false
        for (i in (0..3)) {
            val newRow = curr.row + dx[i]
            val newCol = curr.col + dy[i]
            if (newRow < 0 || newRow > 4 || newCol < 0 || newCol > 4) continue // 5 X 5 행렬을 넘어가지 않도록 처리
            if (visited[newRow][newCol]) continue // 이미 방문한 곳은 넘어가도록 처리
            if (place[newRow][newCol] == 'X') continue // 파티션이 있는 곳은 넘어가도록 처리
            visited[newRow][newCol] = true
            queue.add(Point(newRow, newCol, curr.distance + 1))
        }
    }
    return true
}

fun main() {
    println(
        solution(
            arrayOf(
                arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
                arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
                arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
                arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
                arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"),
            )
        ).contentToString()
    )
}