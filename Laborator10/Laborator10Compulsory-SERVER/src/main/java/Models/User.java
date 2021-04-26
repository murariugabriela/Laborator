package Models;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.json.JSONArray;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users", schema = "public")
@NamedQueries({@NamedQuery(name = "User.findByName",
        query = "SELECT p FROM User p WHERE p.name=:name")})
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonBinaryType.class)
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "users_id_seq")
    private int id;
    @Column(name = "username")
    private String name;
    @Column(name = "friends")
    private String friends;

}
