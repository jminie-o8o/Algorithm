package 백준.`좌표정렬하기 2`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    val pairList = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        pairList.add(Pair(a, b))
    }
    pairList.sortWith(compareBy({it.second}, {it.first}))
    pairList.forEach {
        println("${it.first} ${it.second}")
    }
}
