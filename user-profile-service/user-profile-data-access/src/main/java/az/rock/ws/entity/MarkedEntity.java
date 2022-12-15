package az.rock.ws.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Marked")
@Table(name = "profiles_marked",schema = "profiles")
public class MarkedEntity extends BaseEntity{

    @ManyToOne
    private ProfileEntity owner;

    private UUID markedComponentUUID;
}
