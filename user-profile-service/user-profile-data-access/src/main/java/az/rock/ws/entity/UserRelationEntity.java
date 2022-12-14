package az.rock.ws.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "profiles_relations", schema = "profiles", indexes = {
        @Index(name = "idx_userrelationentity", columnList = "is_approved")
})
public class UserRelationEntity {
    @EmbeddedId
    UserRelationIDEntity id;

    @ManyToOne
    @MapsId("request_id")
    @JoinColumn(name = "request_id",updatable = false)
    ProfileEntity request_id;

    @ManyToOne
    @MapsId("approve_id")
    @JoinColumn(name = "approve_id",updatable = false)
    ProfileEntity approve_id;

    @CreatedDate
    private Date createdDate;

    @Column(name = "is_approved",nullable = false)
    private Boolean isApproved;

}
