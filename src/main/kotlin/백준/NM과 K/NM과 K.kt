package 백준.`NM과 K`

import java.util.*

val arr = Array(10) { IntArray(10) }
val check = Array(10) { BooleanArray(10) }
var n = 0
var m = 0
var k = 0
var ans = -2147483647
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

// prevX = 이전 선택 칸의 행 번호
// selected = 선택한 칸의 개수
// sum = 선택한 칸의 합
fun dfs(prevX: Int, prevY: Int, selected: Int, sum: Int) {
    // 탈출조건
    if (selected == k) {
        if (ans < sum) ans = sum
        return
    }

    // 수행조건
    for (x in prevX until n) {
        for (y in (if (x == prevX) prevY else 0) until m) {
            if (check[x][y]) continue // 중복선택인지 아닌지 검사
            var ok = true // 선택 가능하면 true, 아니면 false
            // 인접한 네 방향에 대해 검사해서 ok = false 로 바꾸어 줌
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx in 0 until n && ny in 0 until m) {
                    if (check[nx][ny]) ok = false
                }
            }
            if (ok) {
                check[x][y] = true
                dfs(x, y, selected + 1, sum + arr[x][y])
                check[x][y] = false
            }
        }
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    k = sc.nextInt()
    for (i in 0 until n) {
        for (j in 0 until m) {
            arr[i][j] = sc.nextInt()
        }
    }
    dfs(0, 0, 0, 0)
    println(ans)
}