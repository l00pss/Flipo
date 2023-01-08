package az.rock.ws.aggregate;

import az.rock.lib.jdomain.aggregate.JAggregateRoot;
import az.rock.lib.util.JDateTime;
import az.rock.lib.value.generic.JRole;
import az.rock.lib.jdomain.id.UserID;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Getter
public class UserRoot extends JAggregateRoot<UserID> {
    private final ZonedDateTime createdDate;
    private final ZonedDateTime modificationDate;
    private final UUID key;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;

    private UserRoot(Builder builder) {
        super.setId(builder.userID);
        this.createdDate = builder.createdDate;
        this.modificationDate = builder.modificationDate;
        key = builder.key;
        username = builder.username;
        firstName = builder.firstName;
        lastName = builder.lastName;
        password = builder.password;
        email = builder.email;
    }

    public UUID getIdValue() {
        return super.getId().getValue();
    }

    public static final class Builder {
        private UserID userID;
        private ZonedDateTime createdDate = JDateTime.UTC.now();
        private ZonedDateTime modificationDate = JDateTime.UTC.now();
        private UUID key;
        private String username;
        private String firstName;
        private String lastName;
        private String password;
        private String email;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }


        public UserRoot.Builder withCreatedDate(ZonedDateTime date) {
            this.createdDate = date;
            return this;
        }

        public UserRoot.Builder withModificationDate(ZonedDateTime date) {
            this.modificationDate = date;
            return this;
        }

        public UserRoot.Builder withCreatedDate(Date date) {
            this.createdDate = JDateTime.of(date);
            return this;
        }

        public UserRoot.Builder withModificationDate(Date date) {
            this.modificationDate = JDateTime.of(date);
            return this;
        }

        public Builder withKey(UUID key) {
            this.key = key;
            return this;
        }


        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }


        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }


        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }


        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }


        public Builder withId(UserID userID) {
            this.userID = userID;
            return this;
        }



        public UserRoot build() {
            return new UserRoot(this);
        }
    }
}
