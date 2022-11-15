package 백준.부당한퍼즐

fun main() = with(System.`in`.bufferedReader()) {
    val size = readLine()!!.toInt()
    val given = readLine()!!.split(" ").map { it.toInt() }
    var target = readLine()!!.split(" ").map { it.toInt() }
    var firstIndex = target.indexOf(given[0]) // 기준점
    val newList1 = target.slice(firstIndex until target.size)
    target = target.reversed()
    firstIndex = target.indexOf(given[0]) // 기준점
    val newList2 = target.slice(firstIndex until target.size)

    if (given == newList1 || given == newList2) println("good puzzle")
    else println("bad puzzle")
}