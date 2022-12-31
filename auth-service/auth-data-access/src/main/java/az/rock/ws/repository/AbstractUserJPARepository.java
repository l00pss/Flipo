package az.rock.ws.repository;

import az.rock.ws.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractUserJPARepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByUsername(String userName);

    UserEntity findByEmail(String email);
}
