package 백준.단지번호붙이기

import java.util.*

data class Node(val x: Int, val y: Int)

val dx = arrayListOf(0, 1, 0, -1)
val dy = arrayListOf(1, 0, -1, 0)
var answer = 0
val result = mutableListOf<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    // 0 으로 이루어진 n x n 정사각형 지도 만들기
    val maps = Array(n) { Array(n) { 0 } }
    for (i in 0 until n) maps[i] = readLine()!!.toList().map { it.digitToInt() }.toTypedArray()

    fun bfs(x: Int, y: Int): Int {
        var count = 0
        val queue: Queue<Node> = LinkedList()
        queue.offer(Node(x, y))
        // 처음 시작하는 부분을 2로 바꾸고 시작한다.
        maps[x][y] = 2
        count += 1
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            for (i in (0..3)) {
                val nextX = current.x + dx[i]
                val nextY = current.y + dy[i]
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || maps[nextX][nextY] != 1) continue
                maps[nextX][nextY] = 2
                count += 1
                queue.offer(Node(nextX, nextY))
            }
        }
        return count
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (maps[i][j] == 1) {
                result.add(bfs(i, j))
                answer += 1
            }
        }
    }
    println(answer)
    result.sort()
    result.forEach {
        println(it)
    }
}


