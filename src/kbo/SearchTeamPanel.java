package kbo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

class SearchTeamPanel extends JLabel implements ActionListener{
    private ImageIcon icon = new ImageIcon("images/panel2.jpg");
    private Image img = icon.getImage();

    private SearchTeam[] searchTeam;
    private int size;
    private TeamIntroduce teamIntroduce;

    SearchTeamPanel(){
        size=10;
        searchTeam=new SearchTeam[size];

        setSearchTeam();

        // KeyStroke를 사용하여 Backspace 키 이벤트를 정의
        KeyStroke backspaceKey = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0);

        // InputMap에 키 이벤트와 연결된 키 맵핑 추가
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(backspaceKey, "backspaceAction");

        // ActionMap에 키 맵핑과 연결된 액션 추가
        getActionMap().put("backspaceAction", new BackspaceAction());

        setBackground(Color.WHITE);
    }

    private void setSearchTeam() {
        setLayout(new GridLayout(size,1,0,20));

        searchTeam[0]=new SearchTeam("기아타이거즈","광주챔피언스필드",0);
        searchTeam[1]=new SearchTeam("두산베어스","잠실구장",1);
        searchTeam[2]=new SearchTeam("nc다이노스","창원NC파크",2);
        searchTeam[3]=new SearchTeam("롯데자이언츠","부산사직구장",3);
        searchTeam[4]=new SearchTeam("삼성라이온즈","대구삼성라이온즈파크",4);
        searchTeam[5]=new SearchTeam("키움히어로즈","고척스카이돔",5);
        searchTeam[6]=new SearchTeam("ssg랜더스","인천SSG랜더스필드",6);
        searchTeam[7]=new SearchTeam("lg트윈스","잠실구장",7);
        searchTeam[8]=new SearchTeam("kt위즈","kt위즈파크",8);
        searchTeam[9]=new SearchTeam("한화이글스","대전한밭종합운동장야구장",9);

        for(int i=0;i<size;i++) {
            add(searchTeam[i]);
            searchTeam[i].getSearchTeamButton().addActionListener(this);
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(icon.getImage(), 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton target=(JButton)e.getSource();

        for(int i=0;i<size;i++) {
            JButton button=searchTeam[i].getSearchTeamButton();
            if(button.getText().equals(target.getText())) { //구단 살펴보기 버튼
                removeAll();
                TeamIntroduceCollection collection=new TeamIntroduceCollection(i);
                teamIntroduce=new TeamIntroduce(searchTeam[i].getTeamName(),searchTeam[i].getPlace(),collection.getIntroduce());
                teamIntroduce.getBackButton().addActionListener(this);

           //     setLayout(new FlowLayout());
                setLayout(null);
                teamIntroduce.setSize(this.getWidth(),this.getHeight());
                teamIntroduce.setLocation(0,0);
                add(teamIntroduce);
                revalidate();
                repaint();
                return;
            }
        }

        //뒤로가기 버튼
        if(teamIntroduce.getBackButton()==target) {
            removeAll();
            setSearchTeam();
            revalidate();
            repaint();
        }
    }

    // Backspace 키 이벤트를 처리하는 Action 클래스
    private class BackspaceAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            removeAll();
            setSearchTeam();
            revalidate();
            repaint();
        }
    }
}