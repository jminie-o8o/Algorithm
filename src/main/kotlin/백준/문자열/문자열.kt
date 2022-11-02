package 백준.문자열

fun main() = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine()!!.split(" ")
    val diff = b.length - a.length
    var answer = Integer.MAX_VALUE
    for (i in 0..diff) {
        var count = 0
        for (j in a.indices) {
            if (a.toCharArray()[j] != b.toCharArray()[i + j]) count ++
        }
        if (answer > count) answer = count
    }
    println(answer)
}