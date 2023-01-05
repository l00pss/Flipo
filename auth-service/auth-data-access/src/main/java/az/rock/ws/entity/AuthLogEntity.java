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

    private AuthLogEntity(Builder builder) {
        setUserUUID(builder.userUUID);
        setUsername(builder.username);
        setUserPrivateKey(builder.userPrivateKey);
        setIpAddress(builder.ipAddress);
        setAuthDate(builder.authDate);
        setState(builder.state);
        setUuid(builder.uuid);
        setCreatedDate(builder.createdDate);
        setModificationDate(builder.modificationDate);
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private UUID userUUID;
        private String username;
        private String userPrivateKey;
        private String ipAddress;
        private Date authDate;
        private Boolean state;
        private UUID uuid;
        private Date createdDate;
        private Date modificationDate;

        private Builder() {
        }

        public Builder withUserUUID(UUID userUUID) {
            this.userUUID = userUUID;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withUserPrivateKey(String userPrivateKey) {
            this.userPrivateKey = userPrivateKey;
            return this;
        }

        public Builder withIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Builder withAuthDate(Date authDate) {
            this.authDate = authDate;
            return this;
        }

        public Builder withState(Boolean state) {
            this.state = state;
            return this;
        }

        public Builder withUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder withCreatedDate(Date createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder withModificationDate(Date modificationDate) {
            this.modificationDate = modificationDate;
            return this;
        }

        public AuthLogEntity build() {
            return new AuthLogEntity(this);
        }
    }
}
