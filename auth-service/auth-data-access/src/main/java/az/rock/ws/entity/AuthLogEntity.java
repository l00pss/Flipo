package az.rock.ws.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_auth_log", schema = "auth", indexes = {
        @Index(name = "idx_authlog_username", columnList = "username")
})
@Entity(name = "AuthLog")
public class AuthLogEntity extends BaseEntity{

    @Column(name = "user_uuid")
    private UUID userUUID;

    @Column(name = "username")
    private String username;

    @Column(name = "user_private_key")
    private String userPrivateKey;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "auth_date")
    private Date authDate;

    @Column(name = "state")
    private Boolean state;


}
