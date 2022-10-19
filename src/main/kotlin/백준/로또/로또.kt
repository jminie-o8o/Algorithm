package 백준.로또

import java.util.Scanner

var n = 0
var arr: IntArray = intArrayOf()
var visited: BooleanArray = booleanArrayOf()

fun main()  {

    val sc = Scanner(System.`in`)

    while (true) {
        n = sc.nextInt()
        if (n == 0) break
        arr = IntArray(n)
        visited = BooleanArray(n)
        for (i in 0 until n) { arr[i] = sc.nextInt() }

        dfs(0 , 0)
        println()
    }
}

fun dfs(depth: Int, start: Int) {
    // 탈출조건
    if (depth == 6) {
        printLotto()
        return
    }

    // 수행조건
    for (i in start until n) {
        visited[i] = true
        dfs(depth + 1, i + 1)
        visited[i] = false
    }
}


fun printLotto() {
    for (i in 0 until n) {
        if (visited[i]) {
            print("${arr[i]} ")
        }
    }
    println()
}