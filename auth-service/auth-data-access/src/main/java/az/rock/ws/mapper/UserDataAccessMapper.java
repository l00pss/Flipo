package az.rock.ws.mapper;

import az.rock.lib.adapter.annotation.JMapper;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.entity.UserEntity;

@JMapper
public class UserDataAccessMapper {
    public UserRoot userEntityToUser(UserEntity entity){
        return UserRoot.Builder
                .builder()
                .build();
    }

    public UserEntity userToUserEntity(UserRoot root){
        return UserEntity
                .builder()
                .build();
    }
}
