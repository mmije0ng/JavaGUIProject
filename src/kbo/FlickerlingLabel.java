package kbo;

import java.awt.Color;

import javax.swing.JLabel;

class FlickerlingLabel extends JLabel implements Runnable {
    private long delay;
    FlickerlingLabel(String text, long dealy){
        super(text);
        this.delay=delay;
        setOpaque(true);

        Thread th=new Thread(this);
        th.start();
    }

    synchronized void flickering() {
        int n=0;
        while(true) {
            if(n==0) {
                setBackground(Color.YELLOW);
                n=1;
            }
            else {
                setBackground(Color.GREEN);
                n=0;
            }

            try {
                Thread.sleep(delay);
                //	wait();
            }
            catch(InterruptedException e) {
                return;
            }

            //	notify();
        }
    }

    @Override
    public void run() {
        flickering();
    }
}
