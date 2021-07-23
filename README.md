

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://ovenapp.io/view/7yFxMZwFyZ10NiwMUPbTV39nFHsFDtfz/clQkh">
    <img width="227" alt="스크린샷 2021-07-21 오전 10 05 15" src="https://user-images.githubusercontent.com/54930877/126414507-7129adca-947a-4707-86a0-dcb15871194f.png">
  </a>

  <h3 align="center">PeepPeep</h3>

  <p align="center">
    커밋할수록 자라나는 귀여운 병아리들과 꾸준한 개발습관 들이기 어플
    <br />
    <a href="https://github.com/KPUCE2021SP/hummingbird"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://ovenapp.io/view/7yFxMZwFyZ10NiwMUPbTV39nFHsFDtfz#1CXFY">프로토타입 보러가기</a>
    ·
    <a href="https://www.notion.so/12341cb0f7cb4c7fa11d6e3141e6ce81?v=62cc868baadf48c3b2bd810741db7109">회의 기록 노션 보러가기</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li><a href="#system-configuration-diagram">System Configuration Diagram</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
      </ul>
    </li>
    <li><a href="#license">License</a></li>
    <li><a href="#role">Role</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project
다양한 병아리들과 함께하는 꾸준한 개발 습관 들이기 프로젝트!
개발자님들, 같이 PeepPeep 하실래요?

- Github 계정과의 연동으로 나의 커밋 현황을 간편하게 확인하세요.
    - **다양하고 귀여운 병아리들** : 꾸준히 커밋하고 성장하는 병아리를 만나보세요. 다 성장하면 둥지를 트고 다른 병아리를 모을 수 있답니다. 특정 확률로 병아리가 아닌 다른 새를 만날 수 있어요!
    - **커밋 달력** : 직관적인 잔디 달력으로 일일 커밋 현황을 꼼꼼히 확인해요.
    - **월간 리포트** : 매달 마지막 날 생성되는 리포트로 한 달간 나의 개발을 되돌아봐요.
    - **병아리 수집 앨범** : 다큰 병아리를 독립하여 다른 병아리가 올 수 있도록 둥지를 만들고 떠납니다. 지금까지 모은 병아리들을 추억할 수 있습니다.
    - **농장 탐험** : 다른 깃허브 유저들의 병아리를 확인하고 얼마나 커밋했는지 확인하세요!

병아리를 키우고 모으며 매일 조금씩 commit 하다 보면, 꾸준한 습관 만들기는 물론 개발이 더욱 재밌어질 거예요!

### Built With

* [Firebase](https://firebase.google.com/)
* [Android Studio](https://developer.android.com/studio)
* [Kotlin](https://developer.android.com/kotlin)
* [JetPack](https://developer.android.com/jetpack?hl=ko)

### Architecture

* [MVVM](https://developer.android.com/jetpack/guide?hl=ko)


하지만 Cloud Firestore를 사용 하면 마지막 두 부분을 제거 할 수 있습니다. 이는 Firestore가 자체 로컬 캐시를 제공하기 때문입니다. 즉, 아래 다이어그램과 같이 모델 및 원격 데이터 소스를 제거하고 단일 저장소 클래스에 결합 할 수 있습니다.
<br />
<img src="https://user-images.githubusercontent.com/54930877/126727419-a0559519-e34b-42f6-a800-0917cbb5d19f.jpg" width=600 height=500></img>


<!-- 시스템 구성도 -->
### System Configuration Diagram
![93047604-d7d86880-f697-11ea-8e36-695d67b1e9e5](https://user-images.githubusercontent.com/54930877/126727611-32a60de1-e299-471c-abdc-2498aca8987b.png)

<!-- GETTING STARTED -->
## Getting Started

아직 출시되지 않았어요! 조금만 더 기다려주실거죠?

### Prerequisites
프로젝트 수준 그래들
``` gradle
ext.kotlin_version = "1.5.10"
classpath "com.android.tools.build:gradle:4.2.2"
classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
```

앱 수준 그래들
``` gradle
compileSdkVersion 30
buildToolsVersion "30.0.0"
minSdkVersion 16
targetSdkVersion 30
jvmTarget = '1.8'
testImplementation 'junit:junit:4.+'
```
<!-- LICENSE -->
## License

Distributed under the MIT License. See https://github.com/KPUCE2021SP/hummingbird/blob/main/LICENSE for more information.


<!-- Role -->
## Role

* [김기현](https://github.com/kim1387) - 팀장, 데브옵스, 백엔드
* [송경진](https://github.com/kjsong99) - 트러블슈팅, 백엔드
* [장아령](https://github.com/aristo0922) - 프론트엔드, 백엔드
* [허민](https://github.com/hhhminme) - PM, 백엔드
