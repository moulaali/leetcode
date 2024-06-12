import java.util.*;

/**
 * https://leetcode.com/problems/exclusive-time-of-functions/description/
 * 
 * Exclusive time based on start time and end time
 *
 * Approach :
 * 1/ when we see a start and stack is empty -> push it to stack
 * 2/ when we see a start and see stack is not empty -> it should be a start, we will update the run time and
 * add a pause event on top of stack
 * 3/ when we see a end and stack top is start -> update the run time and pop off the top. also check the top
 * of stack, if there is a pause, pop it and add a start event at that time
 */
public class ExclusiveTime {

    public static void main(String[] args) {
        exclusiveTime(new String[]{
            "0:start:0",
            "0:start:2", // 2
            "0:end:5", // 3
            "0:start:6",
            "0:end:6",
            "0:end:7"
        });

        exclusiveTime(new String[]{
            "0:start:0",
            "0:start:2", // 2
            "0:end:5", // 3
            "1:start:6",
            "1:end:6",
            "0:end:7"
        });
    }

    static void exclusiveTime(String[] logs) {
        Stack<Log> s = new Stack<>();
        Map<String, Integer> times = new HashMap<>();

        int lastFnEnd = 0;
        for (int i = 0; i < logs.length; i++) {
            Log l = Log.fromLog(logs[i]);

            if (l.type.equals("start")) {
                if (!s.empty()) {
                    // Another call. replace with pause and update the time
                    Log top = s.pop();
                    Integer cur = times.getOrDefault(top.id, 0);
                    int delta = (l.ts - top.ts);
                    times.put(top.id, cur + delta);
                    System.out.println("case: inflight start :Log entry : " + l + " : time update " + (cur + delta));
                    s.push(Log.fromLog(top.id + ":pause:" + l.ts));
                } else {
                    System.out.println("case: normal start : Log entry : " + l);
                }

                s.push(l);
            }

            if (l.type.equals("end")) {
                if (s.empty()) {
                    throw new RuntimeException("Bad log entry at " + l);
                }

                Log top = s.pop();
                // there is a start
                if (top.type.equals("start")) {
                    Integer cur = times.getOrDefault(l.id, 0);
                    int delta = (l.ts - top.ts) + 1;
                    times.put(l.id, cur + delta);
                    System.out.println("case: normal end : Log entry : " + l + " : time update " + (cur + delta));
                }

                if (!s.isEmpty() && s.peek().type.equals("pause")) {
                    // push a new start event
                    s.pop();
                    String newEntry = top.id + ":start:" + (l.ts + 1);
                            System.out.println("Adding a new start. Log entry : " + newEntry);
                    s.push(Log.fromLog(newEntry));
                }
            }
        }

        System.out.println("Times : \n" + times);
    }
}

class Log {
    String id;
    String type;
    int ts;
    String log;

    static Log fromLog(String log) {
        String[] parts = log.split(":");

        return new Log(parts[0], parts[1], parts[2], log);
    }

    Log(String id, String type, String ts, String log) {
        this.id = id;
        this.type = type;
        this.ts = Integer.parseInt(ts);
        this.log = log;
    }

    @Override
    public String toString() {
        return log;
    }
}
