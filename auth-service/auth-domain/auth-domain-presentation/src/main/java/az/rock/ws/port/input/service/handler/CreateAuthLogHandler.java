package az.rock.ws.port.input.service.handler;

import az.rock.lib.adapter.annotation.JCommandHandler;
import az.rock.lib.message.MessageProvider;
import az.rock.ws.dto.request.AuthLogCommand;
import az.rock.ws.exception.UserDomainException;
import az.rock.ws.mapper.AuthLogDataMapper;
import az.rock.ws.port.output.repository.abstracts.AbstractAuthLogRepository;
import az.rock.ws.service.concretes.AuthLogDomainService;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@JCommandHandler
@Slf4j
public class CreateAuthLogHandler {
    private final AuthLogDomainService authLogDomainService;
    private final AbstractAuthLogRepository authLogRepository;
    private final AuthLogDataMapper authLogDataMapper;
    private final MessageProvider messageProvider;

    public CreateAuthLogHandler(AuthLogDomainService authLogDomainService, AbstractAuthLogRepository authLogRepository, AuthLogDataMapper authLogDataMapper, MessageProvider messageProvider) {
        this.authLogDomainService = authLogDomainService;
        this.authLogRepository = authLogRepository;
        this.authLogDataMapper = authLogDataMapper;
        this.messageProvider = messageProvider;
    }

    public Boolean logAuthenticate(AuthLogCommand command) {
        var root = this.authLogDataMapper.createFromCommand(command);
        var event = this.authLogDomainService.validateAndInitializeUser(root);
        var savedRoot = this.authLogRepository.createLog(root);
        if(Objects.isNull(savedRoot)){
            log.error("Could not save user with id: {}",root.getId().getValue());
            throw new UserDomainException(this.messageProvider.fail("F_0000000003"));
        }
        return true;
    }
}
