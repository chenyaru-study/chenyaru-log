import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by c_chenyaru on 2020/10/18.
 */
public class DemoMain {
    public static final String DEMO_ONE = "demotest";
    public static void main(String[] args) {
/*        int test = 0;
        System.out.println("test = [" + test + "]");
        if(DEMO_ONE.equals("demotest")){
            System.out.println("args = [" + DEMO_ONE + "]");
        }*/
        DemoMain demoMain = new DemoMain();
       // demoMain.testOne();
       // demoMain.syntaxPracticeString();
        //demoMain.inOrOut();
        //demoMain.switchTest();
        //demoMain.breakTest();
        demoMain.arrayListTest();
    }
    /**
     * Java语法-运算符
     */
    public void testOne(){
        //当参与/运算的两个操作数都是整数时，表示整数除法；否则，表示浮点除法(单精度float；双精度double)。
        int intA = 15;
        int intB = 6;
        System.out.println("Integer/:" + intA / intB);//2
        System.out.println("Integer%:" + intA % intB);//3
        float floatA = 17;
        float floatB = 6;
        System.out.println("Float/:" + floatA / floatB);//2.8333333
        System.out.println("Float%:" + floatA % floatB);//5.0
        double doubleA = 17;
        double doubleB = 6;
        System.out.println("Double/:" + doubleA / doubleB);//2.8333333333333335
        System.out.println("Double%:" + doubleA % doubleB);//5.0
        //**整数被0除将会产生一个异常，而浮点数被0除将会得到无穷大或NaN结果。**
        int intC = 10;
        //System.out.println("intC/0: " + intC / 0);//异常
       // System.out.println("intC%0: " + intC % 0);//异常
        float floatC = 10;
        System.out.println("floatC/0: " + floatC / 0);//Infinity
        System.out.println("floatC%0: " + floatC % 0);//NaN
        //三元运算符
        float floatD = floatA < floatB ? floatA : floatB;
        System.out.println("三元运算符floatD: " + floatD);
    }
    /**
     * Java语法-字符串
     */
    public void syntaxPracticeString(){
        String temp = "hello";
        System.out.println("代码单元数量：" + temp.length());
        System.out.println("码点数量：" + temp.codePointCount(0,temp.length()));
        int index = temp.offsetByCodePoints(0,2);
        int codePoint = temp.codePointAt(index);
        System.out.println("第一个码点：" + codePoint);
       // InputStream charIo = temp.codePoints();
        StringBuffer buffer = new StringBuffer();//多线程使用，线程安全，有synchronized修饰
    }
    /**
     * Java语法-输入输出
     */
    public void inOrOut(){
     //   Scanner scanner = new Scanner(System.in);
      //  System.out.println("输出流输出至控制台；Hello Word!");
      //  String inLine = scanner.nextLine();
      //  Scanner scannerB = new Scanner(System.in);
      //  System.out.println("输出一个单词至控制台；Hello");
     //   String inOne = scannerB.next();
     //   System.out.println("输入一行：" + inLine + ";输入一个单词：" + inOne);
    //    double doubleA = 10000/3.0;
      //  System.out.println(doubleA);
    //    System.out.printf("%7.2f",doubleA);
        //格式化输出
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        Scanner ageScanner = new Scanner(System.in);
        int age = ageScanner.nextInt();
        System.out.printf("名字：%s，年龄：%f",name,age);//错误，格式转换符不允许数据类型的(非)强制转换

    }
    /**
     * Java语法-控制流程
     */
    public void switchTest() {
        int tempA = 1;
        int tempB = 2;
        int tempC = 3;
        String result = "";
        switch(tempA){
            case 1:
                switch(tempB){
                    case 1:
                        result = "1";
                    case 2:
                        result = "2";
                }
            case 2:
                switch(tempC){
                    case 3:
                        result = "3";
                    case 4:
                        result = "4";
                    default:
                        result = "5";
                }
        }
        System.out.println("result=" + result);//5
    }
    /**
     * Java语法-带标签的break在循环中的用法
     */
    public void breakTest(){
        outerI://放在外部循环i前，效果，外部循环i只会遍历一次
        for (int i = 0; i<=3; i++) {
           // outerJ://放在嵌套循环的内部j循环前，效果：外部循环i会全部遍历
            for (int j = 0; j <= 2; j++) {
                System.out.print(i + "," + j + " ");
                if(j == 1) {
                   /* System.out.println("跳出J循环");
                    break outerJ;*/
                    System.out.println("跳出I循环");
                    break outerI;
                }
            }
        }
    }
    /**
     * Java语法-数组
     */
    public void arrayListTest(){
        int[] temp = {2};
        int[] coppyTemp = Arrays.copyOfRange(temp,0,temp.length);//数组浅copy：指向同一个堆
        System.out.println("temp:" + temp);
        System.out.println("temp value:" + temp[0]);
        System.out.println("copyTemp:" + coppyTemp);
        System.out.println("copyTemp value:" + coppyTemp[0]);
    }

}
