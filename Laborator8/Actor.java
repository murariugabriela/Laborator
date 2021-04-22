public class Actor extends Director{
    //    actor_id   actor_name   movie_id
    private String charachterPlayed;

    public Actor(int id, String name, int movieId, String charachterPlayed) {
        this.id = id;
        this.name = name;
        this.movieId = movieId;
        this.charachterPlayed = charachterPlayed;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int actorId) {
        this.id = actorId;
    }

    public void setCharachterPlayed(String charachterPlayed) {
        this.charachterPlayed = charachterPlayed;
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

    public String getCharachterPlayed() {
        return charachterPlayed;
    }
}
