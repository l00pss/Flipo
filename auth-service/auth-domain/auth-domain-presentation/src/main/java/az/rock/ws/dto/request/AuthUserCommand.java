package az.rock.ws.dto.request;


public record AuthUserCommand(
        String username,
        String password
) {
    public AuthUserCommand(String username,String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return this.username;
    }
}
