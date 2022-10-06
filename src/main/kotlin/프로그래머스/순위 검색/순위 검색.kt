package 프로그래머스.`순위 검색`

fun solution(info: Array<String>, query: Array<String>): IntArray {
    // 1. info 를 기반으로 HashMap 을 만든다.
    var map = mutableMapOf<String, MutableList<Int>>()
    info.forEach {
        val data = it.split(" ")
        val language = arrayOf(data[0], "-")
        val jobs = arrayOf(data[1], "-")
        val exps = arrayOf(data[2], "-")
        val foods = arrayOf(data[3], "-")
        val value = data[4].toInt()
        for (lang in language) {
            for (job in jobs) {
                for (exp in exps) {
                    for (food in foods) {
                        val keyData = arrayOf(lang, job, exp, food)
                        val key = keyData.joinToString(" ")
                        val arr = map.getOrDefault(key, mutableListOf()) // key 가 있다면 Value 반환, 없다면 빈 리스트 반환

                        arr.add(value)
                        map[key] = arr
                    }
                }
            }
        }
    }
    // 2. HashMap 의 Value 를 오름차순으로 정렬한다.
    map.values.map { it.sort() }

    // 3. query 조건에 맞는 지원자를 가져온다.
    val answer = mutableListOf<Int>()
    for (q in query) {
        val data = q.split(" and ", " ").toMutableList()
        val target = data.removeLast().toInt()
        val key = data.joinToString(" ")

        if (map.containsKey(key)) {
            val list = map[key]
            // 4. 이분탐색을 통해 lower-bound 를 찾는다.
            var left = 0
            var right = list!!.size
            while (left < right) {
                var mid = (left + right) / 2
                if (list[mid] >= target) {
                    right = mid
                } else {
                    left = mid + 1
                }
            }
            answer.add(list.size - left)
        } else {
            answer.add(0)
        }
    }
    println(answer)
    return answer.toIntArray()
}

fun main() {
    solution(
        arrayOf(
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
        ),
        arrayOf(
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
        )
    )
}