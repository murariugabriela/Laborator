package Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "movies", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Movie.findByName",
                query = "SELECT p FROM Movie p WHERE p.title = :title")})
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "movies_movie_id_seq")
    @Column(name = "movie_id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "release_date")
    private Date release_date;
    @Column(name = "duration")
    private Float duration;
    @Column(name = "score")
    private Float score;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
