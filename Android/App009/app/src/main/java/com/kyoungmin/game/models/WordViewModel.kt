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
    // viewModel 통해서 Observer 할 변수 선언
    /**
     * String type dml epdlxjfmf wjwkdgksms qustn
     * Observer 를 통해서 변화를 감시할 수 잇는 state
     * private 으로 기본 변수를 선언
     */
    private var _engWord = MutableLiveData<String>("")

    /**
     * viewModel에서 사용되는 변수를 외부에서 읽기 참조 할 수 있또록
     * get () method를 선언해 둔다
     */
    val engword : LiveData<String> get () = _engWord

    /**
     * 외부에서 engWord 변수에 접근해
     * 데이터를 저장하는 함수
     */
    fun setEngWord(word:String) {
        _engWord.value = word
    }


    private var _currentWord = MutableLiveData<String>("")
    val current : LiveData<String> get() = _currentWord
    init {
        nextWord()
    }

    fun nextWord () {
//       영문단어를 char(문자) 배열로 변경하고
        val rndString = allWordsList.random().toCharArray()
//        무작위로 shuffle() 하기, rndString 데이터 자체 변경
        rndString.shuffle()
        
//        char 배열을 문자열(String)으로 변환
        _currentWord.value = rndString.joinToString (separator="")
    }

}