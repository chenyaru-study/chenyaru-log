import java.util.Scanner;
import java.util.logging.Logger;

/**
 * �����㷨ʵ��-쳲���������
 */
public class RecursiveAlgorithm {
    private static final Logger logger = Logger.getLogger(RecursiveAlgorithm.class.getName());

    public static void main(String[] args) {
        methodA();
    }

    /**
     * ���һ�������´�������Ժ�ÿһ���¶�������һ��С���ӣ���һ�����������ӳ��������º�ſ�����С���ӡ�
     * Ҳ����˵��1�·ݳ�����3�·ݲſɲ��С���ô�ٶ�һ����û�з������������¼�����ô1����ж��ٶ������أ�
     * ���������   �·ݣ�1�·�  2�·�  3�·�  4�·�  5�·�  6�·�  ...
     *         ���Ӷ�����  1     1     2     3      5     8   ...
     *         ���㹫ʽ��Fn = Fn-1 +Fn-2 ����n�·ݵ������� = ��n-1�·ݵ������� + ��n-2�·ݵ���������
     * ����˼·��ʹ�õݹ���ü���
     */
    private static void methodA(){
        logger.info("�������·ݣ�");
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int sumRabbits = countRabbit(month);
        logger.info("�� " + month + " �µ���������Ϊ��" + sumRabbits);
    }

    private static int countRabbit(int month) {
        int tempA;//��n-1�·�������
        int tempB;//��n-2�·�������
        if(month == 1 || month == 2) {
            return 1;
        } else {
            tempA = countRabbit(month -1);//��n-1�·�
            tempB = countRabbit(month - 2);//��n-2�·�  ��n-2�·ݳ��������ӻ��ڵ�n�·�����һ�����ӣ���1�·ݺ͵ڶ��·ݶ�ֻ��һ������
            return tempA + tempB;
        }
    }
}
