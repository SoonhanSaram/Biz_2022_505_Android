# Android viewModel data management
* 안드로이드 App에서는 Kotlin Jet-pack Compose에서 제공하는 `viewModel`을
* 사용하여 데이터(단일변수, 배열, 객체 등등)를 화면에 표현하는 방법을 구현

## viewModel 
* App에서 사용하는 데이터를 viewModel 이라는 `Observer`가 변화되는 데이터를
* 감시하고 있다가 데이터의 변화가 발생하면 변화된 데이터를 UI화면에 반영해주는
* 기술
* 다른도구(React...)에서 사용하는 state 라는 개념과 유사

## viewModel을 사용하기 위한 dependencies 설정
* Maven repository에서 검색 : 'android lifecycle' 
````agsl
def lifecycle_version = "2.5.1"
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
````
* Fragment에서 LiveData를 사용하기위한 dependency 검색 : 'android fragment'
```agsl
implementation 'androidx.fragment:fragment-ktx:1.5.5'
```
* view 와 viewModel을 실시간으로 연결하기위한 Observer 보조도구
* 검색어 : 'android databinding'
```agsl
implementation 'androidx.databinding:databinding-runtime:7.3.1'
```
* dependencies 를 설정한 후 Project Structure 에 들어가 버전확인