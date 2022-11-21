package 백준.`1, 2, 3 더하기`

val result = mutableListOf<List<Int>>()

fun recursive(sum: Int, goal: Int, arr: MutableList<Int>) {
    if (sum > goal) return // 불가능한 경우
    if (sum == goal) {
        result.add(arr.toList())// 정답을 하나 찾은 경우
        return
    }
    for (i in 1..goal) {
        arr.add(i)
        recursive(sum + i, goal, arr)
        arr.removeLast()
    }
}

fun findMax(list: MutableList<List<Int>>): Int {
    var answer = Int.MIN_VALUE
    list.forEach {
        var temp = 1
        for (i in it) {
            temp *= i
        }
        if (temp > answer) answer = temp
    }
    return answer
}

fun main() = with(System.`in`.bufferedReader()) {
    val goal = readLine()!!.toInt()
    recursive(0, goal, mutableListOf())
    println(findMax(result))
}