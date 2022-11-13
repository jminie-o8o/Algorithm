package 백준.카잉달력

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine()!!.toInt()
    repeat(t) {
        var (m, n, x, y) = readLine()!!.split(" ").map { it.toInt() }
        x -= 1
        y -= 1
        var k = x
        var flag = false
        while (k <= n * m) {
            if (k % n == y) {
                println(k + 1)
                flag = true
                break
            }
            k += m
        }
        if (!flag) println(-1)
    }
}