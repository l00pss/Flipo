package az.rock.ws.port.input.service.abstracts;

import az.rock.ws.dto.request.AuthLogCommand;

public interface AuthLogService {
    Boolean logAuthenticate(AuthLogCommand command);
}
