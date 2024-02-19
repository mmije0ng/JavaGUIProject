package kbo;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

class MyKboTeamImage {
   private KboTeamNames teamName;
   private ImageIcon[] imageIcons;
   private Image[] images;
   private JLabel[] teamImageLabels;
   private Point[] points;
   private int size;

    private static final int WIDTH=1400;
    private static final int HEIGHT=800;

    MyKboTeamImage(){
 //       setLayout(null);
        size=10;
        setTeamNames();
        setMyKboTeamImageLabels();
        setPoints();
    }

    private void setTeamNames(){
        teamName=new KboTeamNames();
        teamName.setTeamNames();
    }

    private void setMyKboTeamImageLabels(){
      imageIcons=new ImageIcon[size];
      images=new Image[size];
      teamImageLabels=new JLabel[size];

        for(int i=0;i<size;i++){
            imageIcons[i]=new ImageIcon("images/"+teamName.getTeamNameByIndex(i)+".jpg");
            images[i]= imageIcons[i].getImage();
            images[i]= images[i].getScaledInstance(100,100,Image.SCALE_SMOOTH);
            imageIcons[i]=new ImageIcon(images[i]);

            teamImageLabels[i]=new JLabel(imageIcons[i]);
        }
    }

    void setPoints(){
        points=new Point[size];
        int[] leftX={0,50};
        int[] rightX={1340,1390};
        int y=50;

        for(int i=0;i<size;i++){
            int x;
            if(i<5){
                if(i%2==0)
                  x=leftX[0];
                else
                    x=leftX[1];
            }

            else{
                if(i%2==0)
                    x=rightX[0];
                else
                    x=rightX[1];
            }
            if(i==5)
                y=150;
            else
                y+=100;
            points[i]=new Point(x,y);
        }
    }

    JLabel[] getTeamImageLabels(){return teamImageLabels;}
    Point[] getPoints(){return points;}
}
