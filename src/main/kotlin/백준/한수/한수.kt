package 백준.한수

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    if (n <= 99) println(n)
    else {
        var answer = 0
        for (i in 100..n) {
            val temp = i.toString().toList()
            if (check(temp)) answer ++
        }
        println(answer + 99)
    }
}

fun check(list: List<Char>): Boolean {
    val temp1 = list[0] - list[1]
    val temp2 = list[1] - list[2]
    if (temp1 == temp2) return true
    return false
}