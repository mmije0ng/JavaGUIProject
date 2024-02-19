package kbo;

class Answer {
    private String[][] answers;
    Answer(){
        setAnswer();
    }

    private void setAnswer(){
        answers=new String[3][];
        answers[0]=new String[2];
        answers[1]=new String[4];
        answers[2]=new String[10];

        answers[0][0]="우승은 엄청 중요하지!"; //기, 삼, 두, lg,ssg
        answers[0][1]="난 우승은 크게 중요하지 않아."; //키, 한, kt, 롯, nc

        answers[1][0]="난 우승 횟수가 많은 팀이 좋아!"; //기, 삼
        answers[1][1]="난 우승 횟수는 크게 상관 없어"; //두, lg, ssg

        answers[1][2]="난 역사가 오래된 팀이 좋아!"; //한, 롯
        answers[1][3]="난 창단된지 얼마 안 된 팀이 좋아."; //키, kt, nc

        answers[2][0]="나는 열정적인 호랑이!"; //기아
        answers[2][1]="나는 열정적인 사자!"; //삼성

        answers[2][2]="나는 적당한게 좋아!"; //두산
        answers[2][3]="나는 새로운게 좋아!"; //ssg
        answers[2][4]="나는 제일 긴게 좋아!"; //lg

        answers[2][5]="나는 느긋한 편이야!"; //한화
        answers[2][6]="나는 완전 열정적이야!"; //롯데

        answers[2][7]="나는 날씨와 상관 없는 실내가 좋아!"; //키움
        answers[2][8]="나는 완전 넓고 세련된 곳을 좋아해!"; //nc
        answers[2][9]="나는 미끄럼틀 같은 놀이시설이 좋아!"; //kt
    }

    String getAnswer(int i,int j){return answers[i][j];}
}
