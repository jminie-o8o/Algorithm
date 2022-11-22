package 백준.퇴사

import java.util.Scanner

var answer = 0

// day 일이 되었다. day 일에 있는 상담을 할지 말지 결정해야 한다.
// 지금까지 얻은 수익은 sum 이다.
// sum : day - 1일 까지 얻은 수익
fun go(day: Int, sum: Int, t: IntArray, p: IntArray, n: Int) {
    // 불가능한 경우
    if (day > n) return
    // 정답을 찾은 경우
    if (day == n) {
        if (answer < sum) answer = sum
        return
    }
    go(day + t[day], sum + p[day], t, p, n)
    go(day + 1, sum, t, p, n)
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val t = IntArray(n)
    val p = IntArray(n)
    for (i in 0 until n) {
        t[i] = sc.nextInt()
        p[i] = sc.nextInt()
    }
    go(0, 0, t, p, n)
    println(answer)
}