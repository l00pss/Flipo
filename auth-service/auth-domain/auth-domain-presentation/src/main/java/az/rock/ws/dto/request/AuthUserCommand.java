package az.rock.ws.dto.request;

public record AuthUserCommand(
        String username,
        String password,
        String privateKey
) {
    public AuthUserCommand(String username,String password,String privateKey){
        this.username = username;
        this.password = password;
        this.privateKey = privateKey;
    }

    @Override
    public String toString() {
        return this.username;
    }
}