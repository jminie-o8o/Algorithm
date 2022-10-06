package 프로그래머스.`멀쩡한 사각형`

fun solution(w: Int, h: Int): Long {
    val wl = w.toLong()
    val hl = h.toLong()
    return if (wl >= hl) wl * hl - (wl + hl - gcd(wl, hl))
    else hl * wl - (hl + wl - gcd(hl, wl))
}

fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) a
    else gcd(b, a % b)
}

fun main() {
    println(solution(12, 4))
}