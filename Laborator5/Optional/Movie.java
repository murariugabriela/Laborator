public class Movie extends Item{

    private int year;
    Movie(String name, String path) {
        super(name,path);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}