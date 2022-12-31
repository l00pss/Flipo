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

    @Column(name = "created_date", nullable = false)
    private Date createdDate ;

    @Column(name = "modification_date")
    private Date modificationDate = new Date();


    @PrePersist
    public void prePersist() {
        this.createdDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.modificationDate = new Date();
    }
}
