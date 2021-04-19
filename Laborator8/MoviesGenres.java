public class MoviesGenres {
    private int idMovie;
    private int idGenre;

    public MoviesGenres(int idMovie, int idGenre) {
        this.idMovie = idMovie;
        this.idGenre = idGenre;
    }

    @Override
    public String toString() {
        return "MoviesGenres{" +
                "idMovie=" + idMovie +
                ", idGenre=" + idGenre +
                '}';
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public int getIdMovie() {
        return idMovie;
    }
}
