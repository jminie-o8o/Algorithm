package 백준.유기농배추

import java.util.*

data class Node(val x: Int, val y: Int)

val dx = arrayListOf(0, 1, 0, -1)
val dy = arrayListOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val case = readLine()!!.toInt()
    repeat(case) {
        val (m, n, k) = readLine()!!.split(" ").map { it.toInt() }
        val map = Array(m) { Array(n) { 0 } } // 0으로 이루어진 2차원 배열 작성
        var answer = 0

        // 배추 위치 찍기
        repeat(k) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }
            map[x][y] = 1
        }

        fun bfs(x: Int, y: Int) {
            val queue: Queue<Node> = LinkedList()
            queue.offer(Node(x, y))
            while (queue.isNotEmpty()) {
                val current = queue.poll()

                for (d in 0..3) {
                    val nx = current.x + dx[d]
                    val ny = current.y + dy[d]

                    // 벌레가 지나갈 수 없는 곳은 continue
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || map[nx][ny] != 1) continue

                    // 벌레가 지나갈 수 있는 곳은 모두 2로 바꾸어준다.
                    map[nx][ny] = 2
                    queue.offer(Node(nx, ny))
                }
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (map[i][j] == 1) {
                    bfs(i, j)
                    answer += 1
                    continue
                }
            }
        }
        println(answer)
    }
}