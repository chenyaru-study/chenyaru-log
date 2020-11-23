package src.main.utils;

import src.main.dto.Pair;

import java.io.Serializable;

/**
 * Java-��������ϰ(������)
 */
public class ArrayAlg {
    public static<T extends Comparable> Pair<T> minmax(T[] a) {
        if(a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];
        for(int i = 1; i < a.length; i++){
            if(min.compareTo(a[i]) > 0) {
                min = a[i];//����ÿ�αȽϵ�Сֵ����������Ԫ�رȽϣ�ֱ���ҵ���Сֵ
            }
            if(min.compareTo(a[i]) > 0) {
                max = a[i];//����ÿ�αȽϵĴ�ֵ����������Ԫ�رȽϣ�ֱ���ҵ����ֵ
            }
        }
        return new Pair<T>(min,max);
    }

    /**
     * Java-���ͷ���(��ͨ��ķ��ͷ���)
     * ��ʽ�����ͱ���<T> �������η�(public static)�ĺ��棬�������͵�ǰ��
     * ���ͷ������Զ����ڷ������У�Ҳ���Զ�������ͨ����
     * <T extends Comparable>���壺�������ͱ���Tֻ��Ϊʵ����Comparable�ӿڵ��ࡣ
     * ��extends����implements��ֻ��Ϊ�˱�ʾ����T�Ͱ�����Comparable֮���Ǹ������ϵ��
     * ���ԶԷ���T���ж���޶���<T extends Comparable & Serializable>
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable & Serializable, U extends Comparable> T getMiddle(T a) {
        return a;
    }

    public static <T extends Comparable> Pair<T> pairTest(T[] array){
        return new Pair<T>(array[0],array[1]);
    }

}
