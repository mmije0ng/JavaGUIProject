package kbo;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

class KBOProject extends JFrame implements ActionListener, Runnable{
    private JTabbedPane pane;
    private KboMainPanel mainPanel;
    private SearchTeamPanel searchTeamPanel;
    private MyKboTeamPanel myKboTeamPanel;
    private boolean isMain;

    KBOProject() {
        setTitle("KBO service");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Container container=getContentPane();

        mainPanel=new KboMainPanel();
        searchTeamPanel=new SearchTeamPanel();
        myKboTeamPanel=new MyKboTeamPanel();

        pane=createTabbedPane();
        container.add(pane);

        setFrameChange();

        container.setFocusable(true);
        container.requestFocus();

        setSize(1500,900);
        setLocation(100,70);
        setVisible(true);

        Thread thread=new Thread(this);
        thread.start();
    }

    private JTabbedPane createTabbedPane() {
        JTabbedPane pane=new JTabbedPane();
        pane.addTab("KBO service",mainPanel);

        pane.addTab("구단 살펴보기",searchTeamPanel);
        pane.addTab("나의 KBO 팀 찾기",myKboTeamPanel);
        repaint();
        return pane;
    }

    private void setFrameChange() {
        JButton teamSearchButton=mainPanel.getTeamSearchButton();
        teamSearchButton.addActionListener(this);
        JButton myKboTeamButton=mainPanel.getMyKboTeamButton();
        myKboTeamButton.addActionListener(this);

        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        String typed = e.getActionCommand();
        if(typed.equals("구단 살펴보기")) {
            pane.setSelectedIndex(1);
        }
        else if(typed.equals("나의 KBO 팀 찾기"))
            pane.setSelectedIndex(2);
        repaint();
    }

    @Override
    synchronized public void run() {
        //로그인했는지 안 했는지를 계속 확인하기 위한 스레드
        while(true){
            isMain= mainPanel.getIsMain();

            if(!isMain){ //로그인하지 않았을 때 tab1,2 비활성화
                pane.setEnabledAt(1, false);
                pane.setEnabledAt(2, false);
            }
            else{
                pane.setEnabledAt(1, true);
                pane.setEnabledAt(2, true);
            }

            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                return;
            }
        }
    }
}