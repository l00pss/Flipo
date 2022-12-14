package az.rock.ws.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "Post")
@Table(name = "users_posts",schema = "users")
public class PostEntity extends BaseEntity{
    @ManyToOne
    private ProfileEntity profile;

    private UUID postUUID;
}
