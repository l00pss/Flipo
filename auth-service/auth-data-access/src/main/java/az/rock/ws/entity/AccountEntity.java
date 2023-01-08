package az.rock.ws.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_list", schema = "users")
@Entity(name = "AccountEntity")
public class AccountEntity extends BaseEntity {

    @OneToOne
    private UserEntity userEntity;

    @Singular
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "account_autority", joinColumns = {
            @JoinColumn(name = "ACCOUNT_UUID", referencedColumnName = "uuid")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_UUID", referencedColumnName = "UUID")})
    private Set<AuthorityEntity> authorities;

    @Builder.Default
    private Boolean accountNonExpired = Boolean.TRUE;

    @Builder.Default
    private Boolean accountNonLocked = Boolean.TRUE;

    @Builder.Default
    private Boolean credentialsNonExpired = Boolean.TRUE;

    @Builder.Default
    private Boolean isApproved = Boolean.TRUE;

    @Builder.Default
    private Boolean enabled = Boolean.TRUE;


}
