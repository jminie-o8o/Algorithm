package 백준.`전화번호 목록`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    val result = mutableListOf<Boolean>()
    for (i in 0 until n) {
        val m = readLine()!!.toInt()
        val tempList = mutableListOf<String>()
        for (j in 0 until m) {
            tempList.add(readLine()!!)
        }
        result.add(check(tempList.sorted().toMutableList()))
    }
    for (i in result) {
        if (i) println("YES")
        else println("NO")
    }
}

fun check(list: MutableList<String>): Boolean {
    // 현재 배열은 오름차순 정렬이 되어있는 상태
    // 만약 전화 번호 목록 안에 접두어 관계가 있는 문자열이 있다면,
    // 특정 문자열 바로 뒤에 접두어 관계가 있는 문자열이 있을 것이다.
    // 결과적으로, 전화번호 목록이 일관성이 있는지 검사하려면
    // 특정 문자열과 그 다음 문자열의 접두어 관계만 확인하면 된다.
    // 따라서 조건문을 두 번도는 O(N^2) 으로 풀지 않아도 된다
    for (i in 0 until list.size - 1) {
        if (list[i + 1].startsWith(list[i])) return false
    }
    return true
}