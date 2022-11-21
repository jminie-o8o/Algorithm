package 백준.`1, 2, 3 더하기`

// count : 사용한 수의 개수
// sum : count 개를 이용해서 만든 합
fun recursive(sum: Int, goal: Int): Int {
    if (sum > goal) return 0 // 불가능한 경우
    if (sum == goal) return 1 // 정답을 하나 찾은 경우
    var now = 0
    for (i in 1..3) {
        now += recursive(sum + i, goal)
    }
    return now
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    repeat(n) {
        val temp = readLine()!!.toInt()
        println(recursive(0, temp))
    }
}
