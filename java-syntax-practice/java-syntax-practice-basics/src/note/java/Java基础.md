---
title: Java����ѧϰ
date: 2020-10-19
---
# ѧϰ�鼮��Java���ļ�����10������2�ᣩ
## ѧϰģ�黮��
### ��һ�� Java������Ƹ���
#### Java��������
* ���ԣ�java�﷨��C++�򵥣�����C++��ͷ�ļ���ָ�����㣨����ָ���﷨�����ṹ�����ϡ����������ء������ȣ���֧����С�ͻ��������У�
* ��������ԣ��ص��������(����)�����ݵĽӿ��ϣ�����Ǵ������ݵĹ��̺ͷ�ʽ��
��ľ����һ���ȷ���һ�����������ġ�ľ��ʼ�չ�ע���������������ӣ��ڶ�λ������ʹ�õĹ��ߣ�һ�������������ġ�ľ�����ȿ��ǵ������õĹ���(��C++���������)��
* �ֲ�ʽ��Java��һ���ḻ�����̿⣬���ڴ�����HTTP��FTP֮���TCP/IPЭ�顣JavaӦ�ó����ܹ�ͨ��URL�򿪺ͷ��������ϵĶ������ݳ̶Ⱦͺ�����ʱ����ļ�һ��
* ��׳�ԣ�Java��C++���Ĳ�ͬ����Java���õ�ָ��ģ�Ϳ���������д�ڴ�������ݵĿ����ԡ�
* ��ȫ�ԣ�Java����������������Զ�̴��룬���Ǵ���������ǩ�������û�ͬ��ִ��������롣Java���Բ�֧��ָ�룬ֻ��ͨ�������ʵ�����ܷ����ڴ棬ʹӦ�ø���ȫ
* ��ϵ�ṹ������ʹ���ֽ���ͨ��java�����(JVM)ת���ɻ����룬���ⲻͬ�����Ļ���ָ�ͬ�������ҡ�
* ����ֲ�ԣ�֧�ֶ��ֲ���ϵͳ����ֲ��
* �����ԣ�Java�������������κ���ֲ�˽������Ļ�����ִ��Java�ֽ��롣����������һ������ʽ���������Ĺ��̣����ԣ���������Ҳ��ø��ӿ�ݣ����Ӿ���̽����
* �����ܣ��ֽ�����ԣ�������ʱ�̣���̬�ط���ɶ�Ӧ�������Ӧ�õ��ض�CPU�Ļ����롣java�����(JVM)���ڲ��ᱻ�����Ҵ���Ƚ϶̵ĺ�������С�������������
* ���߳�
* ��̬�ԣ���Internet���ش��룬Ȼ��������������С�
### �ڶ��� Java������ƻ���
#### Java��������׼��
* JDK���ص�ַ��www.oracle.com/technetwork/java/javase/downloads
* cmd�������
    * ����Ŀ¼���mkdir
    * ��ѹѹ����(.zip;.jar)���jar xvf xxx.jar
    * ������Ŀ¼���mv ԭĿ¼�� ��Ŀ¼��
### ������ Java�Ļ���������ƽṹ
#### ��������
* ��������ֵ���˽��ƣ�ʮ�����ƣ���Ҫ����ѧϰ����������硿
    * [ѧϰ�鼮-΢�Ŷ�����Ӱ桶�����ԭ��]()
#### �����
* ����Ĵ�������Ҫ����ѧϰ�������ԭ��-�Ĵ���������
    * [ѧϰ����-�ٶ�]()
    * [ѧϰ�鼮-΢�Ŷ�����Ӱ桶��������硷](https://weread.qq.com/web/reader/af532c005a007caf51371b1)
* ��Ԫ�������condition ? expression1 : expression2
    * ���磺x < y ? x : y
* strictfp�ؼ��֣�strictfp��strict float point����д,���������࣬������������
��������Σ��������ڵĸ������㣬JVM��������ϸ���IEEE�����Ƽ����׼���и������㣬���Ա�����Ĵ�����������Ĳ�ͬ��������ʧ�������⡣
* ���뼼������Ҫѧϰ����������硿
    * [ѧϰ����-�ٶ�](https://baike.baidu.com/item/%E6%8E%A9%E7%A0%81/86301?fr=aladdin)
    * [ѧϰ�鼮-΢�Ŷ�����Ӱ桶��������硷](https://weread.qq.com/web/reader/af532c005a007caf51371b1)
* λ���������Ҫʵ�����ٴ���⣬λ�������λ������ʹ��
    * &��|��>>��<<��>>>
#### �ַ���
* �������뵥Ԫ��
    * ���(�����)��ͨ����˵��������һ����ţ���Ź���ΪU+���֣���ʾһ�����ִ���һ���ַ���
    * ���뵥Ԫ���ڲ�ͬ���ַ������������(UTF-8,UTF-16��)��һ���ַ���Ӧ�����ֵ�����ܶ�Ӧһ�������ֽ�ֵ����һ���������뵥Ԫ��
    Java��char����������һ������UTF-16�ַ�����������ʾ���Ĵ��뵥Ԫ��������ĳ���Unicode�ַ�ʹ��һ�����뵥Ԫ�Ϳ��Ա�ʾ���������ַ���Ҫһ�Դ��뵥Ԫ��ʾ��
    * length���������ز���UTF-16�����ʾ�ĸ����ַ�������Ҫ�Ĵ��뵥Ԫ���������磺
    ```
    String temp = "hello";
    System.out.println(temp.length());//5
    ```
    * codePointCount()�������õ��ַ�����ʵ�ʳ���(ֱ�ۿ�����)����������������磺
    ```
    String temp = "hello";
    System.out.println(temp.codePointCount(0,temp.length()));//5
    ```
    * ����s.charAt��n��������λ��n�Ĵ��뵥Ԫ��n����0~s.length����-1֮�䡣���磺
    ```
    String temp = "hello";
    System.out.println(temp.charAt(0));//h
    ```
    * Ҫ��õ���i����㣬Ӧ��ʹ���������
    ```
    int index = temp.offsetByCodePoints(0,i);
    int codePoint = temp.codePointAt(index);
    ```
#### �������
##### ��ʽ�����������System.out.printf��Demoѵ����
* ����printf��ת������
| ת���� | ���� | ���� |
| ---- | ---- |
#### ��������
* switch��䣺
    * �����﷨��
    ```
        switch(���ʽ){ //���ʽΪbyte��short��int��char��Java 7����������֧��String�ַ���
           case ����ֵ1:
                System.out.println();
                break;
           case ����ֵ2:
                System.out.println();
                break;
           default:
                System.out.println();
                break;
        }
    ```
    * �ӵ㣺
    �п��ܴ������case��֧�������case��֧����ĩβû��break��䣬��ô�ͻ����ִ����һ��case��֧��䡣
    ���磺
    ```
        public void switchTest() {
            int tempA = 1;
            int tempB = 2;
            int tempC = 3;
            String result = "";
            switch(tempA){
                case 1:
                    switch(tempB){
                        case 1:
                            result = "1";
                        case 2:
                            result = "2";
                    }
                case 2:
                    switch(tempC){
                        case 3:
                            result = "3";
                        case 4:
                            result = "4";
                        default:
                            result = "5";
                    }
            }
            System.out.println("result=" + result);//5
        }
    ```
    ע����������ʹ��switch��䣬���Ҫ�ã����ڱ���ʱ����-Xlint��fallthroughѡ�javac -Xlint��fallthrough Test.java
    ���ҵ�񳡾�������break�ؼ��֣���ʹ��@SuppressWarnings��"fallthrough"����ע������
* break �ؼ�����ѭ������е�ʹ�ã�
    * ����ǩ��break��䣺��ֹbreak����ѭ�������е��������ص���ǩ���������½����ǩ�ڵ�ѭ��
    ```
    �﷨�����Զ����ǩ��:��
        public void breakTest(){
            outerI://�����ⲿѭ��iǰ��Ч�����ⲿѭ��iֻ�����һ��
            for (int i = 0; i<=3; i++) {
               // outerJ://����Ƕ��ѭ�����ڲ�jѭ��ǰ��Ч�����ⲿѭ��i��ȫ������
                for (int j = 0; j <= 2; j++) {
                    System.out.print(i + "," + j + " ");
                    if(j == 1) {
                       /* System.out.println("����Jѭ��");
                        break outerJ;*/
                        System.out.println("����Iѭ��");
                        break outerI;
                    }
                }
            }
        }
    ```
    ע��continue�ؼ���ͬ��
#### ����ֵ
```
��BigInteger add��BigInteger other����
��BigInteger subtract��BigInteger other����
��BigInteger multiply��BigInteger other����
��BigInteger divide��BigInteger other����
��BigInteger mod��BigInteger other��ȡ��
```
ע��BigInteger ��������BigDecimal�󸡵���
#### ����
* static void sort��type[]a��
�����Ż��Ŀ��������㷨�������������
������a������Ϊint��long��short��char��byte��boolean��float��double�����顣
* static int binarySearch��type[]a��type v��
static int binarySearch��type[]a��int start��int end��typev��6
���ö��������㷨����ֵv��������ҳɹ����򷵻���Ӧ���±�ֵ�����򣬷���һ������ֵr��-r-1��Ϊ����a����vӦ�����λ�á�
������a������Ϊint��long��short��char��byte��boolean��float��double���������顣
start����ʼ�±꣨�������ֵ����
end����ֹ�±꣨���������ֵ����
v��ͬa������Ԫ��������ͬ��ֵ��