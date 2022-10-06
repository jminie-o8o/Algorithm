package 프로그래머스.`k번째 수`

fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
    val answer = mutableListOf<Int>()
    commands.forEach {
        answer.add(slice(array, it))
    }
    return answer.toIntArray()
}

fun slice(array: IntArray, commands: IntArray): Int {
    val temp = array.slice((commands[0] - 1..commands[1] - 1))
    val sortTemp = temp.sorted()
    return sortTemp[commands[2] - 1]
}

fun main() {
    solution(
        intArrayOf(1, 5, 2, 6, 3, 7, 4),
        arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
    )
}