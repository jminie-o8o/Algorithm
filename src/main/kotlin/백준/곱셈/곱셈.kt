package 백준.곱셈

fun fpow(a: Long, b: Long, c: Long): Long {
    if (b == 1L) return a % c
    var x = fpow(a, b / 2, c)
    return if (b % 2 == 0L) {
        (x * x) % c
    } else {
        ((x * x) % c * a) % c
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (a, b, c) = readLine()!!.split(" ").map { it.toLong() }
    println(fpow(a, b, c))
}