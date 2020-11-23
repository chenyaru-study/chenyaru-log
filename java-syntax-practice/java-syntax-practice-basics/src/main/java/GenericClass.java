package src.main.java;

import src.main.dto.DataInterval;
import src.main.dto.MyClass;
import src.main.dto.Pair;
import src.main.utils.ArrayAlg;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * ��Java���ļ��� ��10��-������ѧϰ
 */
public class GenericClass {
    public static void main(String[] args) {
       // genericTest();
       // genericTest2();
        typeErasure();
    }
    public static void genericTest(){
        String[] words = {"Mary","had","a","little","lamb"};
        Pair<String> pair = ArrayAlg.minmax(words);
        System.out.println("min= " + pair.getFirst());
        System.out.println("max= " + pair.getSecond());
    }

    /**
     * Java-���ͣ����ͱ������޶���
     */
    public static void genericTest2(){
        LocalDate[] birthdays = {
                LocalDate.of(1906,12,9),//G.Hopper
                LocalDate.of(1815,12,10),//A.Lovelace
                LocalDate.of(1903,12,3),//J.von Neumann
                LocalDate.of(1910,6,22),//K.Zuse
        };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());

        MyClass[] myClasses = {
                new MyClass(1),
                new MyClass(2),
                new MyClass(3)
        };
        //���������Ϊ���ͷ���pairTest()�����ͱ���T���޶�Ϊʵ��Comparable�ӿڵ��࣬��MyClassδʵ��Comparable�ӿڣ����Ա��벻ͨ��
        //Pair<MyClass> testArray = ArrayAlg.pairTest(myClasses);

        Pair<MyClass> myClassPair = new Pair<>(new MyClass(1),new MyClass(2));
        MyClass myClass = myClassPair.getFirst();
        System.out.println("className= " + myClassPair.getClass());
        Pair<LocalDate> pair = new Pair<>(LocalDate.of(1906,12,9),LocalDate.of(1815,12,10));
        System.out.println("pairClass= " + pair.getClass());
        //System.out.println(new ArrayList<String>());
    }

    /**
     * Java-���ͣ����Ͳ�����
     */
    public static void typeErasure(){
        DataInterval dataInterval = new DataInterval();
        Pair<LocalDate> datePair = dataInterval;
       // Date date = new Date();
        datePair.setFirst(LocalDate.of(1906,12,9));
        datePair.setSecond(LocalDate.of(1815,12,10));
        System.out.println(datePair.getSecond());
        //���������ʼ�����뱨����Ϊjava���͵����Ͳ������ƣ��ὫPair<LocalDate>[]������Pair[](��Object���͵�����)��
        // ��������鸳ֵ�������͵ķ���Ԫ�أ���Pair<Employee>������������Ͳ�������Ҳ������ֵ������������ݻ��ң�����Java������Է��������ʼ�����������벻ͨ��
       // Pair<LocalDate>[] pair = new Pair<LocalDate>[10];
        //��������ͨ�����͵����飬Ȼ���������ת����ͨ�����?��
        Pair<LocalDate>[] pairs = (Pair<LocalDate>[])new Pair<?>[10];
    }
}
