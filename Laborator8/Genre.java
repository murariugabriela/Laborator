public class Genre {
    private int idGenre;
    private String name;


    @Override
    public String toString() {
        return "Genre{" +
                "idGenre=" + idGenre +
                ", name='" + name + '\'' +
                '}';
    }

    public Genre(int id, String name) {
        this.idGenre = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getName() {
        return name;
    }

    public int getIdGenre() {
        return idGenre;
    }
}
