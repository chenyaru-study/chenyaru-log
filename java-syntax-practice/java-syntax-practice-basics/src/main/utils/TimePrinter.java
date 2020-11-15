package src.main.utils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("当前时间为：" + new Date());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        toolkit.beep();//计算机发出蜂鸣声
    }
}
