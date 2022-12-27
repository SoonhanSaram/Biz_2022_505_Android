package com.kyoungmin.hello

fun main() {
    var num1 = 100;
    var num2 = 200;
    val sum = num1 + num2

    println(sum)

    /**
     * 문자열 template
     * 문자열 literal 연산식
     * 문자열에 변수, 연산식을 포함해
     * 한 번에 표시
     */
    println("$num1 + $num2 = ${num1 + num2}")
    
    // 두 문자열 변수에 담긴 데이터 연결해 출력
    // 문자열 변수의 타입은 String
    var nation = "대한민국"
    var engNation = "Republic of Korea"
    println(nation + engNation)

    /**
     * null safe
     * 변수에 null 값을 허용하는 코드
     * Kotlin은 null safe를 지향하는 언어
     * 코드가 실행되는 과정에서 null point Exception
     * 발생하지 않도록 설계되고 코딩하는 언어
     * 초기엔 모든 변수에 null 값을 저장할 수 없었음
     * 제한적으로 null 을 저장할 수 있도록 변경
     */
    var nullString : String? = null
    nullString = "우리나라만세"

    print(nullString)
}

/** 
 * 변수 타입과 함수의 return 타입
 * 개발자 입장에서 변수의 타입과 함수의 return 타입은
 * 지켜야하는 규칙이 불편할 수있음
 * 
 * 초창기에는 메모리관리 문제로 타입을 사용
 * 현대에는 코드가 실행되는 과정에서
 * 타입때문에 발생하는 오차, 오류를 방지하는 역할
 * 
 * 변수 타입이 없는 언어로 코딩을 하는 과정에서 
 * 데이터 연산오류가 발생
 * 타입이 있는 언어는 실행되기 전에 컴파일단계에서
 * 오류를 보여주고 코드는 정정하도록 함
 */