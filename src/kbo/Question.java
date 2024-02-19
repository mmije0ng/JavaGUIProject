package kbo;

class Question {
    private String[][] questions;
    Question(){
        setQuestions();
    }

    private void setQuestions(){
        questions=new String[3][];
        questions[0]=new String[1];
        questions[1]=new String[2];
        questions[2]=new String[4];

        questions[0][0]="Q1. 야구에서 우승은 얼마나 중요할까?";

        questions[1][0]="Q2. 우승 횟수는 얼마나 있는게 좋을까?";
        questions[1][1]="Q2. 구단의 역사는 어느 정도가 좋을까?";

        questions[2][0]="Q3. 열정적인 호랑이와 사자 중 당신의 선택은?";
        questions[2][1]="Q3. 구단의 역사는 어느 정도가 좋을까?";
        questions[2][2]="Q3. 너는 느긋한 편이야 열정적인 편이야?";
        questions[2][3]="Q3. 너는 어떤 장소를 좋아해?";
    }

    String getQuestion(int i,int j){return questions[i][j];}
}
