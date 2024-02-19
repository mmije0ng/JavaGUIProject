package kbo;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class ClockThread extends JPanel implements Runnable, LabelSet {
    private Calendar now;
    private int year,month,day,hour,min,sec;
    private StringBuilder clock;
    private JLabel clockLabel;
    ClockThread(){
        setLayout(null);

        clockLabel=new JLabel();
        clockLabel.setSize(250,30);
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        now=Calendar.getInstance();
        setClock();
        add(clockLabel);

        Thread th=new Thread(this);
        th.start();
    }

    public void setLabel(JLabel label, Color fontColor, Color backgroundColor) {
        label.setFont(new Font("맑은고딕", Font.BOLD, 15));
        label.setForeground(fontColor);
        label.setBackground(backgroundColor);
        label.setOpaque(true);
    }

    private void setClock() {
        now=Calendar.getInstance();
        year=now.get(Calendar.YEAR);
        month=now.get(Calendar.MONTH)+1;
        day=now.get(Calendar.DATE);
        hour=now.get(Calendar.HOUR_OF_DAY);
        if(hour==0)
            hour=12;
        min=now.get(Calendar.MINUTE);
        sec=now.get(Calendar.SECOND);

        clock=new StringBuilder("Time ");
        clock.append(year).append("-").append(month).append("-").append(day);
        clock.append(" ").append(hour).append(":").append(min).append(":").append(sec);

        clockLabel.setText(clock.toString());
        setLabel(clockLabel,Color.BLACK,Color.YELLOW);
    }

    synchronized private void setClockTimer() {
        while(true) {
            setClock();
            try {
                Thread.sleep(500);
            }
            catch(InterruptedException e) {
                return;
            }
        }
    }
    @Override
    public void run() {
        setClockTimer();
    }
}
