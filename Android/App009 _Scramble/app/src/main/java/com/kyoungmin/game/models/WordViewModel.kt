package com.kyoungmin.game.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kyoungmin.game.data.allWordsList
import java.io.File.separator

/**
 * class를 만들 때 명명규칙
 * 첫 글자는 영문대문자
 * 두번째부터는 영문 대소문자, 숫자, _ 등 사용가능
 * 가급적 2단어 이상을 조합해 명명
 * Under Bar(_) 를 사용하기 보단
 * CamelCase 형식으로 명명
 * 
 * ---ViewModel 클래스는 lifecycle의 ViewModel 클래스를
 * 상속받아서 작성
 */

class WordViewModel : ViewModel() {
    var currentWord = MutableLiveData("")
    var unscrambleWord = MutableLiveData("")
    var inputWord = MutableLiveData("")

    /**
     * 게임을 하는 과정에서 맞춘 점수
     * 시행한 게임 수 등을 저장할 변수
     * 
     * 정답을 맞추면 gameScroe 를 1 증가
     * 게임 카운트도 1 증가
     * 
     * gameScore 가 10이 되면 "축하합니다" 라는 메시지를 출력
     */
    var gameScore = MutableLiveData(0)
    var gameCount = MutableLiveData(0)
    var gameMsg = MutableLiveData("")
    /**
     * Kotlin 클래스를 사용해 객체가 생성되는 순간
     * init{} 블럭의 코드가 자동으로 실행
     * 내부에서 사용 할 변수를 초기화 하거나 미리 실행해야 할 코드를
     * 추가해 놓는다
     */
    init {
        nextWord()
    }

    fun nextWord () {
//       영문단어를 char(문자) 배열로 변경하고
        val engString = allWordsList.random()
        val rndString= engString.toCharArray()
//        무작위로 shuffle() 하기, rndString 데이터 자체 변경
        rndString.shuffle()
        
//        char 배열을 문자열(String)으로 변환
        currentWord.value = rndString.joinToString (separator="")
        unscrambleWord.value = engString
    }

}