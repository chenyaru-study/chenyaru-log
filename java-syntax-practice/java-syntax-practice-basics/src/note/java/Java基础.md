---
title: Java基础学习
date: 2020-10-19
---
# 学习书籍《Java核心技术第10卷》（共2册）
## 学习模块划分
### 第一章 Java程序设计概述
#### Java语言特性
* 简单性：java语法比C++简单，摒弃C++的头文件、指针运算（甚至指针语法）、结构、联合、操作符重载、虚基类等；可支持在小型机器上运行；
* 面向对象性：重点放在数据(对象)和数据的接口上，其次是处理数据的过程和方式；
用木匠打一个比方，一个“面向对象的”木匠始终关注的是所制作的椅子，第二位才是所使用的工具；一个“非面向对象的”木匠首先考虑的是所用的工具(即C++的面向过程)。
* 分布式：Java有一个丰富的例程库，用于处理像HTTP和FTP之类的TCP/IP协议。Java应用程序能够通过URL打开和访问网络上的对象，其便捷程度就好像访问本地文件一样
* 健壮性：Java和C++最大的不同在于Java采用的指针模型可以消除重写内存和损坏数据的可能性。
* 安全性：Java浏览器插件不再信任远程代码，除非代码有数字签名而且用户同意执行这个代码。Java语言不支持指针，只有通过对象的实例才能访问内存，使应用更安全
* 体系结构中立：使用字节码通过java虚拟机(JVM)转换成机器码，避免不同机器的机器指令不同产生混乱。
* 可移植性：支持多种操作系统的移植。
* 解释性：Java解释器可以在任何移植了解释器的机器上执行Java字节码。由于链接是一个增量式且轻量级的过程，所以，开发过程也变得更加快捷，更加具有探索性
* 高性能：字节码可以（在运行时刻）动态地翻译成对应运行这个应用的特定CPU的机器码。java虚拟机(JVM)对于不会被覆盖且代码比较短的函数会进行“内联”操作。
* 多线程
* 动态性：从Internet下载代码，然后在浏览器上运行。
### 第二章 Java程序设计环境
#### Java开发环境准备
* JDK下载地址：www.oracle.com/technetwork/java/javase/downloads
* cmd常用命令：
    * 创建目录命令：mkdir
    * 解压压缩包(.zip;.jar)命令：jar xvf xxx.jar
    * 重命名目录命令：mv 原目录名 新目录名
### 第三章 Java的基本程序设计结构
#### 数据类型
* 二进制数值，八进制，十六进制：需要整体学习【计算机网络】
    * [学习书籍-微信读书电子版《计算机原理》]()
#### 运算符
* 浮点寄存器：需要整体学习【计算机原理-寄存器】部分
    * [学习链接-百度]()
    * [学习书籍-微信读书电子版《计算机网络》](https://weread.qq.com/web/reader/af532c005a007caf51371b1)
* 三元运算符：condition ? expression1 : expression2
    * 例如：x < y ? x : y
* strictfp关键字：strictfp是strict float point的缩写,用来修饰类，方法，变量；
如果被修饰，对于其内的浮点运算，JVM虚拟机会严格按照IEEE二进制计算标准进行浮点运算，可以避免因寄存器和虚拟机的不同产生的损失精度问题。
* 掩码技术：需要学习【计算机网络】
    * [学习链接-百度](https://baike.baidu.com/item/%E6%8E%A9%E7%A0%81/86301?fr=aladdin)
    * [学习书籍-微信读书电子版《计算机网络》](https://weread.qq.com/web/reader/af532c005a007caf51371b1)
* 位运算符：需要实践和再次理解，位运算符和位掩码结合使用
    * &，|，>>，<<，>>>
#### 字符串
* 码点与代码单元：
    * 码点(代码点)：通俗来说，码点就是一个编号，编号规则为U+数字，表示一个数字代表一个字符。
    * 代码单元：在不同的字符集编码规则里(UTF-8,UTF-16等)，一个字符对应的码点值，可能对应一个或多个字节值，即一个或多个代码单元。
    Java的char数据类型是一个采用UTF-16字符集编码规则表示码点的代码单元。大多数的常用Unicode字符使用一个代码单元就可以表示，而辅助字符需要一对代码单元表示。
    * length方法将返回采用UTF-16编码表示的给定字符串所需要的代码单元数量。例如：
    ```
    String temp = "hello";
    System.out.println(temp.length());//5
    ```
    * codePointCount()方法将得到字符串的实际长度(直观看到的)，即码点数量。例如：
    ```
    String temp = "hello";
    System.out.println(temp.codePointCount(0,temp.length()));//5
    ```
    * 调用s.charAt（n）将返回位置n的代码单元，n介于0~s.length（）-1之间。例如：
    ```
    String temp = "hello";
    System.out.println(temp.charAt(0));//h
    ```
    * 要想得到第i个码点，应该使用下列语句
    ```
    int index = temp.offsetByCodePoints(0,i);
    int codePoint = temp.codePointAt(index);
    ```
#### 输入输出
##### 格式化输出（可用System.out.printf作Demo训练）
* 用于printf的转换符：
| 转换符 | 类型 | 举例 |
| ---- | ---- |
#### 控制流程
* switch语句：
    * 基本语法：
    ```
        switch(表达式){ //表达式为byte，short，int，char；Java 7及以上增加支持String字符串
           case 常量值1:
                System.out.println();
                break;
           case 常量值2:
                System.out.println();
                break;
           default:
                System.out.println();
                break;
        }
    ```
    * 坑点：
    有可能触发多个case分支。如果在case分支语句的末尾没有break语句，那么就会接着执行下一个case分支语句。
    例如：
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
    注：尽量避免使用switch语句，如果要用，可在编译时加上-Xlint：fallthrough选项：javac -Xlint：fallthrough Test.java
    如果业务场景允许不加break关键字，可使用@SuppressWarnings（"fallthrough"）标注方法。
* break 关键字在循环语句中的使用：
    * 带标签的break语句：终止break所在循环的所有迭代，并回到标签，不再重新进入标签内的循环
    ```
    语法：【自定义标签名:】
        public void breakTest(){
            outerI://放在外部循环i前，效果，外部循环i只会遍历一次
            for (int i = 0; i<=3; i++) {
               // outerJ://放在嵌套循环的内部j循环前，效果：外部循环i会全部遍历
                for (int j = 0; j <= 2; j++) {
                    System.out.print(i + "," + j + " ");
                    if(j == 1) {
                       /* System.out.println("跳出J循环");
                        break outerJ;*/
                        System.out.println("跳出I循环");
                        break outerI;
                    }
                }
            }
        }
    ```
    注：continue关键字同理。
#### 大数值
```
·BigInteger add（BigInteger other）加
·BigInteger subtract（BigInteger other）减
·BigInteger multiply（BigInteger other）乘
·BigInteger divide（BigInteger other）除
·BigInteger mod（BigInteger other）取余
```
注：BigInteger 大整数；BigDecimal大浮点数
#### 数组
* static void sort（type[]a）
采用优化的快速排序算法对数组进行排序。
参数：a　类型为int、long、short、char、byte、boolean、float或double的数组。
* static int binarySearch（type[]a，type v）
static int binarySearch（type[]a，int start，int end，typev）6
采用二分搜索算法查找值v。如果查找成功，则返回相应的下标值；否则，返回一个负数值r。-r-1是为保持a有序v应插入的位置。
参数：a　类型为int、long、short、char、byte、boolean、float或double的有序数组。
start　起始下标（包含这个值）。
end　终止下标（不包含这个值）。
v　同a的数据元素类型相同的值。