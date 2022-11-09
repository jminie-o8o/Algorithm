package 테스트

val numberSet = HashSet<String>()

fun recursive(comb: String, others: String) {
    // 1. 현재 조합을 set 에 추가한다. (Set 이므로 중복을 알아서 처리)
    if (comb != "") numberSet.add(comb)
    // 2. 남은 숫자 중 한개를 더 해 새로운 조합을 만든다.
    for (i in others.indices) {
        recursive(comb + others[i], others.substring(0, i) + others.substring(i + 1))
    }
}

fun <T> combination(
    answer: MutableList<List<T>>,
    el: List<T>,
    ck: Array<Boolean>,
    start: Int,
    target: Int
) {
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

fun main() {
    val test2 = listOf("a", "b", "c")
    recursive("", test2.joinToString(""))
    println(numberSet)
    println(numberSet.filter { it.length == 3 })

    val test3 = listOf("a", "b", "c")
    val answer = mutableListOf<List<String>>()
    val ck = Array(test3.size) { false }
    combination(answer, test3, ck, 0, 2)
    println(answer)
}


// 순열 (순서를 고려하므로 순서가 바뀌면 다른 것으로 취급)
val numberSetTest = HashSet<String>()

fun permutation(str: String, others: String) {
    if (str != "") numberSet.add(str)
    for (i in others.indices) {
        permutation(str + others[i], others.substring(0, i) + others.substring(i + 1))
    }
}

// 조합 (순서를 고려하지 않으므로 순서가 바뀌어도 같은 것으로 취급)
fun <T> combinationTest(
    answer: MutableList<List<T>>,
    el: List<T>,
    ck: Array<Boolean>,
    start: Int,
    target: Int
) {
    if (target == 0) answer.addAll(listOf(el.filterIndexed { index, _ -> ck[index] }))
    else {
        for (i in start until el.size) {
            ck[i] = true
            combinationTest(answer, el, ck, i + 1, target - 1)
            ck[i] = false
        }
    }
}






