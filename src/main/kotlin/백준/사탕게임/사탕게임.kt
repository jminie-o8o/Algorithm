package 백준.사탕게임

fun check(a: Array<CharArray>): Int {
    val n = a.size
    var ans = 1
    for (i in 0 until n) {
        var cnt = 1 // 현재까지 얼마나 연속됐는지 저장
        for (j in 1 until n) { // 오른쪽 확인
            if (a[i][j] == a[i][j - 1]) cnt += 1
            else cnt = 1
            if (ans < cnt) ans = cnt
        }
        cnt = 1
        for (j in 1 until n) { // 아래쪽 확인
            if (a[j][i] == a[j - 1][i]) cnt += 1
            else cnt = 1
            if (ans < cnt) ans = cnt
        }
    }
    return ans
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    val a = Array(n) { CharArray(n) }
    for (i in 0 until n) {
        a[i] = readLine()!!.toCharArray()
    }
    var ans = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (j + 1 < n) {
                var t = a[i][j]; a[i][j] = a[i][j + 1]; a[i][j + 1] = t // 양 옆을 스와핑하는 로직
                val temp = check(a)
                if (ans < temp) ans = temp
                t = a[i][j]; a[i][j] = a[i][j + 1]; a[i][j + 1] = t // 원상복구
            }
            if (i + 1 < n) {
                var t = a[i][j]; a[i][j] = a[i + 1][j]; a[i + 1][j] = t // 위 아래를 스와핑하는 로직
                val temp = check(a)
                if (ans < temp) ans = temp
                t = a[i][j]; a[i][j] = a[i + 1][j]; a[i + 1][j] = t // 원상복구
            }
        }
    }
    println(ans)
}