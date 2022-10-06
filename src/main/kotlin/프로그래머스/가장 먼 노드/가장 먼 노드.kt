package 프로그래머스.`가장 먼 노드`

import java.util.*

data class Node(val index: Int, val distance: Int) : Comparable<Node> {

    override fun compareTo(other: Node): Int {
        return distance.compareTo(other.distance)
    }
}

fun solution(n: Int, edge: Array<IntArray>): Int {
    val node = IntArray(n + 1) { 100000 }.apply { this[1] = 0 }
    val pq = PriorityQueue<Node>().apply { offer(Node(1, 0)) }

    while (pq.isNotEmpty()) {
        val now = pq.poll()
        if (now.distance > node[now.index]) continue

        for (i in edge.indices) {
            if (edge[i][0] == now.index) {
                val cost = now.distance + 1
                val idx = edge[i][1]
                if (cost < node[idx]) {
                    node[idx] = cost
                    pq.offer(Node(idx, cost))
                }
            } else if (edge[i][1] == now.index) {
                val cost = now.distance + 1
                val idx = edge[i][0]
                if (cost < node[idx]) {
                    node[idx] = cost
                    pq.offer(Node(idx, cost))
                }
            }
        }
    }
    val nodeResult = node.toMutableList()
    nodeResult.removeAt(0)
    val max = nodeResult.maxOrNull()
    return nodeResult.count { it == max }
}

fun main() {
    solution(
        6,
        arrayOf(
            intArrayOf(3, 6),
            intArrayOf(4, 3),
            intArrayOf(3, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 2),
            intArrayOf(2, 4),
            intArrayOf(5, 2)
        )
    )
}