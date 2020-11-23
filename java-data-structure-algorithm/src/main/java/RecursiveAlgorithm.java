import java.util.Scanner;
import java.util.logging.Logger;

/**
 * 递推算法实例-斐波那契数列
 */
public class RecursiveAlgorithm {
    private static final Logger logger = Logger.getLogger(RecursiveAlgorithm.class.getName());

    public static void main(String[] args) {
        methodA();
    }

    /**
     * 如果一对两个月大的兔子以后每一个月都可以生一对小兔子，而一对新生的兔子出生两个月后才可以生小兔子。
     * 也就是说，1月份出生，3月份才可产仔。那么假定一年内没有发生兔子死亡事件，那么1年后共有多少对兔子呢？
     * 问题分析：   月份：1月份  2月份  3月份  4月份  5月份  6月份  ...
     *         兔子对数：  1     1     2     3      5     8   ...
     *         满足公式：Fn = Fn-1 +Fn-2 【第n月份的兔子数 = 第n-1月份的兔子数 + 第n-2月份的兔子数】
     * 编码思路：使用递归调用计算
     */
    private static void methodA(){
        logger.info("请输入月份：");
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int sumRabbits = countRabbit(month);
        logger.info("第 " + month + " 月的兔子数量为：" + sumRabbits);
    }

    private static int countRabbit(int month) {
        int tempA;//第n-1月份兔子数
        int tempB;//第n-2月份兔子数
        if(month == 1 || month == 2) {
            return 1;
        } else {
            tempA = countRabbit(month -1);//第n-1月份
            tempB = countRabbit(month - 2);//第n-2月份  第n-2月份出生的兔子会在第n月份生出一对兔子，第1月份和第二月份都只有一对兔子
            return tempA + tempB;
        }
    }
}
