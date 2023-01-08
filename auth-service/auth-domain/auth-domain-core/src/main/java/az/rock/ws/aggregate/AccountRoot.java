package az.rock.ws.aggregate;

import az.rock.lib.jdomain.aggregate.JAggregateRoot;
import az.rock.lib.jdomain.id.RootID;
import az.rock.lib.util.JDateTime;
import az.rock.lib.value.generic.JRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@Getter
public class AccountRoot extends JAggregateRoot<RootID<UUID>> {
    private final ZonedDateTime createdDate;
    private final ZonedDateTime modificationDate;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    private Boolean isApproved;
    private Set<AuthorityRoot> authorities = new HashSet<>();

    private AccountRoot(Builder builder) {
        super(builder.uuidRootID);
        createdDate = builder.createdDate;
        modificationDate = builder.modificationDate;
        accountNonExpired = builder.accountNonExpired;
        accountNonLocked = (builder.accountNonLocked);
        credentialsNonExpired = (builder.credentialsNonExpired);
        enabled = (builder.enabled);
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private RootID<UUID> uuidRootID;
        private ZonedDateTime createdDate  = JDateTime.UTC.now();
        private ZonedDateTime modificationDate = JDateTime.UTC.now();
        private Boolean accountNonExpired = Boolean.TRUE;
        private Boolean accountNonLocked = Boolean.TRUE;
        private Boolean credentialsNonExpired = Boolean.TRUE;
        private Boolean enabled = Boolean.TRUE;
        private Boolean isApproved = Boolean.FALSE;
        private Set<AuthorityRoot> authorities = new HashSet<>();

        private Builder() {}

        public Builder withId(RootID<UUID> rootID) {
            this.uuidRootID = rootID;
            return this;
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

        public Builder withAccountNonExpired(Boolean accountNonExpired) {
            this.accountNonExpired = accountNonExpired;
            return this;
        }

        public Builder withAccountNonLocked(Boolean accountNonLocked) {
            this.accountNonLocked = accountNonLocked;
            return this;
        }

        public Builder withCredentialsNonExpired(Boolean credentialsNonExpired) {
            this.credentialsNonExpired = credentialsNonExpired;
            return this;
        }

        public Builder withEnabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder withApproved(Boolean isApproved) {
            this.isApproved = isApproved;
            return this;
        }

        public Builder withAuthorities(Set<AuthorityRoot> authorities) {
            this.authorities = authorities;
            return this;
        }

        public Builder addAuthority(AuthorityRoot authority) {
            this.authorities.add(authority);
            return this;
        }

        public Builder removeAuthority(AuthorityRoot authority) {
            this.authorities.remove(authority);
            return this;
        }

        public AccountRoot build() {
            if (this.authorities.isEmpty())
                this.authorities.add(AuthorityRoot.builder().withRole(JRole.ROLE_GUEST).build());
            return new AccountRoot(this);
        }

    }

    public Boolean isGuest(){
        var authority = this.authorities.stream().findFirst();
        return authority.isPresent() && authority.get().getRole().equals(JRole.ROLE_GUEST);
    }

    public Boolean isUser(){
        var authority = this.authorities.stream().findFirst();
        return authority.isPresent() && authority.get().getRole().equals(JRole.ROLE_USER);
    }

    public Boolean isCompany(){
        var authority = this.authorities.stream().findFirst();
        return authority.isPresent() && authority.get().getRole().equals(JRole.ROLE_COMPANY);
    }

    public Boolean isActive(){
        return this.enabled && this.accountNonLocked && this.accountNonExpired && this.credentialsNonExpired && this.isApproved;
    }
}
