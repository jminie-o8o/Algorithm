package 프로그래머스.배스트앨범

fun solution(genres: Array<String>, plays: IntArray): IntArray {
    val indexHash = genres.indices.groupBy { genres[it] } // 인덱스를 value 로 해서 해시 만들기
    val indexHashToList = indexHash.toList() // Returns a List containing all key-value pairs. 즉 키 벨류 Pair 를 가지고 있는 리스트 반환
    val pairListByDescending = indexHashToList.sortedByDescending { pair -> // Pair 리스트 중 play 의 합이 큰 순서대로 정렬
        pair.second.sumOf { index ->
            plays[index]
        }
    }
    val temp = pairListByDescending.map { pair ->  // 정렬된 Pair 리스트 중 play 가 큰 순서대로 정렬
        pair.second.sortedByDescending { index ->
            plays[index]
        }.take(2)
    }
    println(indexHash)
    println(indexHashToList)
    println(pairListByDescending)
    println(temp)
    println(temp.flatten())
    return plays
}

fun main() {
    println(
        solution(
            arrayOf("classic", "pop", "classic", "classic", "pop"),
            intArrayOf(500, 600, 150, 800, 2500)
        ).contentToString()
    )
}
