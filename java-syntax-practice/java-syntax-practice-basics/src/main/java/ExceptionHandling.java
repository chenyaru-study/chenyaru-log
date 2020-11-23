package src.main.java;

import src.main.service.impl.ExceptionTest;
import src.main.utils.FileFormatException;

import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ��Java���ļ��� ��10��-�쳣�������ԣ���־ѧϰ
 */
public class ExceptionHandling {
    private static final Logger myLogger = Logger.getLogger("com.mycompany.myapp");
    public static void main(String[] args) throws FileFormatException {
        /*ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.exceptionTest();*/
/*        try {
            read("");
        } catch (Exception e) {

        }*/
        Logger.getGlobal().setLevel(Level.OFF);//�ر�/ȡ��������־
        loggerTest();//�ڳ���ȫ�ַ�Χ�ڽ��м򵥼�¼��־
        myLogger.setLevel(Level.INFO);//������־��¼����
        //��¼��־�ķ���
        myLogger.info("info");
        myLogger.warning("warning");
        //������־��¼����ͼ�¼��־�ķ���
        myLogger.log(Level.INFO,"INFO");
        myLogger.log(Level.WARNING,"warning");
    }

    public void exceptionTest(){
        int[] intArray = new int[1];
        //�Ǽ���쳣(����ʱ�쳣)��ֻ���ڳ�������ʱ����֣��޷��ڳ������ʱ���֣���������ʱ��ArrayOutOfIndexException
        intArray[-1] = 1;
        System.out.println("intArray = " + Arrays.toString(intArray));
    }

    /**
     * Java-�����쳣��ʽһ��try{}catch(Exception e){}finally{}����
     */
    public static void read(String fileName) throws IOException {
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream(new File(fileName));
            int bytes;
            while((bytes = inputStream.read()) != -1){
                System.out.println("fileBytes = " + inputStream.read());
            }
        } catch(IOException e) {
            e.printStackTrace();
           // throw e;
        } finally {
            inputStream.close();
            System.out.println("finally" );
        }
        System.out.println("finallyAfterA ");
        int temp = 0;
        System.out.println("finallyAfterB");
        temp++;
        System.out.println("temp = " + temp);
    }

    /**
     * Java-�����쳣��ʽ��(����Ϸ�ʽ)��try{ try{}finally{} }catch(){}��
     * ���Ը���ȷ����catch��finally�����ְ��Ҳ���Բ���finally{}�����е��쳣����ֹ����©δ������쳣
     * @param fileName
     * @throws IOException
     */
    public static void readA(String fileName) throws IOException {
        InputStream inputStream = null;
        try{
            try{
                inputStream = new FileInputStream(new File(fileName));
                int bytes;
                while((bytes = inputStream.read()) != -1){
                    System.out.println("fileBytes = " + inputStream.read());
                }
            } finally {
                inputStream.close();
                System.out.println("finally" );
            }

        } catch(IOException e) {
            e.printStackTrace();
            // throw e;
        }
        System.out.println("finallyAfterA ");
        int temp = 0;
        System.out.println("finallyAfterB");
        temp++;
        System.out.println("temp = " + temp);
    }

    /**
     * Java-�����쳣��ʽ��������Դ�Ĳ����쳣��ʽ��Java7���Ժ������ķ�ʽ����try(��Դ) {} catch{}
     * ˵����try(��Դ)ʹ�ó�����
     * 1.������������ر�������������try{}�����Ƿ�����쳣������ִ��try()�еĹر���Դ����������finally{}�飬������finally{}�飻
     * 2.��try{}�д����쳣������finally{}��Ҳ�����쳣���Ҷ����쳣��һ��ʱ��try(��Դ)���Զ�����finally{}�е��쳣���׳�try{}����쳣��ǰ����try(��Դ)����ԴҪʵ��AutoCloseable�ӿ�
     * @param fileName
     */
    public static void readB(String fileName) throws IOException {
       // InputStream inputStream = null;
        try(InputStream inputStream = new FileInputStream(new File(fileName));FileFormatException file = new FileFormatException()){
           // inputStream = new FileInputStream(new File(fileName));
            int bytes;
            while((bytes = inputStream.read()) != -1){
                System.out.println("fileBytes = " + inputStream.read());
            }
        }catch(IOException e) {
            e.printStackTrace();
            // throw e;
        } catch (Exception e) {
            e.printStackTrace();
            StackTraceElement[] elements = e.getStackTrace();
        }/* finally {
            try{
                inputStream.close();
                System.out.println("finally" );
                FileFormatException file = new FileFormatException();
                throw file;
            } catch(FileFormatException e) {
                e.printStackTrace();
            }

        }*/
        System.out.println("finallyAfterA ");
        int temp = 0;
        System.out.println("finallyAfterB");
        temp++;
        System.out.println("temp = " + temp);
        Math.abs(-1);
    }

    /**
     * Java-��־��¼
     */
    public static void loggerTest() {
        Logger.getGlobal().info("File->Open menu item selected");
    }
}
