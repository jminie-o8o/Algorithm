package 백준.N과M

val c = BooleanArray(8)
val a = IntArray(8)
val stringBuilder = StringBuilder()

fun dfsPractice(depth: Int, n: Int, m: Int) {
    // 탈출조건
    if (depth == m) {
        for (i in 0 until m) {
            stringBuilder.append(a[i])
            if (i != m - 1) stringBuilder.append(" ")
        }
        stringBuilder.append("\n")
        return
    }

    // 수행조건
    for (i in 1..n) {
        if (c[i]) continue
        c[i] = true; a[depth] = i
        dfsPractice(depth + 1, n, m)
        c[i] = false
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    dfsPractice(0, n, m)
    println(stringBuilder)
}