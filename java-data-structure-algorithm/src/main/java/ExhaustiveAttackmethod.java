import java.util.logging.Logger;

/**
 * 穷举算法实例-鸡兔同笼
 */
public class ExhaustiveAttackmethod {
    private static final Logger logger = Logger.getLogger(ExhaustiveAttackmethod.class.getName());
    /**
     * 穷举算法实例-鸡兔同笼
     * 在一个笼子里关着若干只鸡和若干只兔，从上面数共有35个头；从下面数共有94只脚。问笼中鸡和兔的数量各是多少？
     * 问题分析：鸡的数量应该在0~35之间
     * @param args
     */
    public static void main(String[] args) {
        int sumChicken = 0;
        int sumRabbit = 0;
        //i代表鸡的数量；temp代表兔的数量
        for(int i = 0; i < 35; i++){
            int temp = 35 - i;
            if((2 * i + 4 * temp) == 94) {
                sumChicken = i;
                sumRabbit = temp;
            }
        }
        logger.info("鸡的数量为：" + sumChicken + " 兔的数量为：" + sumRabbit);
    }
}
