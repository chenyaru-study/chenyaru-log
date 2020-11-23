package src.main.java;

import src.main.dto.MyClass;
import src.main.service.StringFunc;
import src.main.utils.LengthComparator;
import src.main.utils.MyStringOps;
import src.main.utils.TimePrinter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.function.BiFunction;

/**
 * 《Java核心技术 第10卷》-接口、lambda表达式学习
 */
public class InterfaceExample {
    public static void main(String[] args) {
       // timerTest();
        // sortTest();
        //lambdaTest();
       // InterfaceExample interfaceExample = new InterfaceExample();
       // interfaceExample.countDown(1,10000);
        /*String temp = null;
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add(temp);
        System.out.println("lengthBefore = " + list.size());
        list.removeIf(e -> e == null);//Predicate函数式接口
        System.out.println("lengthAfter = " + list.size());
         */
        findMaxVal();
    }

    /**
     * Java API标准库定时任务测试
     */
    public static void timerTest() {
        ActionListener actionListener = new TimePrinter();//创建监听器对象，即监听事件是怎样的(输出当前事件和计算机发出蜂鸣声)
        Timer timer = new Timer(10000,actionListener);//创建定时器，触发时间(每10秒)，触发对象(actionListener)
        timer.start();//启动触发器

        //终止定时任务
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    /**
     * Java API标准库sort方法排序对象数组
     */
    public static void sortTest(){
        Integer[] prototype = {1,2,3};
        String[] objArry = {"Peters","Paull","Mary"};
        Arrays.sort(objArry,new LengthComparator());
        System.out.println("objArry=" + Arrays.toString(objArry));
    }

    /**
     * Java Lambda表达式：(参数1，参数2) -> {代码块/表达式体}
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

        //终止定时任务
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

        BiFunction<String,String,Integer> result = (first,second) -> {return first.length() - second.length();};

    }

    /**
     * Java-lambda表达式： () ->{}
     * @param start
     * @param delay
     */
    public void countDown(int start, int delay){
       // start--;
        ActionListener actionListener = (event) -> {
            //start--;//编译时异常/未检查异常
            //System.out.println("start = " + start);//在lambda表达式中引用的变量，在代码块外部是不允许被改变的，否则会报未检查异常，只能是不可改变的变量
            System.out.println("this = " + this.toString());
        };
        new Timer(delay,actionListener).start();

        //终止定时任务
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    /**
     * Java-lambda表达式【() -> {}和 方法引用 :: 两种方式】 反转字符串
     */
    public static void strReversal(){
        String strReversalBefore = "str";
        System.out.println("strReversalBefore = " + strReversalBefore);
        //lambda代码块方式反转字符串
        String strReversalAfter = stringOp(str -> {
            String result = "";
            for(int i = str.length() -1; i >= 0; i--){
                result += str.charAt(i);
            }
            return result;
        },strReversalBefore);
        System.out.println("lambda代码块方式-strReveresalAfter " + strReversalAfter);
        //lambda方法引用方式反转字符串
        strReversalAfter = stringOp(MyStringOps:: strReverse,strReversalBefore);
        System.out.println("lambda方法引用方式-strReversalAfter " + strReversalAfter);
    }

    /**
     *Java -lambda表达式 反转字符串
     * @param str
     * @param s
     * @return
     */
    public static String stringOp(StringFunc str, String s){
        return str.func(s);
    }

    /**
     * Java-lambda表达式，查找集合最大元素值
     */
    public static void findMaxVal() {
        ArrayList<MyClass> arrList = new ArrayList<>();
        arrList.add(new MyClass(1));
        arrList.add(new MyClass(2));
        //() -> {}方式
        MyClass myClassMax = Collections.max(arrList,(MyClass myClassA,MyClass myClassB) -> {
            return myClassA.getVal() - myClassB.getVal();
        });
        System.out.println(myClassMax.getVal());
        // :: 方式
        myClassMax = Collections.max(arrList,InterfaceExample::compareMax);
        System.out.println(myClassMax.getVal());
    }

    public static int compareMax(MyClass myClassA, MyClass myClassB){
        return myClassA.getVal() - myClassB.getVal();
    }

}
