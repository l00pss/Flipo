package az.rock.ws.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "uuid", nullable = false,updatable = false,unique = true)
    private UUID uuid;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modificationDate;
}
