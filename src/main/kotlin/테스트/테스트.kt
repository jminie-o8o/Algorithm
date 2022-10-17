package 테스트

fun main() {
    val list = listOf("a", "b", "", "c").toMutableList()
    list.removeAll(arrayOf(""))
    println(list)
}