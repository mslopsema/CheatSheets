package utils;

public class Log {
    static void println(String s) {
        print(s);
        System.out.println();
    }
    
    static void print(String s) {
        System.out.println(System.currentTimeMillis() + " : " +
                s);
    }
}
