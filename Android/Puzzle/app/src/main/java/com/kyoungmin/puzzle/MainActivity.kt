package com.kyoungmin.puzzle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kyoungmin.puzzle.databinding.ActivityMainBinding
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

data class ResultGetSearchWord (
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<Items>
)

data class ResultGetSearchkWord (
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var items: List<Items>
)

data class Items (
    var title: String = "",
    var originallink: String = "",
    var link: String = "",
    var description: String = "",
)
interface NaverAPI {
    @GET("v1/search/encyc.json")
    fun getSearchWord(
        @Header("X-Naver-Client-Id") clientId : String,
        @Header("X-Naver-Client-Secret") clientSecret : String,
        @Query("query") query: String,
        @Query("display") display : Int? = null,
        @Query("start") start: Int? = null,
    ): Call<ResultGetSearchWord>
}
interface KoreaAPI {
    @GET("https://krdict.korean.go.kr/api/search")
    fun getSearchkWord (
        @Header("key") verifiedkey : String,
        @Query("q") keyword : String,
        @Query("part") part : String,
        @Query("start") start : Int? = null,
        @Query("num") num : Int? = null,
    ): Call<ResultGetSearchkWord>
}
val CLIENT_ID = "oO7nf36M7p4tOjKmxwI4"
val CLIENT_SECRET = "qlxbuDX1Mb"
val BASE_URL_NAVER_API = "https://openapi.naver.com/"
val VERIFIED_KEY = "C043A81262E06A665EA1A043A4495D7C"
val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL_NAVER_API)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
val wordSearch = retrofit.create(NaverAPI::class.java)

val retrofit2 = Retrofit.Builder()
    .baseUrl("https://krdict.korean.go.kr/api/search/")
    .addConverterFactory(TikXmlConverterFactory.create())
    .build()
val kWordSearch = retrofit2.create(KoreaAPI::class.java)



class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("헬로")
//        wordSearch.getSearchWord(CLIENT_ID, CLIENT_SECRET,"apple").enqueue(object :Callback<ResultGetSearchWord>{
//            override fun onResponse(
//                call: Call<ResultGetSearchWord>,
//                response: Response<ResultGetSearchWord>
//            ) {
//                // http data 교환간에 raw()는 데이터 유무만 표시
//                // body()는 정확한 값을 표시
//                //Log.d("성공", "${response.body()}" )
//                Log.d("데이터", "${response.body().items}")
//                //binding.txtTest.text.toString(response.body.items)
//
//            }
//
//            override fun onFailure(call: Call<ResultGetSearchWord>, t: Throwable) {
//                Log.d("실패", t.toString())
//            }
//        })
        kWordSearch.getSearchkWord(VERIFIED_KEY,"나무","word").enqueue(object : Callback<ResultGetSearchkWord>{
            override fun onResponse(
                call: Call<ResultGetSearchkWord>,
                response: Response<ResultGetSearchkWord>
            ) {
                Log.d("성공", "${response.body()}" )
            }

            override fun onFailure(call: Call<ResultGetSearchkWord>, t: Throwable) {
                Log.d("실패", t.toString())            }
        })
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}