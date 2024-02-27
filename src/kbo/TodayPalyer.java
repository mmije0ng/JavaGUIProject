package kbo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//오늘의 선수 소개 클래스
class TodayPlayer extends JPanel implements LabelSet{
    private Vector<Player> todayPlayerList;
    private ImageIcon imageIcon;
    private Image image;
    private JLabel todayPlayerImageLabel;
    private Player todayPlayer;
    private int index;
    private JPanel todayPlayerPanel;

    private ButtonGroup group;
    private JRadioButton showTodayPlayerButton;
    private JRadioButton hideTodayPlayerButton;

    public TodayPlayer(){
        todayPlayerList=new Vector<>();
        index=0;

        setLayout(new GridLayout(2,2,0,0));
        group=new ButtonGroup();
        showTodayPlayerButton=new JRadioButton("오늘의 선수 보기");
        hideTodayPlayerButton=new JRadioButton("오늘의 선수 숨기기");

        group.add(showTodayPlayerButton);
        group.add(hideTodayPlayerButton);
        showTodayPlayerButton.setSelected(true);
        showTodayPlayerButton.setBackground(Color.PINK);
        hideTodayPlayerButton.setBackground(Color.PINK);

        add(showTodayPlayerButton);
        add(hideTodayPlayerButton);

        setOpaque(true);
    }

    private void setTodayPlayerList() {
        todayPlayerList.add(new Player("양현종","기아타이거즈","투수"));
        todayPlayerList.add(new Player("나성범","기아타이거즈","외야수"));
        todayPlayerList.add(new Player("박해민","lg트윈스","외야수"));
        todayPlayerList.add(new Player("임찬규","lg트윈스","투수"));
        todayPlayerList.add(new Player("김혜성","키움히어로즈","내야수"));
        todayPlayerList.add(new Player("이정후","키움히어로즈","외야수"));
        todayPlayerList.add(new Player("고영표","kt위즈","투수"));
        todayPlayerList.add(new Player("배정대","kt위즈","외야수"));
        todayPlayerList.add(new Player("류지혁","삼성라이온즈","내야수"));
        todayPlayerList.add(new Player("오승환","삼성라이온즈","투수"));
        todayPlayerList.add(new Player("문동주","한화이글스","투수"));
        todayPlayerList.add(new Player("정은원","한화이글스","내야수"));
        todayPlayerList.add(new Player("최지훈","ssg랜더스","외야수"));
        todayPlayerList.add(new Player("서진용","ssg랜더스","투수"));
        todayPlayerList.add(new Player("박건우","nc다이노스","외야수"));
        todayPlayerList.add(new Player("박민우","nc다이노스","내야수"));
        todayPlayerList.add(new Player("박세웅","롯데자이언츠","투수"));
        todayPlayerList.add(new Player("전준우","롯데자이언츠","외야수"));
        todayPlayerList.add(new Player("홍건희","두산베어스","투수"));
        todayPlayerList.add(new Player("허경민","두산베어스","내야수"));
    }

    private void setTodayPlayerIndex() {
        index=(int)(Math.random()*(todayPlayerList.size()-1));
    }

    public void setLabel(JLabel label, Color fontColor, Color backgroundColor) {
        label.setFont(new Font("맑은고딕", Font.BOLD, 12));
        label.setForeground(fontColor);
        label.setBackground(backgroundColor);
        label.setOpaque(true);
    }

    private void setField(JTextField field) {
        field.setFont(new Font("맑은고딕", Font.BOLD, 12));
        field.setEditable(false);
        field.setBackground(Color.WHITE);
    }

    private void setPlayerPanel() {
        todayPlayerPanel=new JPanel();
        todayPlayerPanel.setLayout(new GridLayout(3,2));

        JLabel playerNameLabel=new JLabel("이름: ");
        setLabel(playerNameLabel,Color.BLACK,Color.WHITE);
        JLabel playerTeamLabel=new JLabel("소속팀: ");
        setLabel(playerTeamLabel,Color.BLACK,Color.WHITE);
        JLabel playerTypeLabel=new JLabel("포지션: ");
        setLabel(playerTypeLabel,Color.BLACK,Color.WHITE);

        JTextField playerNameField=new JTextField(todayPlayer.getPlayerName());
        setField(playerNameField);

        JTextField playerTeamField=new JTextField(todayPlayer.getPlayerTeam());
        setField(playerTeamField);

        JTextField playerTypeField=new JTextField(todayPlayer.getPlayerType());
        setField(playerTypeField);

        todayPlayerPanel.add(playerNameLabel);
        todayPlayerPanel.add(playerNameField);
        todayPlayerPanel.add(playerTeamLabel);
        todayPlayerPanel.add(playerTeamField);
        todayPlayerPanel.add(playerTypeLabel);
        todayPlayerPanel.add(playerTypeField);
    }

    void setTodayPlayer() {
        setTodayPlayerList();
        setTodayPlayerIndex();
        todayPlayer=todayPlayerList.get(index);

        imageIcon=new ImageIcon(getClass().getResource("/images/"+todayPlayer.getPlayerName()+".jpg"));
        image=imageIcon.getImage();
        image=image.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        imageIcon=new ImageIcon(image);

        todayPlayerImageLabel=new JLabel(imageIcon);
        add(todayPlayerImageLabel);

        setPlayerPanel();
        add(todayPlayerPanel);
    }

    void showTodayPlayer() {
        todayPlayerImageLabel.setVisible(true);
        todayPlayerPanel.setVisible(true);
    }

    void hideTodayPlayer() {
        todayPlayerImageLabel.setVisible(false);
        todayPlayerPanel.setVisible(false);
    }

    JRadioButton getShowTodayPlayerButton() {
        return showTodayPlayerButton;
    }

    JRadioButton getHideTodayPlayerButton() {
        return hideTodayPlayerButton;
    }
}