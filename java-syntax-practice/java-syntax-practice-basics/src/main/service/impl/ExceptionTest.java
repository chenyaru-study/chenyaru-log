package src.main.service.impl;

import src.main.utils.FileFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest extends ExceptionTestBase {
    public String exceptionTest() throws FileFormatException {//�쳣��������������д���෽��ʱ������ֻ���׳�����������쳣���쳣Ҳ��Ҫ���ϼ̳й�ϵ
        int i = 0;
        if(i == 0){
            throw new FileFormatException("error");
        }
        return "exception";
    }
}
