package Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "friendships", schema = "public")
@NamedQueries({@NamedQuery(name = "Friendships.findById",
        query = "SELECT distinct p FROM Friendships p WHERE p.user1=:id"), @NamedQuery(name = "Friendships.getAll",
        query = "SELECT distinct p FROM Friendships p")})
public class Friendships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "friendships_id_seq")
    private int id;

    @Column(name = "id_user_1")
    private Integer user1;

    @Column(name = "id_user_2")
    private Integer user2;

    public Friendships(Integer user1, Integer user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
}
