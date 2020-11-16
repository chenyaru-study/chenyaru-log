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
        ActionListener timePrinter = new TimePrinter();//监听事件
        Timer timer = new Timer(internal,timePrinter);//定时器
        timer.start();//启动定时器

    }

    /**
     * 内部类
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
     * 局部内部类(只在声明内部类的方法中使用)
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
     * 匿名内部类【当局部内部类只是用来创建一个对象时，可以省略局部内部类的类名声明】
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
        Timer timer = new Timer(internal,listener);//internal,beep变量需要是final类型的
        timer.start();
    }
}
