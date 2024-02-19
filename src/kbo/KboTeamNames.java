package kbo;

class KboTeamNames {
    private String[] teamNames;
    private int size;
    KboTeamNames(){
        size=10;
        setTeamNames();
    }
    void setTeamNames(){
        teamNames=new String[size];
        teamNames[0]="기아타이거즈";
        teamNames[1]="두산베어스";
        teamNames[2]="롯데자이언츠";
        teamNames[3]="nc다이노스";
        teamNames[4]="ssg랜더스";
        teamNames[5]="삼성라이온즈";
        teamNames[6]="kt위즈";
        teamNames[7]="키움히어로즈";
        teamNames[8]="lg트윈스";
        teamNames[9]="한화이글스";
    }

    String getTeamNameByIndex(int index){return teamNames[index];}
}