import java.time.LocalDate;

/**
*Java�﷨-��������
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
