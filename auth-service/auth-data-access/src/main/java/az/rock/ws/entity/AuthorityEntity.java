package az.rock.ws.entity;

import az.rock.lib.value.generic.JRole;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authority_list", schema = "users")
@Entity(name = "AuthorityEntity")
public class AuthorityEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private JRole role;

    @ManyToMany(mappedBy = "authorities")
    private Set<AccountEntity> accounts;

}
