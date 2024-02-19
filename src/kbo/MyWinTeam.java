package kbo;

import javax.swing.JLabel;
import javax.swing.JPanel;

class MyWinTeam extends JPanel {
    private JLabel winTeamLabel;
    private String myWinTeam, gamePlace,user;

    MyWinTeam(String myWinTeam,String gamePlace, String user){
        winTeamLabel=new JLabel();
        this.myWinTeam=myWinTeam;
        this.gamePlace=gamePlace;
        this.user=user;

        setWinTeamLabel();
        add(winTeamLabel);
        repaint();
    }

    private void setWinTeamLabel() {
        winTeamLabel.setText(user+"님의 "+gamePlace+"구장 승리 예측 팀은 "+myWinTeam+"입니다.");
        repaint();
    }

    JLabel getWinTeamLabel() {return winTeamLabel;}
}