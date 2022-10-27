package 백준.약수의합

val MAX = 10
val br = System.`in`.bufferedReader()
//1<=n<=1000000
val g = LongArray(MAX){1}

// 각 숫자의 약수의 합을 담아준다
// 즉 f[n]을 완성
fun solveF(){
    for(i in 2 until MAX){
        for(j in i until MAX step i){
            g[j]+=i.toLong()
        }
    }
}

// 지금까지 숫자의 약수의 합을 구해준다
// 즉 g[n]을 완성
fun solveG(){
    for(i in 2 until MAX){
        g[i] += g[i-1]
    }
}

fun main() = with(System.out.bufferedWriter()){
    val t = br.readLine().toInt()
    solveF()
    println(g.contentToString())
    solveG()
    repeat(t){
        write("${g[br.readLine().toInt()]}\n")
    }
    close()
}