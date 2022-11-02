package 백준.리모컨

import java.util.Scanner

val broken = BooleanArray(10) { false } // 숫자 버튼 i가 고장났으면 true 를 넣는다.

// 이동할 수 있는지 여부 확인
// 채널 c 로 이동이 가능하면 c 의 숫자 개수를 return
// 불가능하면 0을 리턴
fun possible(c: Int): Int {
    var cTemp = c
    if (cTemp == 0) {
        return if (broken[0]) 0
        else 1
    }
    var len = 0
    while (cTemp > 0) {
        if (broken[cTemp % 10]) return 0
        len += 1
        cTemp /= 10
    }
    return len
}

fun main()  {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    for (i in 0 until m) {
        val x = sc.nextInt()
        broken[x] = true  // 고장난 버튼 저장
    }

    // 정답의 초기값 : 숫자 버튼을 안누름 (+ - 버튼으로만 이동하는 것이 최솟값인 경우)
    var ans = n - 100
    if (ans < 0) ans = -ans

    for (i in 0..1000000) {
        // 이동할 수 있는지 여부 확인
        // 이동할 수 있으면 버튼을 몇번 누르는 return
        val len = possible(i)
        if (len > 0) { // 이동이 가능한 경우
            var press = i - n
            if (press < 0) press = -press
            if (ans > len + press) ans = len + press
        }
    }
    println(ans)
}