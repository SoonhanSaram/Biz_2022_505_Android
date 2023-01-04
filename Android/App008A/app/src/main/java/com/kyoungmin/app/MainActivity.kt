package com.kyoungmin.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.kyoungmin.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // view Binding을 활성화해 사용하기 위한 객체 선언
    // Kotlin은 변수를 선언함과 동시에 초기화하는 것이 원칙
    // 경우에 따라서 선언과 초기화를 분리시키는 경우가 있음
    // -> lateinit var 키워드를 사용해 변수를 선언
    private lateinit var binding:ActivityMainBinding

    private lateinit var appbarConfig : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding을 사용하기위해 초기화(값 할당)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.mainToolbar)
        
        // fragment_layout.xml 에 있는 FragmentContainerView 를 가져와서
        // navController 로 생성
        val navController = supportFragmentManager.findFragmentById(R.id.Nav_host_fragment)?.findNavController()

        appbarConfig = AppBarConfiguration(navController!!.graph)


        setupActionBarWithNavController(navController!!,appbarConfig)
    } // end onCreate
    
    //Appbar 의 뒤로가기 버튼 활성화
    override fun onSupportNavigateUp(): Boolean {
        val navController = supportFragmentManager.findFragmentById(R.id.Nav_host_fragment)?.findNavController()
        return navController!!.navigateUp(appbarConfig) || super.onSupportNavigateUp()
    }
}