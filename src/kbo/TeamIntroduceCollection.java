package kbo;

class TeamIntroduceCollection {
    int num;
    String introduce;

    TeamIntroduceCollection(int num){
        this.num=num;
        setIntroduce();
    }

    private void setIntroduce() {
        if(num==0)
            introduce="KIA 타이거즈는 대한민국 광주광역시를 연고지로 하는 KBO 소속 프로 야구팀이다."+"\n"+"지금까지 한국시리즈에 11회 진출하여 11회 모두 우승을 차지할 만큼 KBO 리그에서 유일하게 한국시리즈에서 준우승에 머문 적이 없다.";
        else if(num==1)
            introduce="두산 베어스는 대한민국 서울특별시를 연고지로 하는 KBO 소속 프로 야구단이다."+"\n"+ "KBO 한국시리즈에서 총 6회 우승 하였다.";
        else if(num==2)
            introduce="NC 다이노스는 경상남도 창원시를 연고로 하는 KBO 소속 프로 야구단이다."+"\n"+"2020년 정규시즌과 한국시리즈에서 구단 첫 통합 우승을 차지하였다.";
        else if(num==3)
            introduce="롯데 자이언츠는 대한민국 부산광역시를 연고지로 하는 KBO 소속 프로 야구 팀이다."+"\n"+"1975년에 실업 야구단으로 창단되어 역대 KBO구단중 가장 오래된 구단이다. 1982년에 프로 야구단으로 변경했다.";
        else if(num==4)
            introduce="삼성 라이온즈는 대한민국의 대구광역시를 연고지로 하는 KBO 소속 프로 야구 팀이다."+"\n"+"프로 야구 구단 중 유일하게 정규 시즌 10등을 기록한 적이 없다.";
        else if(num==5)
            introduce="키움 히어로즈는 대한민국 서울특별시를 연고지로 하는 KBO 소속 프로 야구단이다."+"\n"+"서울특별시 구로구 고척동에 있는 고척스카이돔을 홈 구장으로 사용한다.";
        else if(num==6)
            introduce="SSG 랜더스는 SK 와이번스를 인수하여 대한민국 인천광역시를 연고지로 하는 KBO 소속 프로야구단이다."+"\n"+"리그 우승 횟수는 총 4번이다.";
        else if(num==7)
            introduce="LG 트윈스는 대한민국 서울특별시를 연고지로 하는 KBO 소속 프로 야구단이다."+"\n"+"2023년 9년 만에 팀 통산 3번째 한국시리즈 우승을 차지하며 고난의 시간을 청산했다.";
        else if(num==8)
            introduce=" 2013년 설립되어 KBO 리그에 참여 중인 야구단으로, 연고지는 경기도 수원시이다."+"\n"+". KBO 리그 출범 이후 신생 팀 최단 기간(8년) 한국시리즈 우승의 기록을 보유하고 있다.";
        else if(num==9)
            introduce="한화 이글스는 대한민국의 대전광역시를 연고지로 하는 KBO 소속 프로야구단이다"+"\n"+"한국시리즈 우승은 총 1회이며 연도는 1999년이다.";
    }

    String getIntroduce() {return introduce;}
}
