package 프로그래머스.프린터

fun solution(priorities: IntArray, location: Int): Int {
    val stack = mutableListOf<Pair<Int, Int>>()
    val temp = mutableListOf<Pair<Int, Int>>()
    for ((index, value) in priorities.withIndex()) {
        temp.add(Pair(index, value))
    }
    while (temp.isNotEmpty()) {
        val curValue = temp[0].second
        val max = temp.maxByOrNull { it.second }?.second!!
        if (curValue >= max) {
            stack.add(temp[0])
            temp.removeFirst()
        } else {
            temp.add(temp[0])
            temp.removeFirst()
        }
    }
    return stack.indexOf(stack.filter { it.first == location }.first()) + 1
}

fun main() {
    println(solution(intArrayOf(2, 1, 3, 2), 2))
}