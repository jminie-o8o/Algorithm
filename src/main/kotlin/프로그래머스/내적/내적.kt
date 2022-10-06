package 프로그래머스.내적

fun solution(a: IntArray, b: IntArray): Int {
    return a.zip(b) {a, b -> a * b}.sum()
}