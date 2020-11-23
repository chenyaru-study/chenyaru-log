package src.main.java;

import src.main.service.impl.ExceptionTest;
import src.main.utils.FileFormatException;

import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 《Java核心技术 第10卷》-异常处理，断言，日志学习
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
        Logger.getGlobal().setLevel(Level.OFF);//关闭/取消所有日志
        loggerTest();//在程序全局范围内进行简单记录日志
        myLogger.setLevel(Level.INFO);//设置日志记录级别
        //记录日志的方法
        myLogger.info("info");
        myLogger.warning("warning");
        //设置日志记录级别和记录日志的方法
        myLogger.log(Level.INFO,"INFO");
        myLogger.log(Level.WARNING,"warning");
    }

    public void exceptionTest(){
        int[] intArray = new int[1];
        //非检查异常(运行时异常)，只有在程序运行时会出现，无法在程序编译时发现，程序运行时报ArrayOutOfIndexException
        intArray[-1] = 1;
        System.out.println("intArray = " + Arrays.toString(intArray));
    }

    /**
     * Java-捕获异常方式一：try{}catch(Exception e){}finally{}语句块
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
     * Java-捕获异常方式二(解耦合方式)：try{ try{}finally{} }catch(){}：
     * 可以更明确清晰catch和finally语句块的职责，也可以捕获finally{}语句块中的异常，防止有遗漏未捕获的异常
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
     * Java-捕获异常方式三：带资源的捕获异常方式「Java7及以后新增的方式」：try(资源) {} catch{}
     * 说明：try(资源)使用场景：
     * 1.可以用来处理关闭流操作，无论try{}块中是否存在异常，都会执行try()中的关闭资源操作，类似finally{}块，但优于finally{}块；
     * 2.当try{}中存在异常，并且finally{}块也存在异常，且二者异常不一致时，try(资源)会自动抑制finally{}中的异常，抛出try{}块的异常。前提是try(资源)的资源要实现AutoCloseable接口
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
     * Java-日志记录
     */
    public static void loggerTest() {
        Logger.getGlobal().info("File->Open menu item selected");
    }
}
