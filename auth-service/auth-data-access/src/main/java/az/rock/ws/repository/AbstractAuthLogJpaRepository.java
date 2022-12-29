package az.rock.ws.repository;

import az.rock.ws.entity.AuthLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractAuthLogJpaRepository extends JpaRepository<AuthLogEntity, UUID> {
}
