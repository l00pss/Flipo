package az.rock.ws.entity;

import az.rock.lib.value.generic.JRole;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false,updatable = false,unique = true)
    private UUID uuid;

    private UUID key;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private JRole role;

}
