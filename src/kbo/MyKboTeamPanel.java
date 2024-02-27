package kbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

class MyKboTeamPanel extends JPanel implements Runnable,LabelSet, ActionListener {
    private ImageIcon icon = new ImageIcon(getClass().getResource("/images/panel3.jpg"));
    private Image img = icon.getImage();

    private Vector<Point> ballVector = new Vector<>();
    private static final int WIDTH=1400;
    private static final int HEIGHT=800;

    private FlickerlingLabel myKBOTeamLabel;
    private MyKboTeamImage myKboTeamImage;
    private JLabel[] introduceLabels;
    private JButton startButton;
    private int size;

    private JProgressBar progressBar;
    private int current=0; //현재 몇번째 질문인지
    private int total=100;
    private int order=1;

    private  MyKBOTeamSearch myKBOTeamSearch;
    private MyKboTeam myTeam;

    MyKboTeamPanel(){
        setLayout(null);

        size=10;
        setFlickeringLabel();
        setMyKboTeamImage();
        setIntroduceLabels();
        setStartButton();

        setOpaque(true);

        Thread th=new Thread(this); //공이 화면에서 눈 처럼 내리는 쓰레드
        th.start();
    }

    private void setFlickeringLabel(){
        myKBOTeamLabel=new FlickerlingLabel("나와 닮은 KBO팀 찾기!",1000);
        myKBOTeamLabel.setHorizontalAlignment(JLabel.CENTER);
        myKBOTeamLabel.setSize(200,50);
        myKBOTeamLabel.setLocation(645,0);
        myKBOTeamLabel.setFont(new Font("맑은고딕", Font.BOLD, 15));
        add(myKBOTeamLabel);
    }

    private void setMyKboTeamImage(){ //구단 이미지들 add
        myKboTeamImage=new MyKboTeamImage();
        JLabel[] teamImageLabels=myKboTeamImage.getTeamImageLabels();
        Point[] points=myKboTeamImage.getPoints();

        for(int i=0;i<size;i++){
            teamImageLabels[i].setSize(100,100);
            teamImageLabels[i].setLocation((int)points[i].getX(),(int)points[i].getY());
            add(teamImageLabels[i]);
        }
    }

    private void setIntroduceLabels(){
        introduceLabels=new JLabel[3];
        introduceLabels[0]=new JLabel("KBO의 10개 구단은 각각 다른 성향을 가지고 있어요.");
        introduceLabels[1]=new JLabel("이미 KBO에 관심이 있는 당신! 혹은 KBO에 대해 알아가고 있는 당신!");
        introduceLabels[2]=new JLabel("나와 닮은 KBO팀, 궁금하지 않나요?");

        int y=220;
        for(int i=0;i<introduceLabels.length;i++){
            setLabel(introduceLabels[i],Color.BLACK,Color.PINK);
            introduceLabels[i].setSize(650,50);
            introduceLabels[i].setLocation(400,y);
            y+=70;
            add(introduceLabels[i]);
        }
    }

    private void setStartButton(){
        startButton=new JButton("START >>");
        startButton.setHorizontalAlignment(JButton.CENTER);
        startButton.setSize(130,50);
        startButton.setLocation(680,500);
        startButton.addActionListener(this);
        add(startButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(icon.getImage(), 0, 0, this);

        g.setColor(Color.RED);
        makeBall();

        for (int i = 0; i < ballVector.size(); i++) {
            Point p = ballVector.elementAt(i);
            if(i%2==0)
                g.fillOval(p.x, p.y, 10, 10);
            else
                g.drawOval(p.x, p.y, 10, 10);
        }
    }

    public void makeBall() { //공 위치 설정
        if (ballVector.size() == 0) {
            for (int i = 0; i < 20; i++) {
                int x = (int) (Math.random() * WIDTH);
                int y = (int) (Math.random() * HEIGHT);
                ballVector.add(new Point(x, y));
            }
        }

        else {
            for (int i = ballVector.size(); i < 20; i++) {
                int x = (int) (Math.random() * this.getWidth());
                int y = 50;
                ballVector.add(new Point(x, y));
            }
        }
    }

    @Override
    public void setLabel(JLabel label, Color fontColor, Color backgroundColor) {
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("맑은고딕", Font.BOLD, 20));
        label.setForeground(fontColor);
    //    label.setBackground(backgroundColor);
    //    label.setOpaque(true);
    }

    private void baseballFallingThread(){
        while(true){
            for(int i = 0; i < ballVector.size(); i++){
                Point p = ballVector.elementAt(i);
                if(p.y >=HEIGHT){
                    ballVector.remove(i);
                }
                else{
                    p.setLocation(p.x, p.y + 5);
                    ballVector.set(i, p);
                }
            }
            repaint();
            try{
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                return;
            }
        }
    }

    private void setProgressBar(){
        int progress=(int)(((double)current/total)*100);
        String stringProgress=order+"/"+3;

        progressBar=new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setValue(progress);
        progressBar.setString(stringProgress);

        progressBar.setSize(300,50);
        progressBar.setLocation(600,700);

        add(progressBar);
    }

    @Override
    synchronized public void run() {
        baseballFallingThread();
    }

    JProgressBar getProgressBar(){return progressBar;}

    private void setNextSearch(MyKBOTeamSearch myTeam){
        setProgressBar();
        myTeam.setSize(this.getWidth(),this.getHeight());
        myTeam.setLocation(0,0);
        JButton[] buttons=myTeam.getAnswerButton();
        for(int i=0;i<buttons.length;i++)
            buttons[i].addActionListener(this);
        add(myTeam);
    }

    private void setMyTeam(MyKboTeam myTeam){
        myTeam.setSize(this.getWidth(),this.getHeight());
        myTeam.setLocation(0,0);
        JButton resetButton=myTeam.getResetButton();
        resetButton.addActionListener(this);
        add(myTeam);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String typed = e.getActionCommand();
        switch (typed){
            case "START >>":
                removeAll();
                order=1;
                current=30;
                myKBOTeamSearch=new MyKBOTeamSearch(0,0,ballVector);
                setNextSearch(myKBOTeamSearch);
                break;

            case "우승은 엄청 중요하지!":
                removeAll();
                order=2;
                current=60;
                myKBOTeamSearch=new MyKBOTeamSearch(1,0,ballVector);
                setNextSearch(myKBOTeamSearch);
                break;
            case "난 우승은 크게 중요하지 않아.":
                removeAll();
                order=2;
                current=60;
                myKBOTeamSearch=new MyKBOTeamSearch(1,1,ballVector);
                setNextSearch(myKBOTeamSearch);
                break;
            case "난 우승 횟수가 많은 팀이 좋아!":
                removeAll();
                order=3;
                current=90;
                myKBOTeamSearch=new MyKBOTeamSearch(2,0,ballVector);
                setNextSearch(myKBOTeamSearch);
                break;
            case "난 우승 횟수는 크게 상관 없어":
                removeAll();
                order=3;
                current=90;
                myKBOTeamSearch=new MyKBOTeamSearch(2,1,ballVector);
                setNextSearch(myKBOTeamSearch);
                break;
            case "난 역사가 오래된 팀이 좋아!":
                removeAll();
                order=3;
                current=90;
                myKBOTeamSearch=new MyKBOTeamSearch(2,2,ballVector);
                setNextSearch(myKBOTeamSearch);
                break;
            case "난 창단된지 얼마 안 된 팀이 좋아.":
                removeAll();
                order=3;
                current=90;
                myKBOTeamSearch=new MyKBOTeamSearch(2,3,ballVector);
                setNextSearch(myKBOTeamSearch);
                break;
            case "나는 열정적인 호랑이!":
                removeAll();
                myTeam=new MyKboTeam("기아타이거즈",ballVector);
                setMyTeam(myTeam);
                break;
            case "나는 열정적인 사자!":
                removeAll();
                myTeam=new MyKboTeam("삼성라이온즈",ballVector);
                setMyTeam(myTeam);
                break;
            case "나는 적당한게 좋아!":
                removeAll();
                myTeam=new MyKboTeam("두산베어스",ballVector);
                setMyTeam(myTeam);
                break;
            case "나는 새로운게 좋아!":
                removeAll();
                myTeam=new MyKboTeam("ssg랜더스",ballVector);
                setMyTeam(myTeam);
                break;
            case "나는 제일 긴게 좋아!":
                removeAll();
                myTeam=new MyKboTeam("lg트윈스",ballVector);
                setMyTeam(myTeam);
                break;
            case "나는 느긋한 편이야!":
                removeAll();
                myTeam=new MyKboTeam("한화이글스",ballVector);
                setMyTeam(myTeam);
                break;
            case "나는 완전 열정적이야!":
                removeAll();
                myTeam=new MyKboTeam("롯데자이언츠",ballVector);
                setMyTeam(myTeam);
                break;
            case "나는 날씨와 상관 없는 실내가 좋아!":
                removeAll();
                myTeam=new MyKboTeam("키움히어로즈",ballVector);
                setMyTeam(myTeam);
                break;
            case "나는 완전 넓고 세련된 곳을 좋아해!":
                removeAll();
                myTeam=new MyKboTeam("nc다이노스",ballVector);
                setMyTeam(myTeam);
                break;
            case "나는 미끄럼틀 같은 놀이시설이 좋아!":
                removeAll();
                myTeam=new MyKboTeam("kt위즈",ballVector);
                setMyTeam(myTeam);
                break;

            case "다시하기":
                removeAll();
                setFlickeringLabel();
                setMyKboTeamImage();
                setIntroduceLabels();
                setStartButton();
                setOpaque(true);
                break;
        }

        revalidate();
        repaint();
    }
}

