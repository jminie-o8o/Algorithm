package 백준.`N과M 4`

val result = IntArray(10) // 수열 저장
val sb = StringBuilder()

// index 번째의 수를 결정
fun dfs(index: Int, start: Int, n: Int, m: Int) {
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
    // start : index 번째에 올 수 있는 수는 start - n 까지 이다.
    for (i in start..n) {
        result[index] = i
        dfs(index + 1, i, n, m) // 중복이 가능하므로 다음 start 값을 i로 둔다.
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    dfs(0, 1, n, m)
    print(sb.toString())
}