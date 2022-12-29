package az.rock.ws.repository.adapter;

import az.rock.ws.aggregate.AuthLogRoot;
import az.rock.ws.mapper.AuthLogEntityMapper;
import az.rock.ws.port.output.repository.abstracts.AbstractAuthLogRepository;
import az.rock.ws.repository.AbstractAuthLogJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthLogRepository implements AbstractAuthLogRepository {
    private final AbstractAuthLogJpaRepository authLogJpaRepository;
    private final AuthLogEntityMapper authLogEntityMapper;

    public AuthLogRepository(AbstractAuthLogJpaRepository authLogJpaRepository, AuthLogEntityMapper authLogEntityMapper) {
        this.authLogJpaRepository = authLogJpaRepository;
        this.authLogEntityMapper = authLogEntityMapper;
    }

    @Override
    public AuthLogRoot createLog(AuthLogRoot root) {
        var entity = this.authLogEntityMapper.factoryFromRoot(root);
        var savedEntity  = this.authLogJpaRepository.save(entity);
        return this.authLogEntityMapper.factoryFromEntity(savedEntity);
    }
}
