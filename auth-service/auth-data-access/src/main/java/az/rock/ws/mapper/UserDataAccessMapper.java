package az.rock.ws.mapper;

import az.rock.lib.adapter.annotation.JMapper;
import az.rock.lib.jdomain.id.UserID;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.entity.UserEntity;

import java.util.UUID;

@JMapper
public class UserDataAccessMapper {
    public UserRoot userEntityToUser(UserEntity entity){
        return UserRoot.Builder
                .builder()
                .withId(new UserID(entity.getUuid()))
                .withKey(entity.getKey())
                .withUsername(entity.getUsername())
                .withFirstName(entity.getFirstName())
                .withLastName(entity.getLastName())
                .withEmail(entity.getEmail())
                .withPassword(entity.getPassword())
                .build();
    }

    public UserEntity userToUserEntity(UserRoot root){
        return UserEntity
                .builder()
                .key(UUID.randomUUID())
                .email(root.getEmail())
                .firstName(root.getFirstName())
                .lastName(root.getLastName())
                .username(root.getUsername())
                .password(root.getPassword())
                .build();
    }
}
