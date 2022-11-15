package 백준.N과M

val check = BooleanArray(10) // 어떤 수를 사용한 수인지 사용하지 않은 수인지
val result = IntArray(10) // 수열 저장
val sb = StringBuilder()

// index 번째의 수를 결정
fun dfs(index: Int, n: Int, m: Int) {
    // 탈출조건
    if (index == m) {
        for (i in 0 until m) {
            sb.append(result[i])
            if (i != m - 1) sb.append(" ")
        }
        sb.append("\n")
        return
    }
    // 수행조건
    for (i in 1..n) {
        if (check[i]) continue // i 번째 수는 사용했으므로 건너뜀
        check[i] = true
        result[index] = i
        dfs(index + 1, n, m)
        check[i] = false
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    dfs(0, n, m)
    print(sb.toString())
}

