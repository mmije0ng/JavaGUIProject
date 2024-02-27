package kbo;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class SearchTeam extends JLabel implements LabelSet {
    private ImageIcon imageIcon;
    private Image image;
    private int num;
    private String name,place;
    private JLabel imageLabel,nameLabel;
    private JButton searchTeamButton;

    SearchTeam(String name,String place,int num){
        setLayout(new GridLayout(1,3,490,0));
        this.name=name;
        this.place=place;
        this.num=num;
        setTeamImageLabel();
        setNameLabel();
        setSearchTeamButton();
    }

    @Override
    public void setLabel(JLabel label, Color fontColor, Color backgroundColor) {
        label.setFont(new Font("맑은고딕", Font.BOLD, 15));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(fontColor);
        label.setBackground(backgroundColor);
        label.setOpaque(true);
        repaint();
    }

    private void setTeamImageLabel() {
        imageIcon=new ImageIcon(getClass().getResource("/images/"+name+".jpg"));
        image=imageIcon.getImage();
        image=image.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        imageIcon=new ImageIcon(image);

        imageLabel=new JLabel(imageIcon);
        add(imageLabel);
        repaint();
    }

    private void setNameLabel() {
        nameLabel=new JLabel(name);
        setLabel(nameLabel,Color.BLACK,Color.WHITE);
        add(nameLabel);
        repaint();
    }

    private void setSearchTeamButton() {
        searchTeamButton=new JButton(name+" 보기");
        add(searchTeamButton);
        repaint();
    }

    int getNum() {return num;}
    String getTeamName() {return name;}
    String getPlace() {return place;}
    JButton getSearchTeamButton() {return searchTeamButton;}
}