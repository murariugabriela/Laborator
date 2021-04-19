package Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "actors", schema = "public")
@NamedQueries({@NamedQuery(name = "Actor.findByName",
        query = "SELECT p FROM Actor p WHERE p.name=:name")})
public class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "actors_actor_id_seq")
    private int id;
    @Column(name = "actor_name")
    private String name;
    @Column(name = "character_played_name")
    private String characterPlayed;
    @Column(name = "movie_id")
    private int movieId;


}
