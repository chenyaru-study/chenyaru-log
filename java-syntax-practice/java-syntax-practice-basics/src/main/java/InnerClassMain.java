package src.main.java;

import src.main.utils.LinkedList;
import src.main.utils.TalkingClock;

import javax.swing.*;
import java.util.ArrayList;

/**
 * ��Java���ļ��� ��10��-�ڲ���ѧϰ
 */
public class InnerClassMain {
    public static void main(String[] args) {
        innerClassTest();
    }

    public static void innerClassTest(){
        TalkingClock talkingClock = new TalkingClock(10000,true);
        //start()���������ڲ���TimePrinter�����¼�����ͨ��TimePrinter��actionPerformed()��������TalkingClock��������beep=false
        talkingClock.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

        //�����ڲ������ķ�ʽ
       // TalkingClock.TimerPrinter printerListener = talkingClock.new TimPrinter();//����д������
    }

    /**
     * �����ڲ��࣬���������б������ݸ�һ������
     */
    public static void innerListTest(){
        //��ͨ����
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        invite(list);
        //�����ڲ�������
        invite(new ArrayList<String>(){{add("A");add("B");}});//�ڲ�{}�Ǵ����
    }

    private static void invite(ArrayList<String> list) {
    }
}
