package 백준.테트로미노

import java.util.*
import kotlin.math.*

var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val board = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        for (j in 0 until m) {
            board[i][j] = st.nextToken().toInt()
        }
    }
    val visited = Array(n) { BooleanArray(m) { false } }

    for (i in 0 until n) {
        for (j in 0 until m) {
            visited[i][j] = true
            dfs(i, j, 1, board[i][j], visited, n, m, board)
            visited[i][j] = false
        }
    }
    println(answer)
}

fun dfs(x: Int, y: Int, step: Int, total: Int, visited: Array<BooleanArray>, n: Int, m: Int, board: Array<IntArray>) {
    // 종료조건 : 블록 4개를 모두 활용한 경우
    if (step == 4) {
        answer = max(answer, total)
        return
    }
    // 수행조건
    val d = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1)) // 좌표 내 상하좌우
    for ((dx, dy) in d) {
        val nx = x + dx // 다음 x 좌표
        val ny = y + dy // 다음 y 좌표
        // 새로운 좌표가 유요한 범위 내에 있고 탐색 이력이 없는 경우
        if ((nx in 0 until n) && (ny in 0 until m) && !visited[nx][ny]) {
            // 2번째 블록까지 연결 한 후 ㅏ ㅗ ㅜ ㅓ 만들기
            if (step == 2) {
                visited[nx][ny] = true // 탐색 기록 추가
                // 새로운 좌표에서 탐색하지 않고 기존 좌표(x, y)에서 탐색
                dfs(x, y, step + 1, total + board[nx][ny], visited, n, m ,board)
                visited[nx][ny] = false // 탐색 기록 삭제
            }
            visited[nx][ny] = true
            // 새로운 좌표에서 (nx, ny)에서 탐색
            dfs(nx, ny, step + 1, total + board[nx][ny], visited, n, m ,board)
            visited[nx][ny] = false
        }
    }
}


