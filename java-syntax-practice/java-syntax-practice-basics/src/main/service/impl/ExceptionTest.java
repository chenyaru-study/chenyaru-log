package src.main.service.impl;

import src.main.utils.FileFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest extends ExceptionTestBase {
    public String exceptionTest() throws FileFormatException {//异常声明错误，子类重写父类方法时，子类只能抛出父类的子类异常，异常也需要符合继承关系
        int i = 0;
        if(i == 0){
            throw new FileFormatException("error");
        }
        return "exception";
    }
}
