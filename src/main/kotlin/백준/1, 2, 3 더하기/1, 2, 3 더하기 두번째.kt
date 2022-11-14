package 백준.`1, 2, 3 더하기`

fun go(s: Int, goal: Int): Int {
    if (s > goal) return 0
    if (s == goal) return 1
    var now = 0
    for (i in 1..3) {
        now += go(s + i, goal)
    }
    return now
}

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        println(go(0, n))
    }
}