package src.main.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TalkingClock {
    private int internal;
    private final boolean beep;
    public TalkingClock(int internal, boolean beep){
        this.internal = internal;
        this.beep = beep;
    }
    public void start(){
        ActionListener timePrinter = new TimePrinter();//�����¼�
        Timer timer = new Timer(internal,timePrinter);//��ʱ��
        timer.start();//������ʱ��

    }

    /**
     * �ڲ���
     */
    public class TimPrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is" + new Date());
           // System.out.println("beepFlag = " + beep);
         ///   System.out.println("beepFlag = ");
            if(TalkingClock.this.beep) {
                System.out.println("beepFlag = " + TalkingClock.this.beep);
             //   Toolkit.getDefaultToolkit().beep();
            } else {
             //   System.out.println("beepFlag = " + beep);
            }
        }
    }

    /**
     * �ֲ��ڲ���(ֻ�������ڲ���ķ�����ʹ��)
     */
    public void startA(){
        class TimerPrinterA implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is" + new Date());
                if(TalkingClock.this.beep) {
                    System.out.println("beepFlag = " + TalkingClock.this.beep);
                    //   Toolkit.getDefaultToolkit().beep();
                }
            }
        }
        ActionListener listener = new TimerPrinterA();
        Timer timer = new Timer(internal,listener);
        timer.start();
    }

    /**
     * �����ڲ��ࡾ���ֲ��ڲ���ֻ����������һ������ʱ������ʡ�Ծֲ��ڲ��������������
     */
    public void startB(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is" + new Date());
                if(TalkingClock.this.beep) {
                    System.out.println("beepFlag = " + TalkingClock.this.beep);
                    //   Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        Timer timer = new Timer(internal,listener);//internal,beep������Ҫ��final���͵�
        timer.start();
    }
}
