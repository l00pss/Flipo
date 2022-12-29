package az.rock.ws.mapper;

import az.rock.lib.adapter.annotation.JMapper;
import az.rock.ws.aggregate.AuthLogRoot;
import az.rock.ws.dto.request.AuthLogCommand;

@JMapper
public class AuthLogDataMapper {
    public AuthLogRoot createFromCommand(AuthLogCommand command){
        return AuthLogRoot
                .builder()
                .userUUID(command.getUserUUID())
                .username(command.getUsername())
                .userPrivateKey(command.getUserPrivateKey())
                .ipAddress(command.getIpAddress())
                .authDate(command.getAuthDate())
                .state(command.getState())
                .build();
    }
}
