package az.rock.ws.mapper;

import az.rock.lib.adapter.annotation.JMapper;
import az.rock.ws.aggregate.AuthLogRoot;
import az.rock.ws.dto.request.AuthLogCommand;

@JMapper
public class AuthLogDataMapper {
    public AuthLogRoot createFromCommand(AuthLogCommand command){
        return AuthLogRoot
                .builder()
                .withUserUUID(command.getUserUUID())
                .withUsername(command.getUsername())
                .withUserPrivateKey(command.getUserPrivateKey())
                .withIpAddress(command.getIpAddress())
                .withAuthDate(command.getAuthDate())
                .withState(command.getState())
                .build();
    }
}
