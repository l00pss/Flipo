package az.rock.ws.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@Slf4j
public class BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "uuid", nullable = false,updatable = false,unique = true)
    private UUID uuid;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modificationDate;

    @PostLoad
    public void postLoad() {
        log.info("Load Entity ".concat(this.getClass().getName()));
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Update Entity ".concat(this.getClass().getName()));
    }
}
