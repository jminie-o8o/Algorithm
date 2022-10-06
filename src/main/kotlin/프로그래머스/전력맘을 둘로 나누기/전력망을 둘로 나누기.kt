package 프로그래머스.`전력맘을 둘로 나누기`

import kotlin.math.abs

var graphs: Array<IntArray> = arrayOf()
var count = 0
fun solution(n: Int, wires: Array<IntArray>): Int {
    var answer: Int = 1000
    var idx = 0
    graphs = Array(n + 1) { IntArray(n + 1) }
    while (idx != n) {
        graphs = Array(n + 1) { IntArray(n + 1) }
        for (i in wires.indices) {
            if (idx != i) {
                graphs[wires[i][0]][wires[i][1]] = 1
                graphs[wires[i][1]][wires[i][0]] = 1
            }
        }
        count = 0
        dfs(1, -1)
        var temp = abs(n - (count * 2))
        answer = temp.coerceAtMost(answer)
        idx += 1
    }
    return answer
}

fun dfs(v: Int, except: Int) {
    count++
    for (i in graphs[v].indices) {
        if (i != except && graphs[v][i] == 1) {
            dfs(i, v)
        }
    }
}

fun main() {
//    println(solution(
//        9, arrayOf(
//            intArrayOf(1, 3),
//            intArrayOf(2, 3),
//            intArrayOf(3, 4),
//            intArrayOf(4, 5),
//            intArrayOf(4, 6),
//            intArrayOf(4, 7),
//            intArrayOf(7, 8),
//            intArrayOf(7, 9)
//        )
//    ))
    solution(4, arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4)))
}