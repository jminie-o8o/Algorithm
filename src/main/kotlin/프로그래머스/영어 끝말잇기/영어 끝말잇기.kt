package 프로그래머스.`영어 끝말잇기`

fun solution(n: Int, words: Array<String>): IntArray {
    val answer = mutableListOf<Int>()
    val wordList = mutableListOf<String>()
    var prev = ""
    for (i in words.indices) {
        if (i == 0) {
            prev = words[0]
            wordList.add(prev)
            continue
        }
        val now = words[i]
        if (now.first() != prev.last()) {
            val people = (i % n) + 1
            val turn = (i / n) + 1
            answer.add(people)
            answer.add(turn)
            return answer.toIntArray()
        } else if (wordList.contains(now)) {
            val people = (i % n) + 1
            val turn = (i / n) + 1
            answer.add(people)
            answer.add(turn)
            return answer.toIntArray()
        }
        wordList.add(now)
        prev = now
    }
    return intArrayOf(0, 0)
}

fun main() {
    println(solution(3, arrayOf("tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank")).contentToString())
    println(solution(5, arrayOf("hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive")).contentToString())
    println(solution(2, arrayOf("hello", "one", "even", "never", "now", "world", "draw")).contentToString())
}