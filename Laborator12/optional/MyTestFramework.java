package optional;

import compulsory.MyClassLoader;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.io.FilenameUtils;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MyTestFramework {
    public static void main(String[] args) throws Exception {
        compulsory.MyClassLoader myLoader1 = new MyClassLoader();
        //Optional
        //parcurgere recursiva
        List<Object> allFiles = new ArrayList<>(Arrays.asList(Files.walk(Paths.get(args[1])).toArray()));
        System.out.println(allFiles + "\n");
        List<File> files = new ArrayList<>();
        for (Object file : allFiles) {
            if(Paths.get(file.toString()).toFile().isFile() && FilenameUtils.getExtension(Paths.get(file.toString()).toFile().getName()).equalsIgnoreCase("class"))
                files.add(Paths.get(file.toString()).toFile());
        }
        for (File file : files) {
            Class clasa = myLoader1.loadClass(file.getParentFile().getName() + "." + file.getName().substring(0, file.getName().indexOf('.')));
            System.out.println("Class: " + clasa.getName());
            System.out.println("Package: " + clasa.getPackage());
            System.out.println("Methods: " + Arrays.toString(clasa.getMethods()));
            System.out.println("Is Annotation: " + clasa.getClass().isAnnotation());
            System.out.println("Constructors: " + Arrays.toString(clasa.getConstructors()));
            System.out.println("Declared fields: " + Arrays.toString(clasa.getClass().getDeclaredFields()) + "\n");
            for (Method m : Class.forName(clasa.getName()).getMethods()) {
                if (m.isAnnotationPresent(Test.class) && Modifier.isStatic(m.getModifiers())) {
                    try {
                        if(m.getParameterCount() > 0) {
                            Object[] arguments = new Object[m.getParameterCount()];
                            for (int i = 0; i < m.getParameterCount(); i++) {
                                if(m.getParameterTypes()[i] == String.class)
                                    arguments[i] = "Method with String parameter";
                                else
                                    arguments[i] = i;
                            }
                            m.invoke(clasa.getConstructor().newInstance(), arguments);
                        }
                        else
                            m.invoke(clasa.getConstructor().newInstance());
                    } catch (Throwable ex) {
                        System.out.printf("Test %s failed: %s %n",
                                m, ex.getCause());
                    }

                }
                else if(m.isAnnotationPresent(Test.class)){
//                    System.out.println(m.getName());
                    m = clasa.getDeclaredMethod(m.getName());
                    try {
                    String result = (String) m.invoke(clasa.getConstructor().newInstance());
                    System.out.println(result);
                    } catch (Throwable ex) {
                        System.out.printf("Test %s failed: %s %n",
                                m, ex.getCause());
                    }
                }
            }
        }
    }
}