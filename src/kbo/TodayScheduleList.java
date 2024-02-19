package kbo;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

class TodayScheduleList extends JPanel{
    private TodaySchedule[] todayScheduleList;

    TodayScheduleList(){
        setLayout(new GridLayout(5,1,0,0));
        setList();
    }

    private void setList() {
        todayScheduleList=new TodaySchedule[5];
        todayScheduleList[0]=new TodaySchedule("두산베어스","기아타이거즈","광주");
        todayScheduleList[1]=new TodaySchedule("한화이글스","lg트윈스","잠실");
        todayScheduleList[2]=new TodaySchedule("kt위즈","삼성라이온즈","대구");
        todayScheduleList[3]=new TodaySchedule("롯데자이언츠","nc다이노스","창원");
        todayScheduleList[4]=new TodaySchedule("키움히어로즈","ssg랜더스","인천");

        add(todayScheduleList[0]);
        add(todayScheduleList[1]);
        add(todayScheduleList[2]);
        add(todayScheduleList[3]);
        add(todayScheduleList[4]);
        repaint();
    }

    TodaySchedule[] getTodayScheduleList() {return todayScheduleList;}

    String getGameState() {return todayScheduleList[0].getGameState();}
}