package 프로그래머스.`n^2 배열 자르기`

fun solution(n: Int, left: Long, right: Long): IntArray {

    var answer = IntArray((right-left).toInt() + 1)
    var idx = left

    for(i in answer.indices){
        val r = (idx / n.toLong()).toInt()
        val c = (idx % n.toLong()).toInt()
        answer[i] = if (r >= c) r + 1
        else  c + 1
        idx++
    }
    return answer
}

fun main() {
    println(solution(3, 2, 5).contentToString())
    println(solution(4, 7, 14).contentToString())
    val str2 = "AAABBBCCC"
    val arr2 = str2.chunked(1)
    println(arr2)
    println(arr2[0])
    println(arr2[1])
    println(arr2[3])
}