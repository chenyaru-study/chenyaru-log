import java.util.logging.Logger;

/**
 * ����㷨ʵ��-����ͬ��
 */
public class ExhaustiveAttackmethod {
    private static final Logger logger = Logger.getLogger(ExhaustiveAttackmethod.class.getName());
    /**
     * ����㷨ʵ��-����ͬ��
     * ��һ���������������ֻ��������ֻ�ã�������������35��ͷ��������������94ֻ�š������м����õ��������Ƕ��٣�
     * �����������������Ӧ����0~35֮��
     * @param args
     */
    public static void main(String[] args) {
        int sumChicken = 0;
        int sumRabbit = 0;
        //i������������temp�����õ�����
        for(int i = 0; i < 35; i++){
            int temp = 35 - i;
            if((2 * i + 4 * temp) == 94) {
                sumChicken = i;
                sumRabbit = temp;
            }
        }
        logger.info("��������Ϊ��" + sumChicken + " �õ�����Ϊ��" + sumRabbit);
    }
}
