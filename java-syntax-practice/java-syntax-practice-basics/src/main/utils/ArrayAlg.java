package src.main.utils;

import src.main.dto.Pair;

import java.io.Serializable;

/**
 * Java-泛型类练习(工具类)
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
                min = a[i];//保留每次比较的小值，并与后面的元素比较，直到找到最小值
            }
            if(min.compareTo(a[i]) > 0) {
                max = a[i];//保留每次比较的大值，并与后面的元素比较，直到找到最大值
            }
        }
        return new Pair<T>(min,max);
    }

    /**
     * Java-泛型方法(普通类的泛型方法)
     * 格式：类型变量<T> 放在修饰符(public static)的后面，返回类型的前面
     * 泛型方法可以定义在泛型类中，也可以定义在普通类中
     * <T extends Comparable>含义：限制类型变量T只能为实现了Comparable接口的类。
     * 用extends不用implements，只是为了表示泛型T和绑定类型Comparable之间是父子类关系。
     * 可以对泛型T进行多个限定：<T extends Comparable & Serializable>
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
