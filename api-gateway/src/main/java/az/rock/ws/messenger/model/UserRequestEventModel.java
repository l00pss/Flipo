package az.rock.ws.messenger.model;

import az.rock.lib.kafka.model.EventModel;

public class UserRequestEventModel extends EventModel {
    private String userUUID;
    private String userPrivateKey;
    private String ipAddress;

    private UserRequestEventModel(Builder builder) {
        userUUID = builder.userUUID;
        userPrivateKey = builder.userPrivateKey;
        ipAddress = builder.ipAddress;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUserUUID() {
        return userUUID;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getUserPrivateKey() {
        return userPrivateKey;
    }

    public static final class Builder {
        private String userUUID;
        private String userPrivateKey;
        private String ipAddress;

        private Builder() {
        }

        public Builder withUserUUID(String userUUID) {
            this.userUUID = userUUID;
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

        public UserRequestEventModel build() {
            return new UserRequestEventModel(this);
        }
    }
}
