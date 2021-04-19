public class Movie {
    private int idMovie;
    private String name;
    private String releaseDate;
    private float duration;
    private float score;

    public Movie(int idMovie, String name, String releaseDate, float duration, float score) {
        this.idMovie = idMovie;
        this.name = name;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" + "id='" + idMovie + "\'" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public float getDuration() {
        return duration;
    }

    public float getScore() {
        return score;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}

