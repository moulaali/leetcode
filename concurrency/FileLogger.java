package filelogger;

import java.io.*;

public class FileLogger {

    private static FileLogger instance;
    private FileOutputStream fos;
    private BufferedOutputStream bos;
    private DemoType demoType;

    enum DemoType {
        FLUSH_IMMEDIATELY, FLUSH_ON_DEMAND
    }

    public static FileLogger getInstance(DemoType demoType) {
        if (instance == null) {
            instance = new FileLogger("app.log");
            instance.demoType = demoType;
        }

        return instance;

    }

    public void flush() {
        try {
            bos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ;
    }

    private FileLogger(String fileName) {
        try {
            fos = new FileOutputStream(fileName);
            bos = new BufferedOutputStream(fos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void append(String data) {
        try {
            bos.write(data.getBytes());

            if (demoType == DemoType.FLUSH_IMMEDIATELY) {
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
