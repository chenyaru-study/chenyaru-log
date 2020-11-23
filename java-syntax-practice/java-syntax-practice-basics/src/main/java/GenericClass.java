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
 * 《Java核心技术 第10卷》-泛型类学习
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
     * Java-泛型（类型变量的限定）
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
        //编译错误，因为泛型方法pairTest()的类型变量T被限定为实现Comparable接口的类，而MyClass未实现Comparable接口，所以编译不通过
        //Pair<MyClass> testArray = ArrayAlg.pairTest(myClasses);

        Pair<MyClass> myClassPair = new Pair<>(new MyClass(1),new MyClass(2));
        MyClass myClass = myClassPair.getFirst();
        System.out.println("className= " + myClassPair.getClass());
        Pair<LocalDate> pair = new Pair<>(LocalDate.of(1906,12,9),LocalDate.of(1815,12,10));
        System.out.println("pairClass= " + pair.getClass());
        //System.out.println(new ArrayList<String>());
    }

    /**
     * Java-泛型（类型擦除）
     */
    public static void typeErasure(){
        DataInterval dataInterval = new DataInterval();
        Pair<LocalDate> datePair = dataInterval;
       // Date date = new Date();
        datePair.setFirst(LocalDate.of(1906,12,9));
        datePair.setSecond(LocalDate.of(1815,12,10));
        System.out.println(datePair.getSecond());
        //泛型数组初始化编译报错，因为java泛型的类型擦除机制，会将Pair<LocalDate>[]数组编程Pair[](即Object类型的数组)，
        // 如果对数组赋值其他类型的泛型元素，如Pair<Employee>，虚拟机的类型擦除机制也会允许赋值，但会造成数据混乱，所以Java不允许对泛型数组初始化操作，编译不通过
       // Pair<LocalDate>[] pair = new Pair<LocalDate>[10];
        //可以声明通配类型的数组，然后进行类型转换「通配符：?」
        Pair<LocalDate>[] pairs = (Pair<LocalDate>[])new Pair<?>[10];
    }
}
