package 백준.파일정리

// 풀이 1
//fun main() = with(System.`in`.bufferedReader()) {
//    val n = readLine()!!.toInt()
//    val result = mutableListOf<String>()
//    repeat(n) {
//        val extension = readLine()!!.split(".")[1]
//        result.add(extension)
//    }
//    val resultGroup = result.groupBy { it }.toList().sortedBy { (key, _) -> key }.toMap()
//    resultGroup.forEach {
//        print(it.key)
//        print(" ")
//        print(it.value.size)
//        println()
//    }
//}

// 풀이 2
fun main() = with(System.`in`.bufferedReader()) {
    val map = mutableMapOf<String, Int>()
    val n = readLine()!!.toInt()
    repeat(n) {
        val extension = readLine()!!.split(".")[1]
        if (map.containsKey(extension)) {
            map[extension] = map[extension]!! + 1
        } else {
            map[extension] = 1
        }
    }
    map.toSortedMap().forEach {
        println("${it.key} ${it.value}")
    }
}