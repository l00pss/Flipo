package az.rock.ws.port.output.repository.abstracts;

import az.rock.ws.aggregate.UserRoot;

public interface AbstractUserRepository {
    UserRoot createUser(UserRoot userRoot);

    UserRoot findByUsername(String userName);

    UserRoot findByEmail(String userName);
}
