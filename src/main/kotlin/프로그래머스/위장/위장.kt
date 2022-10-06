package 프로그래머스.위장

fun solution(clothes: Array<Array<String>>): Int {
    val hash = mutableMapOf<String, Int>()
    for (cloth in clothes) {
        if (hash.containsKey(cloth.last())) {
            hash[cloth.last()] = hash[cloth.last()]?.plus(1)!!
        } else {
            hash[cloth.last()] = 1
        }
    }
    var cnt = 1
    for (value in hash.values) {
        cnt *= value + 1
    }
    return cnt - 1
}

fun main() {
    solution(arrayOf(arrayOf("yellow_hat", "headgear"), arrayOf("blue_sunglasses", "eyewear"), arrayOf("green_turban", "headgear")))
    solution(arrayOf(arrayOf("crow_mask", "face"), arrayOf("blue_sunglasses", "face"), arrayOf("smoky_makeup", "face")))
}