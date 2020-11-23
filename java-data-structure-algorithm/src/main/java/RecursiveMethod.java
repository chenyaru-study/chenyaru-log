import java.util.Scanner;
import java.util.logging.Logger;

/**
 * �ݹ��㷨ѧϰ
 */
public class RecursiveMethod {
    private static final Logger logger = Logger.getLogger(RecursiveMethod.class.getName());
    public static void main(String[] args) {
        methodA();
    }

    /**
     * ��ν�׳ˣ����Ǵ�1��ָ����֮���������Ȼ����˵Ľ����n�Ľ׳�Ϊ��
     * n��=n*��n-1��*��n-2��*����*2*1
     * �����ڣ�n-1�������������±��ʽ��
     * ��n-1����=��n-1��*��n-2��*����*2*1
     * �������������ʽ���Կ����׳˾������Եĵ������ʣ����������µ��ƹ�ʽ��
     * n��=n*��n-1����
     * ��ˣ����Բ��õݹ��˼��������׳�
     */
    private static void methodA(){
        logger.info("������Ҫ��Ľ׳�����");
        Scanner in = new Scanner(System.in);
        int param = in.nextInt();
        int result = sumFactorial(param);
        logger.info("�ݹ�����Ľ׳���Ϊ��" + result);
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
