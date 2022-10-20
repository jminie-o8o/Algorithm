package 백준.`하노이 탑`

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    var count = 0
    val n = readLine()!!.toInt()
    fun hanoi(roundCount: Int, start: Int, target: Int, assist: Int) {
        if (roundCount == 1) {
            sb.append("$start $target\n")
            count += 1
            return
        }
        hanoi(roundCount - 1, start, assist, target)
        sb.append("$start $target\n")
        count += 1
        hanoi(roundCount - 1, assist, target, start)
    }
    hanoi(n, 1, 3, 2)
    println(count)
    println(sb)
}
