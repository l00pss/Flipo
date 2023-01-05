package az.rock.ws.mapper;

import az.rock.lib.adapter.annotation.JMapper;
import az.rock.lib.jdomain.id.RootID;
import az.rock.ws.aggregate.AuthLogRoot;
import az.rock.ws.entity.AuthLogEntity;

import java.util.UUID;

@JMapper
public class AuthLogEntityMapper {
    public AuthLogRoot factoryFromEntity(AuthLogEntity entity){
        return AuthLogRoot
                .builder()
                .withId(RootID.of())
                .withUserUUID(entity.getUserUUID())
                .withAuthDate(entity.getAuthDate())
                .withIpAddress(entity.getIpAddress())
                .withUsername(entity.getUsername())
                .withUserPrivateKey(entity.getUserPrivateKey())
                .withState(entity.getState())
                .build();
    }

    public AuthLogEntity factoryFromRoot(AuthLogRoot root){
        return AuthLogEntity
                .builder()
                .withUuid(UUID.randomUUID())
                .withUserUUID(root.getUserUUID())
                .withAuthDate(root.getAuthDate())
                .withIpAddress(root.getIpAddress())
                .withUsername(root.getUsername())
                .withUserPrivateKey(root.getUserPrivateKey())
                .withState(root.getState())
                .build();
    }
}
