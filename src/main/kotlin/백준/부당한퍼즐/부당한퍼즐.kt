package 백준.부당한퍼즐

val arr = mutableListOf<List<Int>>()

fun main() = with(System.`in`.bufferedReader()) {
    val size = readLine()!!.toInt()
    val given = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    val target = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    for (i in 1..size) {
        arr.add(given.toList())
        val reversed = given.reversed()
        arr.add(reversed)
        // given 자체 변화
        given.add(given.removeFirst())
    }
    if (check(arr, target)) println("good puzzle")
    else println("bad puzzle")
}

fun check(arr: MutableList<List<Int>>, target: List<Int>): Boolean {
    arr.forEach {
        if (it == target) return true
    }
    return false
}