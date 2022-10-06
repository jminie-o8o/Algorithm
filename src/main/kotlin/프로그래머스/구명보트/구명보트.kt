package 프로그래머스.구명보트

fun solution(people: Array<Int>, limit: Int): Int {
    var answer = 0
    val peopleQueue = people.sorted().toMutableList()
    while (peopleQueue.isNotEmpty()) {
        if (peopleQueue.size == 1) {
            answer += 1
            break
        }
        if (peopleQueue.first() + peopleQueue.last() <= limit) {
            peopleQueue.removeFirst()
            peopleQueue.removeLast()
        } else {
            peopleQueue.removeLast()
        }
        answer += 1
    }
    return answer
}