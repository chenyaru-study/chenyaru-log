import java.util.Scanner;
import java.util.logging.Logger;

/**
 * 递归算法学习
 */
public class RecursiveMethod {
    private static final Logger logger = Logger.getLogger(RecursiveMethod.class.getName());
    public static void main(String[] args) {
        methodA();
    }

    /**
     * 所谓阶乘，就是从1到指定数之间的所有自然数相乘的结果，n的阶乘为：
     * n！=n*（n-1）*（n-2）*……*2*1
     * 而对于（n-1）！，则有如下表达式：
     * （n-1）！=（n-1）*（n-2）*……*2*1
     * 从上述两个表达式可以看到阶乘具有明显的递推性质，即符合如下递推公式：
     * n！=n*（n-1）！
     * 因此，可以采用递归的思想来计算阶乘
     */
    private static void methodA(){
        logger.info("请输入要求的阶乘数：");
        Scanner in = new Scanner(System.in);
        int param = in.nextInt();
        int result = sumFactorial(param);
        logger.info("递归计算后的阶乘数为：" + result);
    }

    private static int sumFactorial(int n){
        int temp;
        if(n == 1) {
            return 1;
        } else {
            temp = sumFactorial(n-1);
            return temp * n;
        }
    }
}
