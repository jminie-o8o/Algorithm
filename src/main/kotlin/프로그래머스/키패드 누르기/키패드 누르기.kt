package 프로그래머스.`키패드 누르기`

import kotlin.math.absoluteValue

data class Numpad(val x: Int, val y: Int)

fun solution(numbers: IntArray, hand: String): String {
    val phone = arrayOf(
        Numpad(1, 3), // 0
        Numpad(0, 0), // 1
        Numpad(1, 0), // 2
        Numpad(2, 0), // 3
        Numpad(0, 1), // 4
        Numpad(1, 1), // 5
        Numpad(2, 1), // 6
        Numpad(0, 2), // 7
        Numpad(1, 2), // 8
        Numpad(2, 2)  // 9
    )
    var leftHand = Numpad(0, 3)
    var rightHand = Numpad(2, 3)
    val sb = StringBuilder()
    numbers.forEach { number ->
        if (number == 1 || number == 4 || number == 7) {
            sb.append("L")
            leftHand = phone[number]
        } else if (number == 3 || number == 6 || number == 9){
            sb.append("R")
            rightHand = phone[number]
        } else {
            val left = (phone[number].x - leftHand.x).absoluteValue + (phone[number].y - leftHand.y).absoluteValue
            val right = (phone[number].x - rightHand.x).absoluteValue + (phone[number].y - rightHand.y).absoluteValue
            if (left > right) {
                sb.append("R")
                rightHand = phone[number]
            }
            else if (left < right) {
                sb.append("L")
                leftHand = phone[number]
            }
            else {
                if (hand == "right") {
                    sb.append("R")
                    rightHand = phone[number]
                }
                else if (hand == "left") {
                    sb.append("L")
                    leftHand = phone[number]
                }
            }
        }
    }
    return sb.toString()
}

fun main() {
    solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right")
}