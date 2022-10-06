package 프로그래머스.프린터

fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    val truckWeight = truck_weights.toMutableList() // 대기중인 트럭 큐
    val bridge = List(bridge_length){0}.toMutableList() // 다리 큐
    var weightOnBridge = 0 // 현재 다리 위의 트럭 총 무게
    var totalTime = 0 // 시간
    while (bridge.isNotEmpty()) {
        totalTime ++
        weightOnBridge -= bridge.first()
        bridge.removeFirst()
        if (truckWeight.isNotEmpty()) {
            if (weightOnBridge + truckWeight.first() <= weight) {
                weightOnBridge += truckWeight.first()
                bridge.add(truckWeight.removeFirst())
            } else {
                bridge.add(0)
            }
        }
    }
    return totalTime
}

fun main() {
    println(solution(100, 100, intArrayOf(10)))
}