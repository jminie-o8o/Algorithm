package 백준.에디터

import java.util.LinkedList

// LinkedList 를 알고있니? 물어보는 문제
fun main() = with(System.`in`.bufferedReader()) {
    val stringList = readLine()!!.map { it.toString() }.toMutableList()
    val linkedList: LinkedList<String> = LinkedList()
    for (s in stringList) {
        linkedList.add(s)
    }
    // cursor 를 linkedList.listIterator() 로 대체
    val iterator = linkedList.listIterator(stringList.size)
    val n = readLine()!!.toInt()
    repeat(n) {
        val command = readLine()!!.map { it.toString() }.toMutableList()
        command.remove(" ")
        when (command[0]) {
            "L" -> {
                if (iterator.hasPrevious()) {
                    iterator.previous()
                }
            }
            "D" -> {
                if (iterator.hasNext()) {
                    iterator.next()
                }
            }
            "B" -> {
                if (iterator.hasPrevious()) {
                    // 커서를 한칸 앞으로 간 다음에
                    iterator.previous()
                    // 커서 다음 문자를 지운다
                    iterator.remove()
                }
            }
            "P" -> {
                iterator.add(command[1])
            }
        }
    }
    println(linkedList.joinToString(""))
}