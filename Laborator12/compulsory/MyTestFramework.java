package compulsory;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.*;
import java.util.Arrays;

public class MyTestFramework {
    public static void main(String[] args) throws Exception {
        int passed = 0, failed = 0;
        for (Method m : Class.forName(args[0]).getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
        MyClassLoader myLoader1 = new MyClassLoader();

        Class clasa = myLoader1.loadClass(args[0]);
        System.out.println("Package: " + clasa.getPackage());
        System.out.println("Metode: " + Arrays.toString(clasa.getMethods()));

    }
}