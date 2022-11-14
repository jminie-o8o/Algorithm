package 백준.`1, 2, 3 더하기`

fun sumFunc(n: Int): Int {
    return when (n) {
        1 -> 1
        2 -> 2
        3 -> 4
        else -> sumFunc(n - 1) + sumFunc(n - 2) + sumFunc(n - 3)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    repeat(n) {
        val temp = readLine()!!.toInt()
        println(sumFunc(temp))
    }
}