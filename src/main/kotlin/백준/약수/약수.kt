package 백준.약수

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.sorted()
    println(arr.first() * arr.last())
}