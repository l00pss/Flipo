package az.rock.ws.aggregate;

import az.rock.lib.jdomain.aggregate.JAggregateRoot;
import az.rock.lib.jdomain.id.RootID;
import az.rock.lib.util.JDateTime;
import az.rock.lib.value.generic.JRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * This root class is User Based
 * @author Vugar Mammadli
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Getter
public class AuthorityRoot extends JAggregateRoot<RootID<UUID>> {
    private final ZonedDateTime createdDate;
    private final ZonedDateTime modificationDate;
    private final UUID userUUID;
    private final JRole role;

    private AuthorityRoot(Builder builder) {
        super(builder.id);
        createdDate = builder.createdDate;
        modificationDate = builder.modificationDate;
        userUUID = builder.userUUID;
        role = builder.role;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private RootID<UUID> id;
        private ZonedDateTime createdDate = JDateTime.UTC.now();
        private ZonedDateTime modificationDate = JDateTime.UTC.now();
        private UUID userUUID;
        private JRole role;

        private Builder() {
        }


        public Builder withId(RootID<UUID> id) {
            this.id = id;
            return this;
        }

        public Builder withCreatedDate(ZonedDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder withModificationDate(ZonedDateTime modificationDate) {
            this.modificationDate = modificationDate;
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

        public Builder withRole(JRole role) {
            this.role = role;
            return this;
        }


        public AuthorityRoot build() {
            return new AuthorityRoot(this);
        }
    }
}
