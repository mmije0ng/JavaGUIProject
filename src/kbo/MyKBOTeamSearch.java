package kbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

class MyKBOTeamSearch extends JPanel implements LabelSet {
    private ImageIcon icon = new ImageIcon("images/panel3.jpg");
    private Image img = icon.getImage();

    private int num,questionIndex,answerIndex; //질문 num, question 인덱스, answer 인덱스
    private JLabel questionLabel;
    private JButton[] answerButton;

    private Question question;
    private Answer answer;
    private Vector<Point> ballVector;

    MyKBOTeamSearch(int num, int questionIndex, Vector<Point> ballVector){
        setLayout(null);

        this.num=num;
        this.questionIndex=questionIndex;
        this.ballVector=ballVector;
        setQuestionLabel();
        setAnswerButton();

        setVisible(true);
        setOpaque(true);

        repaint();
    }

    public void setQuestionLabel() {
        question=new Question();
        String myQuestion=question.getQuestion(num,questionIndex);
        questionLabel=new JLabel(myQuestion);
        questionLabel.setSize(600,50);
        questionLabel.setLocation(450,60);

        setLabel( questionLabel, Color.BLACK,Color.WHITE);
        add(questionLabel);

        repaint();
    }

    public void setAnswerButton() {
        answer=new Answer();
        String myAnswer=answer.getAnswer(num,questionIndex);

        if( (num==2 &&questionIndex==1) || (num==2 &&questionIndex==3) ){
            answerButton=new JButton[3];
            if(questionIndex==1){
                answerButton[0]=new JButton(answer.getAnswer(num,2));
                answerButton[1]=new JButton(answer.getAnswer(num,3));
                answerButton[2]=new JButton(answer.getAnswer(num,4));
            }

            else{
                answerButton[0]=new JButton(answer.getAnswer(num,7));
                answerButton[1]=new JButton(answer.getAnswer(num,8));
                answerButton[2]=new JButton(answer.getAnswer(num,9));
            }

            int y=300;
            for(int i=0;i<3;i++){
                answerButton[i].setSize(450,50);
                answerButton[i].setLocation(530,y);
                add(answerButton[i]);
                y+=100;
            }
            setButton(answerButton[0],Color.BLACK,Color.YELLOW);
            setButton(answerButton[1],Color.BLACK,Color.PINK);
            setButton(answerButton[2],Color.BLACK,Color.MAGENTA);
        }

        else {
            answerButton=new JButton[2];
            if(num==0){
                answerButton[0]=new JButton(answer.getAnswer(num,0));
                answerButton[1]=new JButton(answer.getAnswer(num,1));
            }

            else if(num==1){
                if(questionIndex==0){
                    answerButton[0]=new JButton(answer.getAnswer(num,0));
                    answerButton[1]=new JButton(answer.getAnswer(num,1));
                }

                else{
                    answerButton[0]=new JButton(answer.getAnswer(num,2));
                    answerButton[1]=new JButton(answer.getAnswer(num,3));
                }
            }

            else{
                if(questionIndex==0){
                    answerButton[0]=new JButton(answer.getAnswer(num,0));
                    answerButton[1]=new JButton(answer.getAnswer(num,1));
                }

                else{
                    answerButton[0]=new JButton(answer.getAnswer(num,5));
                    answerButton[1]=new JButton(answer.getAnswer(num,6));
                }
            }

            int y=300;
            for(int i=0;i<2;i++){
                answerButton[i].setSize(450,50);
                answerButton[i].setLocation(520,y);
                add(answerButton[i]);
                y+=100;
            }

            setButton(answerButton[0],Color.BLACK,Color.YELLOW);
            setButton(answerButton[1],Color.BLACK,Color.PINK);
        }

        repaint();
    }

    JButton[] getAnswerButton(){return answerButton;}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(icon.getImage(), 0, 0, this);

        g.setColor(Color.WHITE);
        for (int i = 0; i < ballVector.size(); i++) {
            Point p = ballVector.elementAt(i);
            if(i%2==0)
                g.fillOval(p.x, p.y, 10, 10);
            else
                g.drawOval(p.x, p.y, 10, 10);
        }
    }

    @Override
    public void setLabel(JLabel label, Color fontColor, Color backgroundColor) {
        label.setFont(new Font("맑은고딕", Font.BOLD, 20));
        label.setForeground(fontColor);
        label.setBackground(backgroundColor);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        repaint();
    }

    private void setButton(JButton button, Color fontColor, Color backgroundColor) {
        button.setFont(new Font("맑은고딕", Font.BOLD, 20));
        button.setForeground(fontColor);
        button.setBackground(backgroundColor);
        button.setOpaque(true);
        button.setHorizontalAlignment(JLabel.CENTER);
        repaint();
    }
}
