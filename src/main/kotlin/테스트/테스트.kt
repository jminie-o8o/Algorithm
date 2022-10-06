package 테스트

fun main() {
    val list: MutableList<Pair<String, Int>> =
        mutableListOf("d" to 4, "a" to 10, "c" to 8, "h" to 5)
    val sortListByFirst = list.sortedBy { it.first }
    val sortListBySecond = list.sortedBy { it.second }
    println(sortListByFirst)
    println(sortListBySecond)
}