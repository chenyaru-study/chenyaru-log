# 学习书籍《Java核心技术第10卷》（共2册）
## 学习模块划分
### Java核心技术卷I 基础知识
#### 第六章 接口、lambda表达式与内部类
##### 6.2接口示例
* 参考Demo练习类：InterfaceExample类
* Java API标准库方法：
    * javax.swing.JOptionPane 1.2 <br></br>
    ·static void showMessageDialog（Component parent，Object message）<br></br>
    显示一个包含一条消息和OK按钮的对话框。这个对话框将位于其parent组件的中央。如果parent为null，对话框将显示在屏幕的中央。
    * javax.swing.Timer 1.2 <br></br>
    ·Timer（int interval，ActionListener listener）构造一个定时器，每隔interval毫秒通告listener一次。 <br></br>
    ·void start（）
* lambda表达式 【重点学习**】
    * [学习书籍](https://weread.qq.com/web/reader/e56324b071a5ee49e56bbae)
    * [学习博客](https://www.cnblogs.com/xiaoxi/p/7099667.html)
    * 自我练习基础运用Demo例子：InterfaceExample.java
    * 自我练习提升运用Demo例子：复习完内部类，线程知识后，结合多线程的实现方式进一步提升**