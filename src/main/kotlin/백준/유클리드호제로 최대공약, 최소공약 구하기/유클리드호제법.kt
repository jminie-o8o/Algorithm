package 백준.`유클리드호제로 최대공약, 최소공약 구하기`

fun gcd(a: Int, b: Int): Int {
    // 탈출조건
    return if (b == 0) a
    else gcd(b, a % b)
}

fun lcm(a: Int, b: Int): Int {
    return gcd(a, b) * (a / gcd(a, b) * (b / gcd(a, b)))
}

fun main() {
    // 최대공약수
    println(gcd(20, 12))
    // 최소공배수
    println(lcm(20, 12))
}