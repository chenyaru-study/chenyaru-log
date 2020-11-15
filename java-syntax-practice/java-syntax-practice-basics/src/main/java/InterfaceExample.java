package src.main.java;

import src.main.service.StringFunc;
import src.main.utils.LengthComparator;
import src.main.utils.MyStringOps;
import src.main.utils.TimePrinter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.function.BiFunction;

public class InterfaceExample {
    public static void main(String[] args) {
       // timerTest();
        // sortTest();
        //lambdaTest();
       // InterfaceExample interfaceExample = new InterfaceExample();
       // interfaceExample.countDown(1,10000);
        String temp = null;
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add(temp);
        System.out.println("lengthBefore = " + list.size());
        list.removeIf(e -> e == null);//Predicate����ʽ�ӿ�
        System.out.println("lengthAfter = " + list.size());
        String strReversalBefore = "str";
        System.out.println("strReversalBefore = " + strReversalBefore);

        //lambda����鷽ʽ��ת�ַ���
        String strReversalAfter = stringOp(str -> {
            String result = "";
            for(int i = str.length() -1; i >= 0; i--){
                result += str.charAt(i);
            }
            return result;
        },strReversalBefore);
        System.out.println("lambda����鷽ʽ-strReveresalAfter " + strReversalAfter);
        //lambda�������÷�ʽ��ת�ַ���
        strReversalAfter = stringOp(MyStringOps:: strReverse,strReversalBefore);
        System.out.println("lambda�������÷�ʽ-strReversalAfter" + Arrays.deepToString(args));
    }

    /**
     * Java API��׼�ⶨʱ�������
     */
    public static void timerTest() {
        ActionListener actionListener = new TimePrinter();//�������������󣬼������¼���������(�����ǰ�¼��ͼ��������������)
        Timer timer = new Timer(10000,actionListener);//������ʱ��������ʱ��(ÿ10��)����������(actionListener)
        timer.start();//����������

        //��ֹ��ʱ����
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    /**
     * Java API��׼��sort���������������
     */
    public static void sortTest(){
        Integer[] prototype = {1,2,3};
        String[] objArry = {"Peters","Paull","Mary"};
        Arrays.sort(objArry,new LengthComparator());
        System.out.println("objArry=" + Arrays.toString(objArry));
    }

    /**
     * Java Lambda���ʽ��(����1������2) -> {�����/���ʽ��}
     */
    public static void lambdaTest(){
        String[] planets = new String[] {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets,(first,second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        Timer timer = new Timer(10000,event -> System.out.println("The Time is" + new Date()));
        timer.start();

        //��ֹ��ʱ����
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

        BiFunction<String,String,Integer> result = (first,second) -> {return first.length() - second.length();};

    }

    /**
     * Java-lambda���ʽ�� () ->{}
     * @param start
     * @param delay
     */
    public void countDown(int start, int delay){
       // start--;
        ActionListener actionListener = (event) -> {
            //start--;//����ʱ�쳣/δ����쳣
            //System.out.println("start = " + start);//��lambda���ʽ�����õı������ڴ�����ⲿ�ǲ������ı�ģ�����ᱨδ����쳣��ֻ���ǲ��ɸı�ı���
            System.out.println("this = " + this.toString());
        };
        new Timer(delay,actionListener).start();

        //��ֹ��ʱ����
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    /**
     *
     * @param str
     * @param s
     * @return
     */
    public static String stringOp(StringFunc str, String s){
        return str.func(s);
    }
}
