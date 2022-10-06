package 백준.`MVP 다이아몬드`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val price = readLine()?.split(" ")!!.map { it.toInt() }
    val tier = readLine()!!
    val tierList = tier.chunked(1)
    var total = 0
    var prev = 0
    for (i in 0 until n) {
        if (tierList[i] == "B") {
            total += price[0] - 1 - prev
            prev = price[0] - 1 - prev
        } else if (tierList[i] == "S") {
            total += price[1] - 1 - prev
            prev = price[1] - 1 - prev
        } else if (tierList[i] == "G") {
            total += price[2] - 1 - prev
            prev = price[2] - 1 - prev
        } else if (tierList[i] == "P") {
            total += price[3] - 1 - prev
            prev = price[3] - 1 - prev
        } else if (tierList[i] == "D") {
            total += price[3]
            prev = price[3]
        }
    }
    println(total)
}