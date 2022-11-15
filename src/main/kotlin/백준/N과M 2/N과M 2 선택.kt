package 백준.`N과M 2`

val a = IntArray(10) // 수열 저장
val stringBuilder = StringBuilder()

fun go(index: Int, selected: Int, n: Int, m: Int) {
    // 탈출조건
    if (selected == m) {
        // 수열 출력
        for (i in 0 until m) {
            stringBuilder.append(a[i])
            if (i != m - 1) stringBuilder.append(" ")
        }
        stringBuilder.append("\n")
        return
    }

    // index : 수
    // selected : 선택한 수의 개수
    if (index > n) return
    a[selected] = index
    go(index + 1, selected + 1, n, m) // 수를 선택했다면 선택한 수의 개수 즉 selected 1 증가
    a[selected] = 0
    go(index + 1, selected, n, m)
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    go(1, 0, n, m)
    print(stringBuilder.toString())
}

