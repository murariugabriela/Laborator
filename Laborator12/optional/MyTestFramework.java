package optional;

import compulsory.MyClassLoader;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.io.FilenameUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MyTestFramework {
    public static void main(String[] args) throws Exception {
        int passed = 0, failed = 0;
        compulsory.MyClassLoader myLoader1 = new MyClassLoader();
        //Optional
        //parcurgere recursiva
        List<Object> allFiles = new ArrayList<>(Arrays.asList(Files.walk(Paths.get(args[1])).toArray()));
        System.out.println(allFiles + "\n");
        List<File> files = new ArrayList<>();
        List<File> jarFiles = new ArrayList<>();
        for (Object file : allFiles) {
            if(Paths.get(file.toString()).toFile().isFile() && FilenameUtils.getExtension(Paths.get(file.toString()).toFile().getName()).equalsIgnoreCase("class"))
                files.add(Paths.get(file.toString()).toFile());
            if(Paths.get(file.toString()).toFile().isFile() && FilenameUtils.getExtension(Paths.get(file.toString()).toFile().getName()).equalsIgnoreCase("java"))
                jarFiles.add(Paths.get(file.toString()).toFile());
        }
        for (File jarFile : jarFiles) {
            BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Gabi\\Desktop\\Laborator12\\src\\main\\java\\test"));
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> compilationUnits1 =
                    fileManager.getJavaFileObjectsFromFiles(Arrays.asList(jarFile));
            compiler.getTask(out, fileManager, null, null, null, compilationUnits1).call();

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
                        passed++;
                    } catch (Throwable ex) {
                        System.out.printf("Test %s failed: %s %n",
                                m, ex.getCause());
                        failed++;
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
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}