package 백준.일곱난쟁이

fun main() = with(System.`in`.bufferedReader()) {
    val list = mutableListOf<Int>()
    for (i in 0 until 9) {
        val n = readLine()!!.toInt()
        list.add(n)
    }
    val answer = mutableListOf<List<Int>>()
    combination(answer, list, Array(list.size) { false }, 0, 7)
    for (i in answer) {
        if (i.sum() == 100) {
            val temp = i.sorted()
            for (j in temp) println(j)
            break
        }
    }
}

fun <T> combination(answer: MutableList<List<T>>, el: List<T>, ck: Array<Boolean>, start: Int, target: Int) {
    if (target == 0) {
        answer.addAll(listOf(el.filterIndexed { index, _ -> ck[index] }))
    } else {
        for (i in start until el.size) {
            ck[i] = true
            combination(answer, el, ck, i + 1, target - 1)
            ck[i] = false
        }
    }
}
