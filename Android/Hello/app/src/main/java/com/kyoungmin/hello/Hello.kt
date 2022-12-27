package com.kyoungmin.hello

/**
* 변수를 선언하는 키워드
 * var : 언제든지 값을 변경할 수 있는 일반적임 함수
 *      JS에서 let키워드와 같음
 * val : 한 번 할당된 변수는 값을 제 할당 할 수 없다.
 *      JS에서 const 키워드와 같음
 * 
 * Kotlin에서 변수를 선언할 때 초기값을 지정해야 함
 *      변수 초기값은 함수 밖에서 선언가능하나
 *      변경 코드는 함수 안에서 재할당 해야함
* */

var num1:Int = 0;
var num2:Int = 0;
var sum:Int = num1+num2;
/**
 * Kotlin 언어는 태생이 자바
 * Java의 불편한 점을 개선하기 위해 탄생된 언어
 * 개선을 하긴 했으나 Java의 성질을 가지고 있음
 * Kotlin 함수에서 return문을 사용할 경우 
 * 함수에 반드시 타입이 따라온다
 * */
fun numAdd() : Int {
    return num1 + num2
}
/**
 * printSum() 함수를 호출하면
 * num1과 num2 값을 덧셈하여
 * 결과를 console 출력하고 함수를 종료
 * 이 때는 return typel을 사용하지 않아도 됨
 */
fun printSum() {
    print(num1 + num2)
}

/**
* 진입점, 시작점 함수
 * */
fun main() {
    num1 = 100;
    num2 = 200;
    sum = num1+ num2
    print(sum)

    /**
     * numAdd() 함수가 return한 결과를 받아서
     * sum 변수에 할당
     */
    sum = numAdd()
    print(sum)
}