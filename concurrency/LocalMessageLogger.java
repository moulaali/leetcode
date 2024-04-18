package filelogger;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Try out different mechanisms to support high throughput logging system.
 * 1/ flush on every message (vs) flush on demand
 * 2/ flush periodically or when message queue is full
 */
public class FileLoggerDemo {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random random = new Random();


    public static void main(String[] args) {
        // demoFlushOnDemand();  // 6 secs for 250 mb file : Throughput: 40 mbps
        // demoFlushOnEveryMessage();  // 14 secs for 250 mb file : 16 mbps
    }

    private static void demoFlushOnEveryMessage() {
        FileLogger fl = FileLogger.getInstance(FileLogger.DemoType.FLUSH_IMMEDIATELY);

        long startTime = System.nanoTime();

        // ~250 mb file
        logRandomMessages(fl, 100 /* size */, 1500000 /* count */);

        // Log duration
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Runtime: " + durationInSeconds + " seconds");
    }

    private static void demoFlushOnDemand() {
        FileLogger fl = FileLogger.getInstance(FileLogger.DemoType.FLUSH_ON_DEMAND);

        long startTime = System.nanoTime();

        // ~250 mb file
        logRandomMessages(fl, 100 /* size */, 1500000 /* count */);
        fl.flush();

        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Runtime: " + durationInSeconds + " seconds");
    }

    private static void logRandomMessages(FileLogger fl, int size, int count) {
        for (int i = 0; i < count; i++) {
            if (i % 150000 == 0) {
                System.out.println("Wrote " + i + " messages");
            }
            log(fl, randomStr(size));
        }
    }

    private static void log(FileLogger fl, String msg) {
        String threadInfo = Thread.currentThread().getId() + ", " + Thread.currentThread().getName();
        String time = timestamp();
        fl.append("ts=<" + time + "> thread_info=<" + threadInfo + ">" + " msg=<" + msg + ">" + "\n");
    }

    static String timestamp() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private static String randomStr(int length) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(index));
        }

        return builder.toString();
    }
}
