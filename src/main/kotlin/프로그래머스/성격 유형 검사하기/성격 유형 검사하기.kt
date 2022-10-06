package 프로그래머스.`성격 유형 검사하기`

import kotlin.math.min

//fun solution(survey: Array<String>, choices: IntArray): String {
//    val type1 = mutableMapOf<String, Int>().apply {
//        this["R"] = 0
//        this["T"] = 0
//    }
//    val type2 = mutableMapOf<String, Int>().apply {
//        this["C"] = 0
//        this["F"] = 0
//    }
//    val type3 = mutableMapOf<String, Int>().apply {
//        this["J"] = 0
//        this["M"] = 0
//    }
//    val type4 = mutableMapOf<String, Int>().apply {
//        this["A"] = 0
//        this["N"] = 0
//    }
//    for (i in survey.indices) {
//        if (survey[i].startsWith("R")) {
//            if (choices[i] == 1) type1["R"] = type1["R"]?.plus(3)!!
//            else if (choices[i] == 2) type1["R"] = type1["R"]?.plus(2)!!
//            else if (choices[i] == 3) type1["R"] = type1["R"]?.plus(1)!!
//            else if (choices[i] == 4) continue
//            else if (choices[i] == 5) type1["T"] = type1["T"]?.plus(1)!!
//            else if (choices[i] == 6) type1["T"] = type1["T"]?.plus(2)!!
//            else if (choices[i] == 7) type1["T"] = type1["T"]?.plus(3)!!
//        }
//        else if (survey[i].startsWith("T")) {
//            if (choices[i] == 1) type1["T"] = type1["T"]?.plus(3)!!
//            else if (choices[i] == 2) type1["T"] = type1["T"]?.plus(2)!!
//            else if (choices[i] == 3) type1["T"] = type1["T"]?.plus(1)!!
//            else if (choices[i] == 4) continue
//            else if (choices[i] == 5) type1["R"] = type1["R"]?.plus(1)!!
//            else if (choices[i] == 6) type1["R"] = type1["R"]?.plus(2)!!
//            else if (choices[i] == 7) type1["R"] = type1["R"]?.plus(3)!!
//        }
//        if (survey[i].startsWith("C")) {
//            if (choices[i] == 1) type2["C"] = type2["C"]?.plus(3)!!
//            else if (choices[i] == 2) type2["C"] = type2["C"]?.plus(2)!!
//            else if (choices[i] == 3) type2["C"] = type2["C"]?.plus(1)!!
//            else if (choices[i] == 4) continue
//            else if (choices[i] == 5) type2["F"] = type2["F"]?.plus(1)!!
//            else if (choices[i] == 6) type2["F"] = type2["F"]?.plus(2)!!
//            else if (choices[i] == 7) type2["F"] = type2["F"]?.plus(3)!!
//        }
//        if (survey[i].startsWith("F")) {
//            if (choices[i] == 1) type2["F"] = type2["F"]?.plus(3)!!
//            else if (choices[i] == 2) type2["F"] = type1["F"]?.plus(2)!!
//            else if (choices[i] == 3) type2["F"] = type2["F"]?.plus(1)!!
//            else if (choices[i] == 4) continue
//            else if (choices[i] == 5) type2["C"] = type2["C"]?.plus(1)!!
//            else if (choices[i] == 6) type2["C"] = type2["C"]?.plus(2)!!
//            else if (choices[i] == 7) type2["C"] = type2["C"]?.plus(3)!!
//        }
//        if (survey[i].startsWith("J")) {
//            if (choices[i] == 1) type3["J"] = type3["J"]?.plus(3)!!
//            else if (choices[i] == 2) type3["J"] = type3["J"]?.plus(2)!!
//            else if (choices[i] == 3) type3["J"] = type3["J"]?.plus(1)!!
//            else if (choices[i] == 4) continue
//            else if (choices[i] == 5) type3["M"] = type3["M"]?.plus(1)!!
//            else if (choices[i] == 6) type3["M"] = type3["M"]?.plus(2)!!
//            else if (choices[i] == 7) type3["M"] = type3["M"]?.plus(3)!!
//        }
//        if (survey[i].startsWith("M")) {
//            if (choices[i] == 1) type3["M"] = type3["M"]?.plus(3)!!
//            else if (choices[i] == 2) type3["M"] = type3["M"]?.plus(2)!!
//            else if (choices[i] == 3) type3["M"] = type3["M"]?.plus(1)!!
//            else if (choices[i] == 4) continue
//            else if (choices[i] == 5) type3["J"] = type3["J"]?.plus(1)!!
//            else if (choices[i] == 6) type3["J"] = type3["J"]?.plus(2)!!
//            else if (choices[i] == 7) type3["J"] = type3["J"]?.plus(3)!!
//        }
//        if (survey[i].startsWith("A")) {
//            if (choices[i] == 1) type4["A"] = type4["A"]?.plus(3)!!
//            else if (choices[i] == 2) type4["A"] = type4["A"]?.plus(2)!!
//            else if (choices[i] == 3) type4["A"] = type4["A"]?.plus(1)!!
//            else if (choices[i] == 4) continue
//            else if (choices[i] == 5) type4["N"] = type4["N"]?.plus(1)!!
//            else if (choices[i] == 6) type4["N"] = type4["N"]?.plus(2)!!
//            else if (choices[i] == 7) type4["N"] = type4["N"]?.plus(3)!!
//        }
//        if (survey[i].startsWith("N")) {
//            if (choices[i] == 1) type4["N"] = type4["N"]?.plus(3)!!
//            else if (choices[i] == 2) type4["N"] = type4["N"]?.plus(2)!!
//            else if (choices[i] == 3) type4["N"] = type4["N"]?.plus(1)!!
//            else if (choices[i] == 4) continue
//            else if (choices[i] == 5) type4["A"] = type4["A"]?.plus(1)!!
//            else if (choices[i] == 6) type4["A"] = type4["A"]?.plus(2)!!
//            else if (choices[i] == 7) type4["A"] = type4["A"]?.plus(3)!!
//        }
//    }
//    val result = mutableListOf<String>()
//    result.add(type1.toList().sortedByDescending { it.second }.first().first)
//    result.add(type2.toList().sortedByDescending { it.second }.first().first)
//    result.add(type3.toList().sortedByDescending { it.second }.first().first)
//    result.add(type4.toList().sortedByDescending { it.second }.first().first)
//    return result.joinToString("")
//}

fun solution(survey: Array<String>, choices: IntArray): String {
    var answer: String = ""
    val hashMap = HashMap<Char, Int>()

    hashMap['R'] = 0
    hashMap['T'] = 0
    hashMap['C'] = 0
    hashMap['F'] = 0
    hashMap['J'] = 0
    hashMap['M'] = 0
    hashMap['A'] = 0
    hashMap['N'] = 0
    val scoreArr = arrayOf(3, 2, 1, 0, 1, 2, 3)

    for (i in choices.indices) {
        //i 가 4보다 크면 두번째 인덱스
        //아니면 첫번째 인덱스
        //0이면 사전빠른순(아스키코드비교)
        var key: Char
        val score = scoreArr[choices[i] - 1]
        key = when {
            score == 0 -> {
                Char(min(survey[i][0].code, survey[i][1].code))
            }
            choices[i] - 1 < 4 -> {
                survey[i][0]
            }
            else -> {
                survey[i][1]
            }
        }
        hashMap[key] = hashMap.getOrDefault(key, hashMap[key] ?: 0) + score
    }
    println(hashMap)
    val mbti = arrayOf("RT","CF","JM","AN")
    for (s in mbti) {
        var first = s[0]
        var second = s[1]

        val firstValue = hashMap[first]!!
        val secondValue = hashMap[second]!!

        answer += when {
            firstValue == secondValue -> {
                Char(min(first.code, second.code))
            }
            firstValue > secondValue -> {
                first
            }
            else -> {
                second
            }
        }
    }
    return answer
}

fun main() {
    solution(arrayOf("AN", "CF", "MJ", "RT", "NA"), arrayOf(5, 3, 2, 7, 5).toIntArray())
    solution(arrayOf("TR", "RT", "TR"), arrayOf(7, 1, 3).toIntArray())
}