package az.rock.ws.mapper;

import az.rock.lib.adapter.annotation.JMapper;
import az.rock.ws.aggregate.AuthLogRoot;
import az.rock.ws.entity.AuthLogEntity;

@JMapper
public class AuthLogEntityMapper {
    public AuthLogRoot factoryFromEntity(AuthLogEntity entity){
        return AuthLogRoot
                .builder()
                .userUUID(entity.getUserUUID())
                .authDate(entity.getAuthDate())
                .ipAddress(entity.getIpAddress())
                .username(entity.getUsername())
                .userPrivateKey(entity.getUserPrivateKey())
                .state(entity.getState())
                .build();
    }

    public AuthLogEntity factoryFromRoot(AuthLogRoot root){
        return AuthLogEntity
                .builder()
                .userUUID(root.getUserUUID())
                .authDate(root.getAuthDate())
                .ipAddress(root.getIpAddress())
                .username(root.getUsername())
                .userPrivateKey(root.getUserPrivateKey())
                .state(root.getState())
                .build();
    }
}
