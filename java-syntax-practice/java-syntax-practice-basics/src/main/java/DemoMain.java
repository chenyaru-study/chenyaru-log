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
     * Java�﷨-�����
     */
    public void testOne(){
        //������/�����������������������ʱ����ʾ�������������򣬱�ʾ�������(������float��˫����double)��
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
        //**������0���������һ���쳣������������0������õ�������NaN�����**
        int intC = 10;
        //System.out.println("intC/0: " + intC / 0);//�쳣
       // System.out.println("intC%0: " + intC % 0);//�쳣
        float floatC = 10;
        System.out.println("floatC/0: " + floatC / 0);//Infinity
        System.out.println("floatC%0: " + floatC % 0);//NaN
        //��Ԫ�����
        float floatD = floatA < floatB ? floatA : floatB;
        System.out.println("��Ԫ�����floatD: " + floatD);
    }
    /**
     * Java�﷨-�ַ���
     */
    public void syntaxPracticeString(){
        String temp = "hello";
        System.out.println("���뵥Ԫ������" + temp.length());
        System.out.println("���������" + temp.codePointCount(0,temp.length()));
        int index = temp.offsetByCodePoints(0,2);
        int codePoint = temp.codePointAt(index);
        System.out.println("��һ����㣺" + codePoint);
       // InputStream charIo = temp.codePoints();
        StringBuffer buffer = new StringBuffer();//���߳�ʹ�ã��̰߳�ȫ����synchronized����
    }
    /**
     * Java�﷨-�������
     */
    public void inOrOut(){
     //   Scanner scanner = new Scanner(System.in);
      //  System.out.println("��������������̨��Hello Word!");
      //  String inLine = scanner.nextLine();
      //  Scanner scannerB = new Scanner(System.in);
      //  System.out.println("���һ������������̨��Hello");
     //   String inOne = scannerB.next();
     //   System.out.println("����һ�У�" + inLine + ";����һ�����ʣ�" + inOne);
    //    double doubleA = 10000/3.0;
      //  System.out.println(doubleA);
    //    System.out.printf("%7.2f",doubleA);
        //��ʽ�����
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        Scanner ageScanner = new Scanner(System.in);
        int age = ageScanner.nextInt();
        System.out.printf("���֣�%s�����䣺%f",name,age);//���󣬸�ʽת�����������������͵�(��)ǿ��ת��

    }
    /**
     * Java�﷨-��������
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
     * Java�﷨-����ǩ��break��ѭ���е��÷�
     */
    public void breakTest(){
        outerI://�����ⲿѭ��iǰ��Ч�����ⲿѭ��iֻ�����һ��
        for (int i = 0; i<=3; i++) {
           // outerJ://����Ƕ��ѭ�����ڲ�jѭ��ǰ��Ч�����ⲿѭ��i��ȫ������
            for (int j = 0; j <= 2; j++) {
                System.out.print(i + "," + j + " ");
                if(j == 1) {
                   /* System.out.println("����Jѭ��");
                    break outerJ;*/
                    System.out.println("����Iѭ��");
                    break outerI;
                }
            }
        }
    }
    /**
     * Java�﷨-����
     */
    public void arrayListTest(){
        int[] temp = {2};
        int[] coppyTemp = Arrays.copyOfRange(temp,0,temp.length);//����ǳcopy��ָ��ͬһ����
        System.out.println("temp:" + temp);
        System.out.println("temp value:" + temp[0]);
        System.out.println("copyTemp:" + coppyTemp);
        System.out.println("copyTemp value:" + coppyTemp[0]);
    }

}
