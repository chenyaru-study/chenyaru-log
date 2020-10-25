import java.time.LocalDate;

/**
*Java语法-对象与类
*@author
*@date
*/
public class ObjDemoMain {
    public static void main(String[] args) {

    }
    public void dateUtilTest(){
        LocalDate localDate = LocalDate.now();
        System.out.println("year=" + localDate.getYear() + "month=" + localDate.getMonth() + "");
    }
}
