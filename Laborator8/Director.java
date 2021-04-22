public class Director{
    protected String name;
    protected Integer id;
    protected Integer movieId;

    public Director(){}
    public Director(int directorId, String name, int movieId) {
        this.id = directorId;
        this.name = name;
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int directorId) {
        this.id = directorId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMovieId() {
        return movieId;
    }

}
