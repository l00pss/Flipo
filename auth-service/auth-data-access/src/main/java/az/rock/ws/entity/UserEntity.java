package az.rock.ws.entity;

import az.rock.lib.value.generic.JRole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_list", schema = "users", indexes = {
        @Index(name = "idx_userentity_username", columnList = "username")
})
@Entity(name = "UserEntity")
public class UserEntity extends BaseEntity{

    @Column(name = "key",nullable = false,unique = true)
    private UUID key;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "username",nullable = false,unique = true)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Email
    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @OneToOne
    private AccountEntity account;


}
