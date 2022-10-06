package 백준.파일정리

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    val result = mutableListOf<String>()
    repeat(n) {
        val extension = readLine()!!.split(".")[1]
        result.add(extension)
    }
    val resultGroup = result.groupBy { it }.toList().sortedBy { (key, _) -> key }.toMap()
    resultGroup.forEach {
        print(it.key)
        print(" ")
        print(it.value.size)
        println()
    }
}