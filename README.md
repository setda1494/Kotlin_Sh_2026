# 20231549_app_w05 - 구구단 출력 안드로이드 앱

안드로이드 코틀린(Kotlin) 기반의 구구단 계산 및 출력 애플리케이션입니다.  
사용자가 숫자를 입력하고 버튼을 누르면 해당 단의 구구단 결과를 화면에 출력하며, 잘못된 값 입력 시 안전하게 예외를 처리합니다.

---

## 📌 주요 기능 (Key Features)

1. **구구단 계산 및 출력**
   - `EditText`에 출력할 단 수(예: `2`)를 입력하고 **[구구단 출력]** 버튼을 누르면 `1`부터 `9`까지의 계산 결과가 `TextView`에 출력됩니다.

2. **숫자 입력 전용 키패드 지원**
   - `EditText` 선택 시 소프트 키패드(`android:inputType="number"`)가 자동으로 동작하도록 설정되어 편리하게 숫자를 입력할 수 있습니다.

3. **예외 처리 및 안전성 강화 (Crash 방지)**
   - 빈 값 입력 또는 숫자가 아닌 입력 시 화면에 **`null`**이 출력되도록 구현되었습니다.
   - `toIntOrNull()` 및 전체 연산 로직에 `try-catch`와 Null-Safe 연산자를 적용하여 앱이 강제 종료되지 않습니다.

4. **직관적인 레이아웃 및 디자인 (UI/UX)**
   - 수직 방향의 `LinearLayout` 기반 구조.
   - `app:cornerRadius="100dp"` 속성을 적용한 라운드 타원형(캡슐 모양) 버튼 디자인.

5. **안드로이드 리소스 표준 준수**
   - 모든 UI 텍스트(힌트, 버튼 문구, 기본 출력문 등)를 `res/values/strings.xml`에 등록하여 관리합니다.

---

## 🛠 주요 파일 구성 (Project Structure)

- `app/src/main/java/com/a20231549_app_w05/MainActivity.kt`
  - 이벤트 리스너, 입력값 처리, 구구단 연산 및 예외 처리 담당
- `app/src/main/res/layout/activity_main.xml`
  - `LinearLayout` 기반 메인 UI (입력창, 타원형 버튼, 결과 출력 텍스트뷰)
- `app/src/main/res/values/strings.xml`
  - 앱 텍스트 리소스 관리 (`edit_text_hint`, `button_text`, `test_text`, `null_text`)
- `app/build.gradle.kts`
  - `compileSdk 37` 및 최신 AndroidX 라이브러리 설정

---

## 🚀 실행 화면 예시

### 1. 정상 작동 (예: 2단 입력 시)
```text
< 2 단 >

2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
2 x 4 = 8
2 x 5 = 10
2 x 6 = 12
2 x 7 = 14
2 x 8 = 16
2 x 9 = 18
```

### 2. 예외 발생 / 미입력 시
```text
null
```

---

## 🔗 Repository
- **GitHub**: [https://github.com/setda1494/Kotlin_Sh_2026.git](https://github.com/setda1494/Kotlin_Sh_2026.git)
