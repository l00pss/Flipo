package az.rock.ws.repository.adapter;

import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.mapper.UserDataAccessMapper;
import az.rock.ws.port.output.repository.abstracts.AbstractUserRepository;
import az.rock.ws.repository.AbstractUserJPARepository;
import org.springframework.stereotype.Component;

@Component
public class UserRepository implements AbstractUserRepository {
    private final AbstractUserJPARepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;

    public UserRepository(AbstractUserJPARepository userJpaRepository, UserDataAccessMapper userDataAccessMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    @Override
    public UserRoot createUser(UserRoot userRoot) {
        var entity = this.userDataAccessMapper.userToUserEntity(userRoot);
        var savedEntity = this.userJpaRepository.save(entity);
        return this.userDataAccessMapper.userEntityToUser(savedEntity);
    }

    @Override
    public UserRoot findByUsername(String userName) {
        return this.userDataAccessMapper.userEntityToUser(this.userJpaRepository.findByUsername(userName));
    }
}
