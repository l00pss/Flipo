package az.rock.lib.value.generic;

import az.rock.lib.value.annotation.ValueObject;

@ValueObject
public class JCredential {
    private String username;
    private String password;


    public JCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
