package az.rock.ws.aggregate;

import az.rock.lib.jdomain.aggregate.JAggregateRoot;
import az.rock.lib.jdomain.id.RootID;
import az.rock.lib.util.JDateTime;
import lombok.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Getter
public class AuthLogRoot extends JAggregateRoot<RootID<UUID>> {
    private final ZonedDateTime createdDate;
    private final ZonedDateTime modificationDate;
    private final UUID userUUID;
    private final String username;
    private final String userPrivateKey;
    private final String ipAddress;
    private final Date authDate;
    private final Boolean state;

    private AuthLogRoot(Builder builder) {
        super(builder.id);
        this.createdDate = builder.createdDate;
        this.modificationDate = builder.modificationDate;
        userUUID = builder.userUUID;
        username = builder.username;
        userPrivateKey = builder.userPrivateKey;
        ipAddress = builder.ipAddress;
        authDate = builder.authDate;
        state = builder.state;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UUID userUUID;
        private String username;
        private String userPrivateKey;
        private String ipAddress;
        private Date authDate;
        private Boolean state;
        private RootID<UUID> id;

        private Builder() {
        }

        public Builder withCreatedDate(ZonedDateTime date) {
            this.createdDate = date;
            return this;
        }

        public Builder withModificationDate(ZonedDateTime date) {
            this.modificationDate = date;
            return this;
        }

        public Builder withCreatedDate(Date date) {
            this.createdDate = JDateTime.of(date);
            return this;
        }

        public Builder withModificationDate(Date date) {
            this.modificationDate = JDateTime.of(date);
            return this;
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

        public Builder withId(RootID<UUID> id) {
            this.id = id;
            return this;
        }

        public AuthLogRoot build() {
            return new AuthLogRoot(this);
        }
    }
}