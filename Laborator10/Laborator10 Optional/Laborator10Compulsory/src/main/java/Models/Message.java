package Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "messages", schema = "public")
@NamedQueries({@NamedQuery(name = "Message.findById",
        query = "SELECT p FROM Message p WHERE p.user1=:id")})
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "messages_id_seq")
    private int id;

    @Column(name = "id_user")
    private Integer user1;

    @Column(name = "message")
    private String message;

    public Message(Integer user1, String message) {
        this.user1 = user1;
        this.message = message;
    }
}
