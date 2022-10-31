package 백준.`골드바흐의 추측`

val MAX = 1000000

fun main() = with(System.`in`.bufferedReader()) {
    val check = BooleanArray(MAX + 1) // 소수인지 판별 (false 라면 소수이다)
    val prime = ArrayList<Int>() // 소수의 목록
    check[0] = true; check[1] = true
    for (i in 2 until MAX) {
        if (i * i > MAX) break
        if (check[i]) continue
        prime.add(i)
        for (j in i + i until MAX step i) { // 어떤 값의 배수는 모두 소수가 아니므로 true 로 변경
            check[j] = true
        }
    }
    while (true) {
        val n = readLine()!!.toInt()
        if (n == 0) break
        for (i in 1 until prime.size) {
            val p = prime[i]
            if (!check[n - p]) {
                println("$n = $p + ${n - p}")
                break
            }
        }
    }
}