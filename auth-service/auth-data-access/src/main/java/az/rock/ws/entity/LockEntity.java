package az.rock.ws.entity;

import az.rock.lib.value.generic.JLockType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lock_list", schema = "users")
@Entity(name = "LockEntity")
public class LockEntity extends BaseEntity{

    @Column(name = "account_uuid",nullable = false)
    private UUID accountUUID;

    @Column(name = "reason",nullable = false)
    private String reason;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "is_active_lock",nullable = false)
    private Boolean isActive;

    @ElementCollection(targetClass = JLockType.class)
    @JoinTable(name = "lock_types", joinColumns = @JoinColumn(name = "uuid"))
    @Column(name = "lock", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<JLockType> lockTypes;
}
