package 프로그래머스.`디스크 컨트롤러`

import java.util.*

data class Job(
    val start: Int,
    val during: Int
)

fun solution(jobs: Array<IntArray>): Int {
    var answer = 0
    var time = 0
    val waitingQueue = PriorityQueue<Job>(compareBy { it.start })

    for (i in jobs.indices) {
        val job = Job(jobs[i][0], jobs[i][1])
        waitingQueue.add(job)
    }

    while (waitingQueue.isNotEmpty()) {
        val readyQueue = PriorityQueue<Job>(compareBy { it.during })
        while (waitingQueue.isNotEmpty() && time >= waitingQueue.peek().start) {
            readyQueue.add(waitingQueue.poll())
        }
        // 앞에 작업이 진행될 동안 readyQueue 에 아무것도 존재하지 않는다면 time 을 1 더해준다.
        if(readyQueue.isEmpty()){
            time += 1
            continue
        }
        time += readyQueue.peek().during
        answer += time - readyQueue.peek().start
        readyQueue.poll()

        for(i in readyQueue.indices){
            waitingQueue.offer(readyQueue.poll())
        }
    }
    answer /= jobs.size

    return answer
}

fun main() {
    println(solution(arrayOf(intArrayOf(1, 9), intArrayOf(2, 6), intArrayOf(0, 3))))
}