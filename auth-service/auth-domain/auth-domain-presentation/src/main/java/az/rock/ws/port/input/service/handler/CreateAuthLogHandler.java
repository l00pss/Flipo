package az.rock.ws.port.input.service.handler;

import az.rock.lib.adapter.annotation.JCommandHandler;
import az.rock.ws.mapper.AuthLogDataMapper;
import az.rock.ws.port.output.repository.abstracts.AbstractAuthLogRepository;
import az.rock.ws.service.concretes.AuthLogDomainService;
import lombok.extern.slf4j.Slf4j;

@JCommandHandler
@Slf4j
public class CreateAuthLogHandler {
    private final AuthLogDomainService authLogDomainService;
    private final AbstractAuthLogRepository authLogRepository;
    private final AuthLogDataMapper authLogDataMapper;

    public CreateAuthLogHandler(AuthLogDomainService authLogDomainService, AbstractAuthLogRepository authLogRepository, AuthLogDataMapper authLogDataMapper) {
        this.authLogDomainService = authLogDomainService;
        this.authLogRepository = authLogRepository;
        this.authLogDataMapper = authLogDataMapper;
    }
}
