package 백준.`1`

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val n = readLine().toInt() ?: break
        var temp = 0
        var i = 1
        while (true) {
            temp = temp * 10 + 1
            temp %= n
            if (temp == 0) { // n의 배수이
                println(i) // 배수의 길이를 출력
                break
            }
            i += 1
        }
    }
}