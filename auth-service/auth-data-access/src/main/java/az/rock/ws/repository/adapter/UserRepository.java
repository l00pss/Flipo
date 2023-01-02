package az.rock.ws.repository.adapter;

import az.rock.lib.message.MessageProvider;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.exception.UserNotFoundJException;
import az.rock.ws.mapper.UserDataAccessMapper;
import az.rock.ws.port.output.repository.abstracts.AbstractUserRepository;
import az.rock.ws.repository.AbstractUserJPARepository;
import org.springframework.stereotype.Component;

@Component
public class UserRepository implements AbstractUserRepository {
    private final AbstractUserJPARepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;
    private final MessageProvider messageProvider;

    public UserRepository(AbstractUserJPARepository userJpaRepository, UserDataAccessMapper userDataAccessMapper, MessageProvider messageProvider) {
        this.userJpaRepository = userJpaRepository;
        this.userDataAccessMapper = userDataAccessMapper;
        this.messageProvider = messageProvider;
    }

    @Override
    public UserRoot createUser(UserRoot userRoot) {
        var entity = this.userDataAccessMapper.userToUserEntity(userRoot);
        var savedEntity = this.userJpaRepository.save(entity);
        return this.userDataAccessMapper.userEntityToUser(savedEntity);
    }

    @Override
    public UserRoot findByUsername(String userName) {
        var entity = this.userJpaRepository.findByUsername(userName.toLowerCase());
        if (entity.isEmpty()) throw new UserNotFoundJException(this.messageProvider.fail("F_0000000001"));
        return this.userDataAccessMapper.userEntityToUser(entity.get());
    }

    @Override
    public UserRoot findByEmail(String userName) {
        return this.userDataAccessMapper.userEntityToUser(this.userJpaRepository.findByEmail(userName));
    }
}
