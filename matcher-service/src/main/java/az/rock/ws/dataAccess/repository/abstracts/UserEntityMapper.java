package az.rock.ws.dataAccess.repository.abstracts;

import az.rock.ws.dataAccess.entity.UserEntity;
import az.rock.ws.dataAccess.entity.UserEntityExample;
import java.util.List;

public interface UserEntityMapper {

    List<UserEntity> selectByExample(UserEntityExample example);

    UserEntity selectByPrimaryKey(String uuid);

    UserEntity selectByUsername(String userName);

}