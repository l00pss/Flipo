package az.rock.lib.util;

public class HeaderModel {
    private String lang;
    private String userRequestPrivateKey;
    private String ipAddress;
    private String token;

    private HeaderModel(Builder builder) {
        lang = builder.lang;
        userRequestPrivateKey = builder.userRequestPrivateKey;
        ipAddress = builder.ipAddress;
        token = builder.token;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getLang() {
        return lang;
    }

    public String getUserRequestPrivateKey() {
        return userRequestPrivateKey;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getToken() {
        return token;
    }


    public static final class Builder {
        private String lang;
        private String userRequestPrivateKey;
        private String ipAddress;
        private String token;

        private Builder() {
        }

        public Builder withLang(String lang) {
            this.lang = lang;
            return this;
        }

        public Builder withUserRequestPrivateKey(String userRequestPrivateKey) {
            this.userRequestPrivateKey = userRequestPrivateKey;
            return this;
        }

        public Builder withIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Builder withToken(String token) {
            this.token = token;
            return this;
        }

        public HeaderModel build() {
            return new HeaderModel(this);
        }
    }
}
