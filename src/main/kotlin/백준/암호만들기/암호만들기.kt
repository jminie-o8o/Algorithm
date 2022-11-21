package 백준.암호만들기

// 1. 암호의 길이는 L
// 2. 암호에는 최소 한개의 모음
// 3. 암호에는 최소 두개의 자음
// 4. 암호는 알파벳이 증가하는 순서이다.
// 5. 암호로 사용할 수 있는 문자는 C 가지 이다.

fun main() = with(System.`in`.bufferedReader()) {
    val (L, C) = readLine()!!.split(" ").map { it.toInt() }
    val temp = readLine()!!.split(" ")
    val arr = temp.sorted()
    go(L, arr, "", 0)
}

// n : 만들어야 하는 암호의 길이
// alpha : 사용할 수 있는 알파벳
// password : 현재까지 만든 암호
// index : 사용할지 말지 결정해야 하는 알파벳의 인덱스
fun go(n: Int, alpha: List<String>, password: String, index: Int) {
    // 정답을 찾은 경우
    if (password.length == n) {
        // check 함수는 최소 한개의 모음과 최소 두개의 자음을 검사
        if (check(password)) {
            println(password)
        }
        return
    }
    // 불가능한 경우 (더 이상 선택할 수 있는 알파벳이 없으면 재귀함수 호출 불가능)
    // 이 부분이 없으면 인덱스에러 발생
    if (index >= alpha.size) return
    go(n, alpha, password + alpha[index], index + 1) // i 번째 알파벳을 사용하는 경우
    go(n, alpha, password, index + 1) // i 번째 알파벳을 사용하지 않는 경우
}

fun check(password: String): Boolean {
    var ja = 0
    var mo = 0
    for (x in password) {
        if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
            mo += 1
        } else {
            ja += 1
        }
    }
    return  mo >= 1 && ja >= 2
}
