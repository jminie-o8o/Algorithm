package 백준.`문자열 집합`

fun main() = with(System.`in`.bufferedReader()) {
    val (tempN, tempM) = readLine().split(" ")
    val n = tempN.toInt()
    val m = tempM.toInt()
    val tempList = mutableListOf<String>()
    for (i in 0 until n + m) tempList.add(readLine()!!)
    val A = tempList.slice(0 until n)
    val B = tempList.slice(n until n + m)
    var count = 0
    for (i in B) {
        if (i in A) count += 1
    }
    println(count)
}