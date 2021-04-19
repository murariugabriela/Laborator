public class Director {
    private int director_id;
    private String name;
    private int movie_id;

    public Director(int director_id, String name, int movie_id) {
        this.director_id = director_id;
        this.name = name;
        this.movie_id = movie_id;
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

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getDirector_id() {
        return director_id;
    }

    public String getName() {
        return name;
    }

    public int getMovie_id() {
        return movie_id;
    }

}
