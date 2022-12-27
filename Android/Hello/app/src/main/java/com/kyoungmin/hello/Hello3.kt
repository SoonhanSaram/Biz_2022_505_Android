package com.kyoungmin.hello

/**
 * 정수형 변수 타입
 */
var intNum1 : Int = 1000; //32bit; 2의 32승 , -2의 31승 ~2의 31승 -1
var intNum2 : Number = 1000;// = Int, Float 통합형
var longNum2 : Long = 0L // 64bit; 2의 62tmd, -2의 63승 ~ 2의 63승
var shortNum1 : Short = 0; //16bit
var byteNum1 : Byte = 0; //8bit

var floatNum1 : Float = 123.5555F; //32bit, 소수점이하 6자리
var doubleNum1 : Double = 123.555; // 64bit, 소수점이하 14자리

fun add():Float {
    return 123.555F + 123.333F
}

fun main() {
    /**
     * 변수 타입이 다른 상태에서 서로 값을 할당하는
     * 경우엔 주의 요망
     * 특히 숫자일 경우 값을 잃거나 오차가가 발생 할 수 있음
     */
    floatNum1 = intNum1.toFloat();
    intNum1 = doubleNum1.toInt();

    println(floatNum1)
    println(intNum1)

    /**
     * add() 함수는 float + float 형 데이터를 return하고 있음
     * add() 함수가 return 하는 값을 변수에 받으려면
     * 받는 변수의 타입도 Float형이어야 함
     */
    var ret:Float = add()
    println(ret)

    intNum1 = 1_000_000_000
    longNum2 = 1_000_000_000_000_000L

    var hexaByte = 0xFF_77_BB // 16진수 표현
    var binByte = 0b0001_1100_0111 // 2진수 표현

    println(hexaByte)
    println(binByte)
}