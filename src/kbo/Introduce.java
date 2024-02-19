package kbo;

import java.awt.*;

import javax.swing.*;

class Introduce extends JLabel implements LabelSet{
    private ImageIcon icon = new ImageIcon("images/panel1.jpg");
    private Image img = icon.getImage();

    private FlickerlingLabel introduce;
    private JLabel introduceByKorean;

    public Introduce() {
        setLayout(new FlowLayout());

        introduce=new FlickerlingLabel("KBO platform !",500);
        setLabel(introduce,Color.BLACK,Color.YELLOW);

        introduceByKorean=new JLabel("우리는 크보에 죽고 크보에 산다!");
        setLabel(introduceByKorean,Color.MAGENTA,Color.YELLOW);

        add(introduce);
        add(introduceByKorean);

        repaint();
    }

    public void setLabel(JLabel label, Color fontColor, Color backgroundColor) {
        label.setFont(new Font("맑은고딕", Font.BOLD, 20));
        label.setForeground(fontColor);
        label.setBackground(backgroundColor);
        label.setOpaque(true);
    }
}