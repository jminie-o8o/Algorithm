package 백준.`최대공약수와 최소공배수`

fun gcd(a: Int, b: Int): Int {
    // 탈출조건
    return if (b == 0) a
    else gcd(b, a % b)
}

fun lcm(a: Int, b: Int): Int {
    return gcd(a, b) * (a / gcd(a, b) * (b / gcd(a, b)))
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    println(gcd(n, m))
    println(lcm(n, m))
}