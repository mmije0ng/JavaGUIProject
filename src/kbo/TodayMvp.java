package kbo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

class TodayMvp extends JPanel implements Runnable {
    private ButtonGroup group;
    private JRadioButton[] voteTodayMvpButton;

    private int size;
    private int totalVotes;
    private MvpIntroduce[] mvpPlayersPanel;

    private JButton voteButton; //투표하기 버튼
    private JButton voteBackButton; //투표 또 하기 버튼

    boolean isVoteTurn;

    TodayMvp(){
        setLayout(new GridLayout(6,2,25,5));

        size=5;
        totalVotes=0;
        isVoteTurn=true;
        setPlayer();
        setVotePanel();

        voteButton=new JButton("mvp 투표");
        setButtons(voteButton);

        voteBackButton=new JButton("투표 화면으로 돌아가기");
        setButtons(voteBackButton);

        add(voteButton);
        add(voteBackButton);

        Thread thread=new Thread(this);
        thread.start();
    }

    void setPlayer() {
        mvpPlayersPanel=new MvpIntroduce[5];
        mvpPlayersPanel[0]=new MvpIntroduce("양현종","기아타이거즈","투수");
        mvpPlayersPanel[1]=new MvpIntroduce("고영표","kt위즈","투수");
        mvpPlayersPanel[2]=new MvpIntroduce("류지혁","삼성히어로즈","내야수");
        mvpPlayersPanel[3]=new MvpIntroduce("박건우","nc다이노스","외야수");
        mvpPlayersPanel[4]=new MvpIntroduce("홍건희","두산베어스","투수");
    }

    void setVotePanel(){
        group=new ButtonGroup();
        voteTodayMvpButton=new JRadioButton[size];

        for(int i=0;i<size;i++) {
            mvpPlayersPanel[i].setImageLabel();
            mvpPlayersPanel[i].setPlayerLabel();
            add(mvpPlayersPanel[i]);

            voteTodayMvpButton[i]=new JRadioButton(mvpPlayersPanel[i].getPlayerName());
            group.add(voteTodayMvpButton[i]);
            add(voteTodayMvpButton[i]);
            voteTodayMvpButton[i].setHorizontalAlignment(SwingConstants.CENTER);
            voteTodayMvpButton[i].setFont(new Font("맑은고딕", Font.BOLD, 13));
            voteTodayMvpButton[i].setBackground(Color.WHITE);
        }
        isVoteTurn=true;
    }

    void setPercentPanel(){
        for(int i=0;i<size;i++) {
            mvpPlayersPanel[i].setPercent(totalVotes);
            mvpPlayersPanel[i].setPercentSilder();
            add(mvpPlayersPanel[i].getImageLabel());

            add(mvpPlayersPanel[i]);
        }

        isVoteTurn=false;
    }

    void setButtons(JButton button) {
        button.setFont(new Font("맑은 고딕",Font.BOLD,13));
        button.setForeground(Color.MAGENTA);
    }

    void addButtons() {
        voteButton=new JButton("mvp 투표");
        setButtons(voteButton);

        voteBackButton=new JButton("투표 화면으로 돌아가기");
        setButtons(voteBackButton);

        add(voteButton);
        add(voteBackButton);
    }

    void setPlayerVotes(int totalVotes) {
        setTotalVotes(totalVotes);

        for(int i=0;i<size;i++) {
            if(voteTodayMvpButton[i].isSelected()) {
                mvpPlayersPanel[i].setVotes();
                break;
            }
        }
    }

    void setTotalVotes(int totalVotes) {
        this.totalVotes=totalVotes;
    }

    JRadioButton[] getMVPButton(){return voteTodayMvpButton;}

    JButton getVoteButton() {
        return voteButton;
    }

    JButton getVoteBackButton() {
        return voteBackButton;
    }

    @Override
    synchronized public void run() {
        while(true){
            boolean isChecked=false;
            for(int i=0;i<voteTodayMvpButton.length;i++){
                if(voteTodayMvpButton[i].isSelected()){
                    isChecked=true;
                    break;
                }
            }
            if(!isChecked) //mvp 후보 선택X
                voteButton.setEnabled(false);
            else //mvp 후보를 선택 완료
                voteButton.setEnabled(true);

            if(isVoteTurn){ //mvp투표시
                voteBackButton.setEnabled(false); //돌아가기 버튼 비활성화
            }

            else{ //mvp투표 결과시
                voteButton.setEnabled(false); //투표 버튼 비활성화
                voteBackButton.setEnabled(true); //돌아가기 버튼 활성화
            }

            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}