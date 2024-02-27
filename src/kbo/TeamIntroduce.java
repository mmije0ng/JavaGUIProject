package kbo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TeamIntroduce extends JPanel implements LabelSet{
    private ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/images/panel2.jpg"));
    private Image backgroundImg = backgroundIcon.getImage();

    private String[] temp;
    private String name,place,introduce;
    private ImageIcon imageIcon;
    private Image image;
    private JLabel imageLabel,nameLabel, placeLabel;
    private JLabel[] introduceLabel;
    private JButton backButton;

    TeamIntroduce(String name,String place,String introduce){
        temp=introduce.split("\n");
        int size=temp.length;
     //   setLayout(new GridLayout(4+size,1,0,20));
        setLayout(null);
        this.name=name;
        this.place="홈구장: "+place;
        this.introduce=introduce;

        setImageLabel();
        setNamePlaceLabel(nameLabel,name,600,150);
        setNamePlaceLabel(placeLabel,this.place,600,300);
        setIntroduceLabel();
        setBackButton();

        setBackground(Color.WHITE);
    }

    private void setImageLabel() {
        imageIcon=new ImageIcon(getClass().getResource("/images/"+name+".jpg"));
        image=imageIcon.getImage();
        image=image.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        imageIcon=new ImageIcon(image);

        imageLabel=new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
		imageLabel.setSize(100,100);
		imageLabel.setLocation(700,0);
        add(imageLabel);
        repaint();
    }

    private void setNamePlaceLabel(JLabel label, String labelText,int x, int y) {
        label=new JLabel(labelText);
		label.setSize(300,50);
		label.setLocation(x, y);
        setLabel(label,Color.BLACK,Color.WHITE);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
        repaint();
    }

    private void setIntroduceLabel() {
        introduceLabel=new JLabel[temp.length];
        int x=170;
        int y=400;

        for(int i=0;i<temp.length;i++) {
            introduceLabel[i]=new JLabel(temp[i]);
            setLabel(introduceLabel[i],Color.BLACK,Color.WHITE);
            introduceLabel[i].setHorizontalAlignment(JLabel.CENTER);

            introduceLabel[i].setSize(1150,50);
            introduceLabel[i].setLocation(x,y);
            y+=50;

            add(introduceLabel[i]);
        }
        repaint();
    }

    private void setBackButton() {
        backButton=new JButton("뒤로 가기(클릭 또는 Backspace 키 입력)");
        backButton.setHorizontalAlignment(JButton.CENTER);
        backButton.setSize(280,30);
        backButton.setLocation(0,0);
        add(backButton);
        repaint();
    }

    @Override
    public void setLabel(JLabel label, Color fontColor, Color backgroundColor) {
        label.setFont(new Font("맑은고딕", Font.BOLD, 18));
        label.setForeground(fontColor);
        label.setBackground(backgroundColor);
        label.setOpaque(true);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundIcon.getImage(), 0, 0, this);
    }

    JButton getBackButton() {return backButton;}
}
