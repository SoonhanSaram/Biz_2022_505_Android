package com.kyoungmin.hello

fun main() {
    var num1 = 20;
    var num2 = 100;
    var max1 = num2;
    if(max1 > num2 ) max1 = num2
    println("$max1 이 $num2 보다 큼 ${max1 > num2}")

//    값이 정해지지 않았을 때 할당하는 법
    var max2:Int
    if (num1 >num2) {
        max2 = num1
    } else {
        max2 = num2
    }
//     max2 = num1 > num2 ? num1 : num2
//    Kotlin의 3항 연산자
    max2 = if (num1>num2) num1 else num2

    max2 = if (num1>num2) {
        println("num1> num2")
        num1 // return num1
    } else {
        println("num2>num1")
        num2 // return num2와 같은 코드
    }
//    Math.random() 은 0부터 1미만의 난수 발생
//    * 100 시 0부터 ~ 99까지 난수 생성
//    + 1 시 1부터 100까지 난수 생성
    val rndNum = (Math.random() * 100).toInt() +1
    when (rndNum) {
        10 -> println("난수는 10")
        in 11  ..  20 -> println("난수는 11부터 20중의 수")
        else -> println("범위에 없는 숫자")
    }
    when(rndNum % 2) {
        0 -> println("$rndNum 는 짝수")
        else -> println("$rndNum 는 홀수")
    }
    /**
     * when 조건에 맞는 결과값을 찾고
     * 변수에 할당하기
     */
    val ret = when(rndNum % 3 ) {
        0 -> "3의 배수"
        1 -> "3의 배수 아님"
        else -> "알 수 없음"
    }
    println("결과 : $ret")
    //1부터 10까지 숫자가 담긴 배열 생성
    val intArray = intArrayOf(1,2,3,4,5,6,7,8,9,10)
    // 배열요소 중에서 임의의 값을 하나 추출해
    // intRnd에 담기
    val intRnd = intArray.random()
    when(intRnd) {
        in intArray -> println("$intRnd 는 intArray배열요소")
        in 1..10 -> println("$intRnd 는 1~10 중 하나")
        in 20..30 -> println("$intRnd 는 20~30 중 하나")
        else -> println("알 수 없음")
    }

    val strNation = "Republic of Korea"
    val yesNo = when(strNation) {
        is String -> strNation.endsWith("Korea")
        is String -> strNation.startsWith("Korea")
        else -> false
    }
    println("${strNation} 에는 Korea 문자열이 포함${if(yesNo)"되어 있음" else "포함되어 있지 않음"} ")

    var strName = "홍길동"
    when {
        strName =="이몽룡" -> println("이름은 이몽룡")
        strName =="홍길동" -> println("이름은 홍길동")
        else -> println("Not Found")
    }
}