package 백준.`30`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toList().map { it.toString() }
    val numList = n.sortedDescending()
    var sum = 0
    for (i in numList) {
        sum += i.toInt()
    }
    if (numList.last() == "0" && sum % 3 == 0) {
        println(numList.joinToString(""))
    } else {
        println("-1")
    }
}