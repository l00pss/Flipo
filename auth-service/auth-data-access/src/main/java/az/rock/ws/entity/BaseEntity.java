package az.rock.ws.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false,updatable = false,unique = true)
    private UUID uuid;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modificationDate;
}
