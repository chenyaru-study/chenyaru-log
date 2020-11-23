package src.main.java;

import src.main.utils.LinkedList;
import src.main.utils.TalkingClock;

import javax.swing.*;
import java.util.ArrayList;

/**
 * 《Java核心技术 第10卷》-内部类学习
 */
public class InnerClassMain {
    public static void main(String[] args) {
        innerClassTest();
    }

    public static void innerClassTest(){
        TalkingClock talkingClock = new TalkingClock(10000,true);
        //start()方法调用内部类TimePrinter监听事件，并通过TimePrinter的actionPerformed()方法访问TalkingClock的数据域beep=false
        talkingClock.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

        //创建内部类对象的方式
       // TalkingClock.TimerPrinter printerListener = talkingClock.new TimPrinter();//这样写有问题
    }

    /**
     * 利用内部类，创建数组列表，并传递给一个方法
     */
    public static void innerListTest(){
        //普通做法
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        invite(list);
        //匿名内部类做法
        invite(new ArrayList<String>(){{add("A");add("B");}});//内层{}是代码块
    }

    private static void invite(ArrayList<String> list) {
    }
}
