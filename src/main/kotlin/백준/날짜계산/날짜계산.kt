package 백준.날짜계산

fun main() = with(System.`in`.bufferedReader()) {
    val (E, S, M) = readLine()!!.split(" ").map { it.toInt() }
    var e = 1; var s = 1; var m = 1
    var answer = 1
    while (true) {
        if (e == E && s == S && m == M) {
            println(answer)
            break
        }
        e += 1
        s += 1
        m += 1
        if (e == 16) e = 1
        if (s == 29) s = 1
        if (m == 20) m = 1
        answer += 1
    }
}