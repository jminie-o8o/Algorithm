package 프로그래머스.`문자열 압축`

import kotlin.math.min

fun solution(s: String): Int {
    var answer = s.length
    for (i in IntRange(1, s.length / 2)) {
        var pos = 0
        var len = s.length

        while (pos + i <= s.length) {
            val unit = s.substring(pos, pos + i)
            pos += i
            var cnt = 0
            while (pos + i <= s.length) {
                if (unit == s.substring(pos, pos + i)) {
                    cnt += 1
                    pos += i
                } else break
            }
            if (cnt > 0) {
                len -= i * cnt
                len += if (cnt < 9) 1
                else if (cnt < 99) 2
                else if (cnt < 999) 3
                else 4
            }
        }
        answer = min(answer, len)
    }
    return answer
}

fun main() {
    println(solution("aabbaccc"))
}