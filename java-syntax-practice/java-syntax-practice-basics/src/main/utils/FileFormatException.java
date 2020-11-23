package src.main.utils;

import java.io.IOException;

public class FileFormatException extends IOException implements AutoCloseable {
    public FileFormatException(){};
    public FileFormatException(String error){
        super(error);
    };

    @Override
    public void close() throws Exception {

    }
}
