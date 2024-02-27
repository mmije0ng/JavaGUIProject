package kbo;

import java.awt.*;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class TodaySchedule extends JPanel implements LabelSet{
    private String team1,team2;
    private JLabel team1Label,team2Label;
    private int team1Score,team2Score;
    private JLabel team1ScoreLabel,team2ScoreLabel;
    private ImageIcon team1ImageIcon,team2ImageIcon;
    private Image team1Image, team2Image;
    private JLabel team1ImageLabel,team2ImageLabel;
    private Calendar now;
    private int hour,min;
    private JLabel gameStartLabel;  //18시 30분
    private JLabel gameStateLabel; //경기 상황 라벨
    private String gameState; //경기 예정, 중, 종료
    private JLabel gamePlaceLabel;
    private String gamePlace;
    private JButton gameButton;
    private String winTeam;

    TodaySchedule(String team1, String team2, String gamePlace){
    //    setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
        setLayout(new GridLayout(1,10,0,0));
        this.team1=team1;
        this.team2=team2;
        team1Label=new JLabel(team1);
        team2Label=new JLabel(team2);
        setLabel(team1Label,Color.BLACK,Color.WHITE);
        setLabel(team2Label,Color.BLACK,Color.WHITE);

        this.gamePlace=gamePlace;
        team1Score=0;
        team2Score=2;

        gameStartLabel=new JLabel("18:30");
        setLabel(gameStartLabel,Color.BLACK,Color.WHITE);
        gamePlaceLabel=new JLabel(gamePlace);
        setLabel(gamePlaceLabel,Color.BLACK,Color.WHITE);

        setTeamImage();
        setGameState();
        setScore();
        setGameButton();

        addComponent();
        setBackground(Color.WHITE);
    }

    private void addComponent() {
        add(gameStartLabel);
        add(gamePlaceLabel);

        add(team1Label);
        add(team1ImageLabel);
        add(team1ScoreLabel);

        add(gameStateLabel);

        add(team2ScoreLabel);
        add(team2Label);
        add(team2ImageLabel);

        add(gameButton);
        repaint();
    }

    private void setScore() {
        team1ScoreLabel=new JLabel();
        team2ScoreLabel=new JLabel();

        if(gameState.equals("경기 예정")) {
            team1Score=0;
            team2Score=0;
            setLabel(team1ScoreLabel,Color.BLACK,Color.WHITE);
            setLabel(team2ScoreLabel,Color.BLACK,Color.WHITE);
        }

        else if(gameState.equals("경기 중")) {
            team1Score=(int)(Math.random()*9);
            team2Score=(int)(Math.random()*9);
            setLabel(team1ScoreLabel,Color.BLACK,Color.WHITE);
            setLabel(team2ScoreLabel,Color.BLACK,Color.WHITE);
        }

        else { //(gameState=="경기 종료")
            team1Score=(int)(Math.random()*9);
            team2Score=(int)(Math.random()*9);
            if(team1Score>team2Score) {
                winTeam=team1;
                setLabel(team1ScoreLabel,Color.RED,Color.WHITE);
                setLabel(team2ScoreLabel,Color.BLACK,Color.WHITE);
            }
            else if(team1Score<team2Score) {
                winTeam=team2;
                setLabel(team2ScoreLabel,Color.RED,Color.WHITE);
                setLabel(team1ScoreLabel,Color.BLACK,Color.WHITE);
            }

            else {
                winTeam="없습니다. 오늘의 경기는 무승부입니다";
                setLabel(team1ScoreLabel,Color.BLACK,Color.WHITE);
                setLabel(team2ScoreLabel,Color.BLACK,Color.WHITE);
            }
        }

        team1ScoreLabel.setText(Integer.toString(team1Score));
        team2ScoreLabel.setText(Integer.toString(team2Score));
        repaint();
    }

    private void setTeamImage() {
        team1ImageIcon=new ImageIcon(getClass().getResource("/images/"+team1+".jpg"));
        team1Image=team1ImageIcon.getImage();
        team1Image=team1Image.getScaledInstance(90,90,Image.SCALE_SMOOTH);
        team1ImageIcon=new ImageIcon(team1Image);

        team1ImageLabel=new JLabel(team1ImageIcon);
        team1ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        team2ImageIcon=new ImageIcon(getClass().getResource("/images/"+team2+".jpg"));
        team2Image=team2ImageIcon.getImage();
        team2Image=team2Image.getScaledInstance(90,90,Image.SCALE_SMOOTH);
        team2ImageIcon=new ImageIcon(team2Image);

        team2ImageLabel=new JLabel(team2ImageIcon);
        team2ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        repaint();
    }

    private void setGameState() {
        now=Calendar.getInstance();
        hour=now.get(Calendar.HOUR_OF_DAY);
        min=now.get(Calendar.MINUTE);

        if(hour==18) {
            if(min>=30)
                gameState="경기 중";
            else
                gameState="경기 예정";
        }

        else if(hour>18 && hour<22)
            gameState="경기 중";
        else if(hour>=22 && hour<=23)
            gameState="경기 종료";
        else
            gameState="경기 예정";
        gameStateLabel=new JLabel(gameState);
        setLabel(gameStateLabel,Color.BLACK,Color.WHITE);
        repaint();
    }

    private void setGameButton() {
        gameButton=new JButton();
        if(gameState.equals("경기 중") || gameState.equals("경기 예정")){
            gameButton.setText(gamePlace+" 승리 예측하기");
        }
        else
            gameButton.setText(gamePlace+" 오늘의 승리 팀");
        repaint();
    }

    JButton getGameButton() {return gameButton;}
    String getWinTeam() {return winTeam;}
    String getGameState() {return gameState;}


    public void setLabel(JLabel label, Color fontColor, Color backgroundColor) {
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("맑은고딕", Font.BOLD, 12));
        label.setForeground(fontColor);
        label.setBackground(backgroundColor);
        label.setOpaque(true);
        repaint();
    }
}
