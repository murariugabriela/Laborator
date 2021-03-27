import java.io.Serializable;

public abstract class Item implements Serializable {
    private String name;
    private String path;

    public void setName(String name) {
        this.name = name;
    }

    Item(String name, String path){
        setPath(path);
        setName(name);
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}