package az.rock.ws.entity;

import az.rock.lib.value.generic.JRole;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_list", schema = "users", indexes = {
        @Index(name = "idx_userentity_username", columnList = "username")
})
@Entity(name = "User")
public class UserEntity extends BaseEntity{

    @Column(name = "key",nullable = false)
    private UUID key;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "role",nullable = false)
    private JRole role;

    @OneToOne
    private ProfileEntity profile;


}
