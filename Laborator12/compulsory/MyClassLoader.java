package compulsory;

import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader extends URLClassLoader {
    public MyClassLoader() {
        super(new URL[0], ClassLoader.getSystemClassLoader());
    }
}

