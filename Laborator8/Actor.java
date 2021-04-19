public class Actor {
    //    actor_id   actor_name   movie_id
    private int actor_id;
    private String name;
    private int movie_id;
    private String charachterPlayed;

    public Actor(int actor_id, String name, int movie_id, String charachterPlayed) {
        this.actor_id = actor_id;
        this.name = name;
        this.movie_id = movie_id;
        this.charachterPlayed = charachterPlayed;
    }

    @Override
    public String toString() {
        return "ActorsDAO{" +
                "name='" + name + '\'' +
                ", charachterPlayed='" + charachterPlayed + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public void setCharachterPlayed(String charachterPlayed) {
        this.charachterPlayed = charachterPlayed;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getActor_id() {
        return actor_id;
    }

    public String getName() {
        return name;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public String getCharachterPlayed() {
        return charachterPlayed;
    }
}
