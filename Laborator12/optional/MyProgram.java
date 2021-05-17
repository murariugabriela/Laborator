package optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyProgram {
    @BeforeClass
    @Test
    public void m0() { throw new RuntimeException("Non-static test"); }
    @Test
    public static void m1() { }
    public static void m2() { }
    @Test public static void m3() {
        throw new RuntimeException("Boom");
    }
    @Test public static void m9(String message) {
        throw new RuntimeException(message);
    }
    @Test public static void m10(String message, int x) {
        throw new RuntimeException(message + " +  parametrul " + x);
    }
    public static void m4() { }
    @Test public static void m5() { }
    public static void m6() { }
    @Test public static void m7() {
        throw new RuntimeException("Crash");
    }
    public static void m8() { }
}