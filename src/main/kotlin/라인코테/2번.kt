package 라인코테

fun solution(k: Int, dic: Array<String>, chat: String): String {
    val chatList = chat.split(" ")
    val answerList = mutableListOf<String>()
    for (c in chatList) {
        
    }
    println(answerList)
    var answer: String = ""
    return answer
}

private operator fun Char.times(i: Int): String {
    val temp = 0
    var tempChar = this
    while (temp != i) {
        tempChar += this.toInt()
    }
    return tempChar.toString()
}

fun main() {
    var char = 'C'
    println(char + char.toInt())
}

