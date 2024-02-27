package kbo;
import kbo.*;
import kbo.db.JDBC;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

class KboMainPanel extends JPanel implements ActionListener, LabelSet {
    JDBC jdbc;
    Login loginPanel;
    private JButton loginButton;
    private JButton joinButton;
    private JLabel joinSuccessPanel;
    private MyKeyListener myKeyListener;

    private ImageIcon icon = new ImageIcon(getClass().getResource("/images/panel1.jpg"));
    private Image img = icon.getImage();

    private boolean isMain=false;
    private String user;
    private Introduce introduceKBO;
    private JLabel todayPlayerLabel;
    private TodayPlayer todayPlayer;
    private JLabel todayMvpLabel;
    private TodayMvp todayMvp;
    private int totalVotes;
    private ClockThread clockThread;
    private TodayScheduleList todayScheduleList;
    private JLabel scheduleLabel;
    private JLabel myLoginLabel;

    private JButton teamSearchButton=new JButton("구단 살펴보기");
    private JButton myKboTeamButton=new JButton("나의 KBO 팀 찾기");
    private JButton exitButton;

    public KboMainPanel() {
        setLayout(null);

        setLoginPanel();

        setOpaque(true);
        // setBackground(Color.WHITE);

        setVisible(true);
    }

    private void setLoginPanel() {
        jdbc=new JDBC();

        introduceKBO=new Introduce();
        introduceKBO.setSize(320,60);
        introduceKBO.setLocation(590,22);

        clockThread=new ClockThread();
        clockThread.setSize(250,30);
        clockThread.setLocation(2,2);

        myKeyListener=new MyKeyListener();
        loginPanel=new Login();
        loginPanel.getUserField().addKeyListener(myKeyListener);

        loginPanel.getPassField().addKeyListener(myKeyListener);
        loginPanel.setSize(320,100);
        loginPanel.setLocation(580,210);

        loginButton=new JButton("로그인");
        loginButton.setSize(120,40);
        loginButton.setLocation(590,360);
        loginButton.addActionListener(this);

        joinButton=new JButton("회원 가입");
        joinButton.setSize(120,40);
        joinButton.setLocation(750,360);
        joinButton.addActionListener(this);

        joinSuccessPanel=new JLabel();
        joinSuccessPanel.setSize(300,40);
        joinSuccessPanel.setLocation(700,150);

        add(introduceKBO);
        add(clockThread);
        add(loginPanel);
        add(loginButton);
        add(joinButton);
        add(joinSuccessPanel);

        repaint();
    }

    private void setMainPanel() {
        introduceKBO=new Introduce();
        introduceKBO.setSize(300,60);
        introduceKBO.setLocation(590,22);

        todayPlayerLabel=new JLabel("오늘의 선수 소개");
        todayPlayerLabel.setHorizontalAlignment(JLabel.CENTER);
        setLabel(todayPlayerLabel,Color.WHITE,Color.MAGENTA);
        todayPlayerLabel.setSize(150,55);
        todayPlayerLabel.setLocation(70,125);

        todayPlayer=new TodayPlayer();
        todayPlayer.setTodayPlayer();
        todayPlayer.setSize(305,350);
        todayPlayer.setLocation(0,180);
        todayPlayer.setBackground(Color.PINK);

        todayPlayer.getShowTodayPlayerButton().addActionListener(this);
        todayPlayer.getHideTodayPlayerButton().addActionListener(this);

        todayMvpLabel=new JLabel("오늘의 MVP 투표하기");
        todayMvpLabel.setHorizontalAlignment(JLabel.CENTER);
        setLabel(todayMvpLabel,Color.WHITE,Color.MAGENTA);
        todayMvpLabel.setSize(180,50);
        todayMvpLabel.setLocation(1200,130);

        todayMvp=new TodayMvp();
        todayMvp.setSize(380,350);
        todayMvp.setLocation(1105,180);
        todayMvp.setBackground(Color.WHITE);
        totalVotes=0;

        todayMvp.getVoteButton().addActionListener(this);
        todayMvp.getVoteBackButton().addActionListener(this);

        clockThread=new ClockThread();
        clockThread.setSize(250,30);
        clockThread.setLocation(2,2);

        scheduleLabel=new JLabel("오늘의 경기");
        scheduleLabel.setHorizontalAlignment(JLabel.CENTER);
        setLabel(scheduleLabel,Color.WHITE,Color.MAGENTA);
        scheduleLabel.setSize(150,55);
        scheduleLabel.setLocation(660,125);

        todayScheduleList=new TodayScheduleList();

        todayScheduleList.setSize(750,352);
        todayScheduleList.setLocation(330,179);

        for(int i=0;i<5;i++) {
            todayScheduleList.getTodayScheduleList()[i].getGameButton().addActionListener(this);
        }

        teamSearchButton.setHorizontalAlignment(JButton.CENTER);
        teamSearchButton.setSize(150,50);
        teamSearchButton.setLocation(500,600);

        myKboTeamButton.setHorizontalAlignment(JButton.CENTER);
        myKboTeamButton.setSize(150,50);
        myKboTeamButton.setLocation(800,600);

        add(introduceKBO);
        add(todayPlayerLabel);
        add(todayPlayer);
        add(todayMvpLabel);
        add(todayMvp);
        add(clockThread);
        add(scheduleLabel);
        add(todayScheduleList);
        add(teamSearchButton);
        add(myKboTeamButton);

        setExitButton();
        repaint();
    }

    private void setExitButton(){
        exitButton=new JButton("종료하기");
        exitButton.setHorizontalAlignment(JButton.CENTER);
        exitButton.setSize(100,50);
        exitButton.setLocation(1380,0);
        exitButton.addActionListener(this);
        add(exitButton);
    }

    private void setExit(){
        int result=JOptionPane.showConfirmDialog(null,
                "종료하시겠습니까?","종료",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION)//예(종료)
            System.exit(0);
    }

    JButton getTeamSearchButton() { return teamSearchButton;}
    JButton getMyKboTeamButton(){return myKboTeamButton;}

    public void setLabel(JLabel label, Color fontColor, Color backgroundColor) {
        label.setFont(new Font("맑은고딕", Font.ITALIC, 15));
        label.setForeground(fontColor);
        label.setBackground(backgroundColor);
        label.setOpaque(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(icon.getImage(), 0, 0, this);
        g.setColor(Color.CYAN);

        if(!isMain) {
            g.setFont(new Font("Jokerman",Font.BOLD,20));
            g.drawString("login",470,180);

            g.drawRect(460, 190,520, 230);
        }

        else{
            g.drawOval(520, 12, 450, 90);

            //    g.setColor(Color.WHITE);
            g.setFont(new Font("Jokerman",Font.BOLD,20));
            g.drawString("KBO service",550,800);
            g.setFont(new Font("맑은 고딕",Font.BOLD,20));
            g.drawString("에 오신 것을 환영합니다!",695,800);
        }

    }

    //승리 팀 다이얼로그
    private void setTodayWinTeam(String place, int index) {
        String winTeam=todayScheduleList.getTodayScheduleList()[index].getWinTeam();
        String msg=place+" 구장 경기의 오늘의 승리 팀은 "+winTeam+"입니다!";
        JOptionPane.showMessageDialog(null,msg,"오늘의 승리 팀",JOptionPane.INFORMATION_MESSAGE);
    }

    //승리 예측 다이얼로그
    private void guessTodayWinTeam(String team1, String team2, String place, int y) {
        String msg=team1+"와 "+team2+", 어느 팀이 승리할까요?";
        String winTeam=JOptionPane.showInputDialog(msg);

        if(winTeam==null)
            return;
        MyWinTeam myWinTeam=new MyWinTeam(winTeam,place,user);
        myWinTeam.setSize(300,30);
        myWinTeam.setLocation(2,550+y);
        myWinTeam.setBackground(Color.YELLOW);
        add(myWinTeam);
    }

    private void setMyLoginLabel() {
        myLoginLabel=new JLabel(user+"님이 로그인 하였습니다.");
        myLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        setLabel(myLoginLabel,Color.BLACK,Color.YELLOW);
        myLoginLabel.setSize(250,30);
        myLoginLabel.setLocation(2,35);
        add(myLoginLabel);
    }

    boolean getIsMain(){return isMain;}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JTextField) {
            JTextField t=(JTextField)e.getSource();
            user=t.getText();
            revalidate();
            repaint();
            return;
        }

        String typed = e.getActionCommand();
        switch(typed) {
            case "로그인":
                String loginId=loginPanel.getUserField().getText();
                String loginPassword=loginPanel.getPassField().getText();
                if(loginId.equals("") || loginPassword.equals(""))
                    return;
                removeAll();

                boolean login=jdbc.login(loginId,loginPassword);
                if(login){
                    isMain=true;
                    user=loginPanel.getUserField().getText();
                    setMyLoginLabel();
                    setMainPanel();
                }

                else{
                    setLoginPanel();
                    joinSuccessPanel.setText("로그인 실패");
                }

                break;

            case "회원 가입":
                String joinId=loginPanel.getUserField().getText();
                String joinPassword=loginPanel.getPassField().getText();
                if(joinId.equals("") || joinPassword.equals(""))
                    return;

                removeAll();
                setLoginPanel();

                boolean isIdExist=jdbc.join(joinId, joinPassword);
                if(!isIdExist)
                    joinSuccessPanel.setText("회원 가입 완료");

                else
                    joinSuccessPanel.setText("회원 가입 실패");

                break;

            case "오늘의 선수 보기":
                todayPlayer.showTodayPlayer();
                break;
            case "오늘의 선수 숨기기":
                todayPlayer.hideTodayPlayer();
                break;

            case "mvp 투표":
                todayMvp.removeAll();

                totalVotes++;
                todayMvp.setPlayerVotes(totalVotes);
                todayMvp.setPercentPanel();
                todayMvp.addButtons();
                todayMvp.getVoteButton().addActionListener(this);
                todayMvp.getVoteBackButton().addActionListener(this);
                break;

            case "투표 화면으로 돌아가기":
                todayMvp.removeAll();

                todayMvp.setVotePanel();
                todayMvp.addButtons();

                todayMvp.getVoteButton().addActionListener(this);
                todayMvp.getVoteBackButton().addActionListener(this);
                break;

            case "광주 오늘의 승리 팀":
                setTodayWinTeam("광주",0);
                break;

            case "광주 승리 예측하기":
                guessTodayWinTeam("기아","두산","광주",0);
                break;

            case "잠실 오늘의 승리 팀":
                setTodayWinTeam("잠실",1);
                break;

            case "잠실 승리 예측하기":
                guessTodayWinTeam("엘지","한화","잠실",30);
                break;

            case "대구 오늘의 승리 팀":
                setTodayWinTeam("대구",2);
                break;

            case "대구 승리 예측하기":
                guessTodayWinTeam("삼성","키움","대구",60);
                break;

            case "창원 오늘의 승리 팀":
                setTodayWinTeam("창원",3);
                break;

            case "창원 승리 예측하기":
                guessTodayWinTeam("nc","롯데","창원",90);
                break;

            case "인천 오늘의 승리 팀":
                setTodayWinTeam("인천",4);
                break;

            case "인천 승리 예측하기":
                guessTodayWinTeam("ssg","kt","인천",120);
                break;
            case "종료하기":
                setExit();
                break;
        }
        revalidate();
        repaint();
    }

    private class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode=e.getKeyCode();
            if(!isMain && (keyCode==13 || keyCode==10)) {
                String userName=loginPanel.getUserField().getText();
                String pass=loginPanel.getPassField().getText();
                if(userName.equals("") || pass.equals(""))
                    return;
                removeAll();
                setMainPanel();
                isMain=true;
                user=loginPanel.getUserField().getText();
                setMyLoginLabel();

                revalidate();
                repaint();
            }
        }
    }
}