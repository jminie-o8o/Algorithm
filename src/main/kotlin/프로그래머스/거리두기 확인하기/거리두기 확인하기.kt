package 프로그래머스.`거리두기 확인하기`

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

data class Point(val row: Int, val col: Int, val distance: Int)

val distanceArray = arrayOf(
    arrayOf(-1, 0),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(0, 1)
) // 상하좌우

fun bfs(place: Array<String>, row: Int, col: Int): Boolean {
    val visited = Array(5) { BooleanArray(5) } // Boolean 타입의 5 X 5 방문 행렬
    val queue = mutableListOf<Point>() // BFS 를 위한 큐
    visited[row][col] = true // 방문한 위치를 true 로 변경해준다.
    queue.add(Point(row, col, 0))

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()
        if (curr.distance > 2) continue
        if (curr.distance != 0 && place[curr.row][curr.col] == 'P') return false
        for (i in (0..3)) {
            val newRow = curr.row + distanceArray[i][0]
            val newCol = curr.col + distanceArray[i][1]
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