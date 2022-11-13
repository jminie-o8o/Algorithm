package 백준.`수 이어 쓰기`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    var ans = 0
    var start = 1
    var length = 1
    while (start <= n) {
        var end = start * 10 - 1
        if (end > n) end = n
        ans += (end - start + 1) * length
        start *= 10
        length += 1
    }
    println(ans)
}