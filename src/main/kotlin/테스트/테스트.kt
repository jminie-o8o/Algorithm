package 테스트

open class Parent {
    private val a: Int = 10 // private 필드
    val b: Int = 20  // public 필드
}

class Child: Parent() {

    val c: Int = 30  // public 필드

    fun display() {
//        println(a) -> a가 private 이기 때문에 불가능
        println(b) // 상속받은 public 변수 참조
        println(c)
    }
}

fun main() {
    val child = Child()
    child.display()
}

