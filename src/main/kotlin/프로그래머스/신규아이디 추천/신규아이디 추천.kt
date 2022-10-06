package 프로그래머스.`신규아이디 추천`

fun solution(new_id: String): String {
    return new_id
        .stageOne()
        .stageTwo()
        .stageThree()
        .stageFour()
        .stageFive()
        .stageSix()
        .stageSeven()
}

fun String.stageOne() = this.lowercase()

fun String.stageTwo() = Regex("[^A-Za-z0-9._-]").replace(this, "")

fun String.stageThree() = this.replace(Regex("[.]+"), ".")

fun String.stageFour() = this.filterIndexed { index, c ->
    (index != 0 || c != '.') && (index != this.lastIndex || c != '.')
}

fun String.stageFive() = if (this == "") this + "a" else this

fun String.stageSix() = if (this.length >= 16) this.substring(0..14).filterIndexed { index, c ->
    !(index == 14 && c == '.')
} else this

fun String.stageSeven() = if (this.length <= 2) this + this.last().toString().repeat(3 - this.length) else this

fun main() {
    println(solution("...!@BaT#*..y.abcdefghijklm"))
    println(solution("z-+.^."))
    println(solution("=.="))
    println(solution("abcdefghijklmn.p"))
}