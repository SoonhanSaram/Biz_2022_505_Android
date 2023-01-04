package com.kyoungmin.game.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.kyoungmin.game.databinding.FragmentMainBinding
import com.kyoungmin.game.models.WordViewModel

// 객체지향에서 --> 객체 :
// 데이터(속성), 행위가 같이 들어있음
// 학생데이터를 가지고 성적처리를 하고 싶을 때
// 데이터와 성적처리를 1가지 객체로 묶어서 사용
// Class 객체를 모양을 지정

class MainFragment : Fragment() {

    /**
     * class 내부에서 선언된 변수(배열, 객체 등등)에 private 접근한정자가 부착되면
     * 이 변수는 MainFragment 클래스(객체) 내부의 코드들에서만 접근이 가능
     *      변수에 접근은 : 값의 저장, 값의 변경, 값의 호출 등
     * 변수를 감추는 것을 객체지향 프로그래밍(oop)에서는 정보의 은닉이라고 한다
     * 중요한 데이터를 어디선가 임의로 변경하는 것을 방지하는 목적
     * 멀티태스킹(멀티스레드) 환경에서 다수의 테스트가 한 변수에 접근해 발생하는
     *      문제를 방지하기도 함
     *      
     * 은닉처리된 정보를 외부에서 읽거나 쓸 수 있도록 제한적 개방할 수 있음
     * 객체지향에서는 이것을 get, set 이라고 함
     * 
     * 외부에서 은닉처리된 변수에서 값을 읽고자 할 때는 get() method를 통해서 읽고
     * 값을 저장(메시지 저장)하고자 할 때는 set() method를 통해서 실행
     * 
     * 캡슐화
     * 외부에서 get() method를 통해서 값을 읽으면
     *      객체 내부에서 이루어지는 연산을 몰라도 get()을 통해 읽은 값은 정확하다
     */
    private var _binding : FragmentMainBinding ? = null
    // 접근제한자가 없은 (val, var로 선언된) 변수는 public
    // JAVA와 같은 다른 언어에서는 public 키워드를 부착해야 함
    // MainFragment 외부에서 누구나 binding get Method 통해 _binding 데이터를 
    // 호출 할 수 있다

    /**
     * 객체지향에서 변수를 은닉하고 
     * 은닉된 변수를 외부에서 get() 해 사용할 수 있도록
     * 접근제한자 없이 개방하는 것이 원칙
     * 
     * Fragment에서는 get() method를 접근제한해
     * 현재 클래스(객체)내에서 사용하고, 사용이 끝나면 null로 처리해
     * clear하는 정책을 권장
     * 
     * Fragment는 화면을 구현하기 위해 많은 view들을 가지고 있는 상태
     * 잘못 사용하면 메모리 누수가 발생해 앱이 강제 종료되거나
     * 스마트기기가 느려지는 상황 발생
     * 예방책
     */
    private val binding get () = _binding!!

    /**
     * WordViewModel 클래스를 기준으로 
     * wordViewModel 객체(object) 변수 선언
     * 클래스는 하나의 소스코드이고 실제 이 코드의 내용을 
     * 사용하기 위해서는 객체(Object) 변수로 선언해줘야 한다
     * 
     * by viewModels() : viewModels() 함수에게 변수 초기화 위임확인
     * wordViewModel 을 사용할 수 있도록 생성, 초기화
     */
    private val wordViewModel : WordViewModel by viewModels()

    /**
     * onCreateView 함수가 실행되는 동안에는
     * 화면에 그려지는 view들이 미완성됐을 수 있음
     * 화면에 그려지는 view 연산은
     * onViewCreated 함수에서 코드를 작성
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // event를 설정하거나 
        // view를 통해서 문자열을 읽거나, 보여주거나 하는 일들은
        // onCreateView에서 수행하지 않고, onViewCreated에서 하도록

        /**
         * 안드로이드 viewModel 패턴
         * 1. 감시할 데이터를 담을 변수를 WordViewModel 클래스에 선언
         * 2. WordViewModel 클래스에 변수에 대한 get method 선언
         * 3. 필요에 따라 변수에 값을 저장하는 함수 선언
         * 4. Activity 나 Fragment 에서 viewModel 객체를 생성
         * 5. 생성된 viewModel 객체를 observer에 등록
         *
         * 이 상태가 되면 어디선가 문자열 변수의 값이 변경되면
         * observer로 등록된 코드가 자동실행된다 
         * 일종의 event 현상
         * viewModel 에 등록된 변수의 값이 변경되면 
         * Event가 발생하고
         * observer 로 등록한 코드가 자동 실행된다
         */

        // wordViewModel 의 word(_word) 변수를 감시할 Observer 생성
        val wordObServer = Observer<String> {
            Snackbar.make(binding.txtInputWord, it, Snackbar.LENGTH_LONG).show()
        }
        wordViewModel.engword.observe(viewLifecycleOwner, wordObServer)
        /**
         * submit button이 클릭되면 wordViewModel 의 engword 변수에
         * txtInputWord 에 입력된 문자열을 저장
         */
        binding.btnSubmit.setOnClickListener{
            val word = binding.txtInputWord.text.toString()
            wordViewModel.setEngWord(word)
        }
        binding.btnSkip.setOnClickListener{
            wordViewModel.nextWord()
        }
        /**
         * fragment 의 lifecycle 동안에 wordViewModel 을 계속 감시하면서
         * binding에 연결된
         * layout / data / view 간의 변화되는 내용을 sync
         */
        binding.lifecycleOwner = viewLifecycleOwner
        binding.wordViewMoldel = wordViewModel
    }

    /**
     * Fragment 사용이 종료되었을 때 할 일 지정
     * Fragment 사용이 끝났을 때 view.xml과 연결된 _binding 변수를 제거
     * 혹여나 발생할 메모리 누수를 방지
     */
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}