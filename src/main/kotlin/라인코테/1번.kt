//package 라인코테
//
//import kotlin.math.pow
//
//fun solution(queries: Array<IntArray>): Int {
//    val temp1 = mutableMapOf<Int, Int>()
//    val temp2 = mutableMapOf<Int, Int>()
//    queries.forEach { temp1[it[0]] = 0 }
//    queries.forEach { temp2[it[0]] = 0 }
//    var count = 0
//    queries.forEach {
//        if (temp2[it[0]]!! < temp1[it[0]]?.plus(it[1])!!) {
//            temp2[it[0]] = temp2[it[0]]?.plus(addPow(it[1]))!!
//            count += temp1[it[0]]!!
//        }
//        temp1[it[0]] = temp1[it[0]]?.plus(it[1])!! // 모든 경우 value 를 더한다
//    }
//    return count
//}
//
//fun addPow(num: Int): Int {
//    var flag = true
//    var temp = 0
//    while (flag) {
//        val a : Int = (2.0).pow(temp).toInt() // = 5^2 = 25
//        if (a >= num) {
//            return a
//        } else {
//            temp += 1
//        }
//    }
//    return -1
//}
//
//fun main() {
//    solution(arrayOf(intArrayOf(2, 10), intArrayOf(7, 1), intArrayOf(2, 5), intArrayOf(2, 9), intArrayOf(7, 32)))
//}