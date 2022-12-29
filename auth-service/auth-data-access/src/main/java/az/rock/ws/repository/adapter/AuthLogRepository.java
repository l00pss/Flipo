package az.rock.ws.repository.adapter;

import az.rock.ws.aggregate.AuthLogRoot;
import az.rock.ws.mapper.AuthLogDataMapper;
import az.rock.ws.port.output.repository.abstracts.AbstractAuthLogRepository;
import az.rock.ws.repository.AbstractAuthLogJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthLogRepository implements AbstractAuthLogRepository {
    private final AbstractAuthLogJpaRepository abstractAuthLogJPARepository;
    private final AuthLogDataMapper authLogDataMapper;

    public AuthLogRepository(AbstractAuthLogJpaRepository abstractAuthLogJPARepository, AuthLogDataMapper authLogDataMapper) {
        this.abstractAuthLogJPARepository = abstractAuthLogJPARepository;
        this.authLogDataMapper = authLogDataMapper;
    }

    @Override
    public AuthLogRoot createLog(AuthLogRoot root) {
        return null;
    }
}
