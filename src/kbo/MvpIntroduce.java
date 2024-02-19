package kbo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

class MvpIntroduce extends JPanel implements LabelSet {
    private int votes; //투표수를 담은 배열
    private double percent;
    private int percentForSlider; //슬라이더에 표시할 퍼센트, int형으로 변환
    private Player mvpPlayers; //mvp 투표를 위한 선수들을 담은 배열
    private String name,team,type;

    private ImageIcon imageIcon;
    private Image image;
    private JLabel imageLabel;
    private JPanel playerPanel; //선수 정보를 담은 패널
    private JLabel playerNameLabel;
    private JLabel playerTeamLabel;
    private JLabel playerTypeLabel;

    private JSlider percentSilder;
    private JLabel percentLabel;

    MvpIntroduce(String name, String team, String type){
        setLayout(new GridLayout(1,2,5,0));
        mvpPlayers=new Player(name,team,type);
        this.name=name;
        this.team=team;
        this.type=type;

        setImageLabel();
        setPlayerLabel();
        setBackground(Color.WHITE);
    }

    public void setLabel(JLabel label, Color fontColor, Color backgroundColor){
        label.setFont(new Font("맑은고딕", Font.BOLD, 12));
        label.setForeground(fontColor);
        label.setBackground(backgroundColor);
        label.setOpaque(true);
        repaint();
    }

    void setImageLabel() {
        removeAll();

        imageIcon=new ImageIcon("images/"+name+".jpg");
        image=imageIcon.getImage();
        image=image.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        imageIcon=new ImageIcon(image);

        imageLabel=new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel);
        repaint();
    }

    JLabel getImageLabel() {
        return imageLabel;
    }

    void setPlayerLabel() {
        playerNameLabel=new JLabel(name);
        setLabel(playerNameLabel,Color.BLUE,Color.WHITE);
        playerTeamLabel=new JLabel(team);
        setLabel(playerTeamLabel,Color.GREEN,Color.WHITE);
        playerTypeLabel=new JLabel(type);
        setLabel(playerTypeLabel,Color.BLACK,Color.WHITE);

        playerPanel=new JPanel();
        playerPanel.setLayout(new GridLayout(3,1,0,0));
        playerPanel.add(playerNameLabel);
        playerPanel.add(playerTeamLabel);
        playerPanel.add(playerTypeLabel);

        add(playerPanel);
        repaint();
    }

    void setPercentSilder() {
        removeAll();
        percentForSlider=(int)percent;

        percentSilder=new JSlider(JSlider.HORIZONTAL,0,100,percentForSlider);
        percentSilder.setPaintLabels(true);
        percentSilder.setPaintTicks(true);
        percentSilder.setPaintTrack(true);
        percentSilder.setEnabled(false);
        percentSilder.setMajorTickSpacing(30);

        percentLabel=new JLabel(name+": "+percent+"%");
        setLabel(percentLabel,Color.BLACK,Color.WHITE);

        add(percentSilder);
        add(percentLabel);
        repaint();
    }

    int getVotes() {return votes;}

    void setVotes() {
        votes++;
    }

    double getPercent() {return percent;}

    void setPercent(int totalVotes) {
        percent=((double)votes/totalVotes)*100;
        percent=Math.round(percent * 100) / 100.0;
        repaint();
    }

    String getPlayerName() {return name;}
    String getTeam() {return team;}
    String getType() {return type;}

    MvpIntroduce getPlayers() {return this;}
}