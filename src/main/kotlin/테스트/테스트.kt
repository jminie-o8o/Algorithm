package 테스트

class Person(private val name: String)
class Person2(private var name: String)

fun main() {
    val person = Person("stark")
    val person2 = Person("jay")
}

