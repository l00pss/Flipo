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
@Table(name = "users_list",schema = "users")
@Entity(name = "User")
public class UserEntity extends BaseEntity{

    private UUID key;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private JRole role;

    @OneToOne
    private SettingEntity setting;

    @OneToOne
    private ProfileEntity profile;

    @OneToMany
    private List<MarkedEntity> markedList;

    @OneToMany
    private List<ActionEntity> actions;
}
