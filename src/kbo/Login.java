package kbo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class Login extends JLabel implements LabelSet{
    private JLabel userLabel,passwordLabel;
    private JTextField userField;
    private JPasswordField passwordField;

    Login(){
        setLayout(new GridLayout(2,2,30,30));
        setLoginLabel();
        setLoginField();
        add(userLabel);
        add(userField);
        add(passwordLabel);
        add(passwordField);

    }

    public void setLabel(JLabel label, Color fontColor, Color backgroundColor) {
       label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("맑은고딕", Font.BOLD, 15));
        label.setForeground(fontColor);
        //	label.setBackground(backgroundColor);
        label.setOpaque(true);
        label.setVisible(true);
        repaint();
    }

    private void setLoginLabel() {
        userLabel=new JLabel("사용자 닉네임 입력 ");
        passwordLabel=new JLabel("비밀번호 입력 ");

        setLabel(userLabel,Color.BLACK,Color.LIGHT_GRAY);
        setLabel(passwordLabel,Color.BLACK,Color.LIGHT_GRAY);
        repaint();
    }

    private void setLoginField() {
        userField=new JTextField(5);
        passwordField=new JPasswordField(5);

        userField.setFont(new Font("맑은 고딕",Font.PLAIN,15));
        passwordField.setFont(new Font("맑은 고딕",Font.PLAIN,15));
        repaint();
    }

    JTextField getUserField() {	return userField;}

    JTextField getPassField() { return passwordField;}
}
