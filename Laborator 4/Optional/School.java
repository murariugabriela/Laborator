package faker;

public class School implements Comparable<School> {
    private String name;
    private int capacity;

    School(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(School o) {
        return this.getName().compareTo(o.getName());
    }

}
