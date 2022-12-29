package az.rock.ws.port.input.service.concretes;

import az.rock.lib.adapter.annotation.JInputService;
import az.rock.ws.dto.request.AuthLogCommand;
import az.rock.ws.port.input.service.abstracts.AuthLogService;
import az.rock.ws.port.input.service.handler.CreateAuthLogHandler;

@JInputService
public class AuthLogManager implements AuthLogService {
    private final CreateAuthLogHandler authLogHandler;

    public AuthLogManager(CreateAuthLogHandler authLogHandler) {
        this.authLogHandler = authLogHandler;
    }


    @Override
    public Boolean logAuthenticate(AuthLogCommand command) {

        return true;
    }
}
