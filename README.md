# ⚾ 자바 스윙 컴포넌트를 이용한 KBO 서비스 프로그램

## 🌟 프로젝트 소개
KBO 팬과 팬이 아닌 사용자 모두가 즐길 수 있는 KBO 통합 서비스 프로그램 입니다. JAVA의 GUI 프로그래밍을 이용하여 화면을 구성하고 JDBC 프로그래밍을 통해 사용자 정보를 관리합니다.
<br><br>

## 🌟 개발기간
2024.01.12 ~ 2024.01.23
<br><br>

## 🖥 주요 기능
- ### ⚾ KBO service 탭
   * ### ⭐ 로그인, 회원 가입
     * JDBC 프로그래밍을 통해 MySQL을 사용하여 사용자 정보를 관리
     * 닉네임, 비밀 번호를 입력하여 회원 가입 후 로그인 가능
   * ### ⭐ 스레드를 이용한 현재 날짜와 시간을 알려주는 라벨
   * ### ⭐ 오늘의 경기
     * 현재 시간을 기준으로 18:30 ~ 22:00은 경기 중, 22:00 ~ 23:59는 경기 종료, 그 이외의 시간은 경기 예정
     * 점수는 랜덤으로 결정
     * 버튼을 통해 경기 중, 경기 예정일 때는 승리 구단 예측 가능, 경기 종료 시간에는 오늘의 승리 팀 확인 가능
   * ### ⭐ 오늘의 선수 소개
     * 랜덤으로 10명의 선수 중 1명 소개
   * ### ⭐ 오늘의 MVP 투표하기
     * 5명의 선수 중 오늘의 mvp 투표, 투표 후 투표 화면으로 돌아가기 버튼 클릭 가능
   * ### ⭐종료 버튼
     * 종료 버튼 클릭시 실행 종료
       
 - ### ⚾ 구단 살펴보기 탭
   * KBO 10개 구단 중 원하는 팀의 정보 확인
   * 뒤로 가기 또는 키보드의 backspace를 통해 이전 화면으로 돌아가기
     
 - ### ⚾ 나의 KBO 팀 찾기 탭
   * 나의 성격 또는 취향과 어울리는 KBO팀 찾기 기능
   * 스레드를 이용하여 공이 떨어지는 효과
       
## 🌟 Stacks
 <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/MySql-4479A1?style=for-the-badge&logo=MySql&logoColor=white"> 
<br><br>

## 🖥 실행 과정 및 결과
회원 가입
![image](https://github.com/mmije0ng/KBOIntegrationService/assets/127730905/0999a162-a0d1-4f51-94a4-8638712b54f9)

회원 가입 성공
![image](https://github.com/mmije0ng/KBOIntegrationService/assets/127730905/02d5f0e5-1d9a-40d7-9de1-7dfa2bea06f7)

로그인 성공, KBO service 페이지
![image](https://github.com/mmije0ng/KBOIntegrationService/assets/127730905/d1087765-39bf-4a6c-bf68-96fb7a8486dd)

승리 구장 예측 클릭 <br>
![image](https://github.com/mmije0ng/KBOIntegrationService/assets/127730905/17ed3fa6-f834-4eef-bc42-f34f6f9e8011)
![image](https://github.com/mmije0ng/KBOIntegrationService/assets/127730905/6ff79d1c-3249-45c9-8ed2-12b5dde025c0)

오늘의 MVP 투표
![image](https://github.com/mmije0ng/KBOIntegrationService/assets/127730905/78ee8184-44cd-4390-a6b0-1837b68c7709)
![image](https://github.com/mmije0ng/KBOIntegrationService/assets/127730905/a156649d-0bb8-44b2-889f-cc06efbe6251)

구단 살펴 보기
![image](https://github.com/mmije0ng/KBOIntegrationService/assets/127730905/57780078-9948-48c8-a0a3-a391391c24c6)

나의 KBO팀 찾기
![image](https://github.com/mmije0ng/KBOIntegrationService/assets/127730905/e29b91ca-dad2-4151-85dc-8195d6966f8a)
![image](https://github.com/mmije0ng/KBOIntegrationService/assets/127730905/fe5cf0a0-4dce-46d3-9851-a4cc07ff14a7)

## 🖥 시연 영상
https://github.com/mmije0ng/KBOIntegrationService/assets/127730905/65370c02-0eaa-49a6-a9b4-6c844ede6807
