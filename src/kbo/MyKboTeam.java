package kbo;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

class MyKboTeam extends JPanel implements LabelSet{
    private ImageIcon imageIcon;
    private Image image;
    private JLabel imageLabel,nameLabel, introduceLabel;
    private String name;
    private JButton resetButton; //다시 시작하기

    private ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/images/panel3.jpg"));
    private Image backgroundImg = backgroundIcon.getImage();
    private Vector<Point> ballVector;

    MyKboTeam(String name, Vector<Point> ballVector){
        setLayout(null);
        this.name=name;
        this.ballVector=ballVector;

        setImageLabel();
        setNameLabel();
        setIntroduceLabel();
        setResetButton();
    }

    private void setImageLabel() {
        imageIcon=new ImageIcon(getClass().getResource("/images/"+name+".jpg"));
        image=imageIcon.getImage();
        image=image.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        imageIcon=new ImageIcon(image);

        imageLabel=new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setSize(200,200);
        imageLabel.setLocation(650,0);
        add(imageLabel);
        repaint();
    }

    private void setNameLabel(){
        nameLabel=new JLabel(name);
        nameLabel.setSize(100,50);
        nameLabel.setLocation(700,300);
        setLabel(nameLabel,Color.MAGENTA,Color.WHITE);
    }

    private void setIntroduceLabel(){
        introduceLabel=new JLabel();
        introduceLabel.setText("나와 맞는 KBO팀은 "+name+"입니다!");
        introduceLabel.setSize(300,50);
        introduceLabel.setLocation(600,400);
        setLabel(introduceLabel,Color.BLACK,Color.WHITE);
    }

    private void setResetButton(){
        resetButton=new JButton("다시하기");
        resetButton.setSize(100,50);
        resetButton.setLocation(700,600);
        resetButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
        resetButton.setHorizontalAlignment(JButton.CENTER);
        resetButton.setOpaque(true);
        add(resetButton);
    }

    JButton getResetButton(){return resetButton;}

    @Override
    public void setLabel(JLabel label, Color fontColor, Color backgroundColor) {
        label.setFont(new Font("맑은고딕", Font.BOLD, 15));
        label.setForeground(fontColor);
        label.setBackground(backgroundColor);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundIcon.getImage(), 0, 0, this);

        g.setColor(Color.MAGENTA);
        for (int i = 0; i < ballVector.size(); i++) {
            Point p = ballVector.elementAt(i);
            if(i%2==0)
                g.fillOval(p.x, p.y, 10, 10);
            else
                g.drawOval(p.x, p.y, 10, 10);
        }
    }
}
