package az.rock.ws.repository;

import az.rock.ws.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbstractUserJPARepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByUsername(String userName);

    UserEntity findByEmail(String email);

}
