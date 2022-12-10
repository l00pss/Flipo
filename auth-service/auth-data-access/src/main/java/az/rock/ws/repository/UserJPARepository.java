package az.rock.ws.repository;

import az.rock.ws.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJPARepository extends JpaRepository<UserEntity, UUID> {
}
