# 우리는 크보에 죽고 크보에 산다
### 스윙 컴포넌트를 이용한 KBO 통합 서비스 프로그램
<br>

## ⭐ 프로젝트 소개
KBO 팬과 팬이 아닌 사용자 모두가 즐길 수 있는 KBO 통합 서비스 프로그램 입니다. JAVA의 GUI 프로그래밍을 
<br><br>

## ⭐ 개발기간
2024.01.12 ~ 2024.01.23
<br><br>

## 🖥 주요 기능
- ### ⭐ 홈 CCTV
  * CCTV 시작 버튼을 누르면 라즈베리 파이에 연결된 카메라를 통해 웹에서 실시간으로 cctv 화면을 볼 수 있음
- ### ⭐ 자동 제어
    * 자동 제어 ON 버튼 클릭 시 카메라를 통해 라즈베리파이가 위치한 장소(사용자의 집)에 사람의 유무를 파악
    * 사람이 없으면서 전등, 수도, 난방 시스템이 켜져 있는 경우 자동으로 시스템이 꺼짐
    * 자동 제어 OFF 버튼 클릭 시 집의 사람이 없어도 시스템의 변화가 생기지 않음
- ### ⭐ 전등, 수도, 난방 제어 버튼
   * 전등 제어 on 클릭 시 전등(GPIO25 노란색 led)이 켜짐, off 버튼 클릭 시 전등이 꺼짐
   * 수도 제어 on 클릭 시 전등(GPIO14 초록색 led)이 켜짐, off 버튼 클릭 시 수도를 잠금
   * 난방 제어 on 클릭 시 전등(GPIO6 빨간색 led)이 켜짐, off 버튼 클릭 시 난방을 끔
- ### ⭐ 전등, 수도, 난방 알림
   * 전등 알림 버튼 클릭 시 조도 센서에서 값을 읽어와 전등이 켜져있는 지 꺼져 있는지를 알려줌
   * 전등이 켜져있다면 전등을 킬 것인지, 끌 것인지 선택하여 시스템 제어 가능
   * 수도 알림 버튼 클릭 시 초음파 센서를 통해 센서와 물체와의 거리를 측정해 수도가 열려 있는지 잠겨 있는지 알려줌
   * 수도가 열려 있다면 수도를 열 것인지, 잠글 것인지 선택하여 시스템 제어 가능
   * 난방 알림 버튼 클릭 시 온습도 센서에서 값을 읽어와 난방이 켜져있는 지 꺼져 있는지를 알려줌
   * 난방이 켜져있다면 전등을 킬 것인지, 끌 것인지 선택하여 시스템 제어 가능
- ### 실시간 전등, 수도, 난방 요금 계산
  * 차트를 통해 실시간 전등, 수도, 난방 요금을 확인 가능
  * 목표 요금을 설정하여 실시간 요금이 목표 요금을 넘긴다면 자동으로 시스템 제어
<br><br>


![image](https://github.com/mmije0ng/KBOIntegrationService/assets/127730905/af98eb03-e83d-420c-a757-9b2f13871d06)
