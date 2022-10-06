package 백준.`접미사 배열`

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()!!
    val len = s.length
    val result = mutableListOf<String>()
    for (i in 0 until len) {
        result.add(s.slice(i until len))
    }
    for (i in result.sorted()) println(i)
}