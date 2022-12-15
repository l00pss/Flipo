package az.rock.ws.entity;

import az.rock.ws.valueObject.ActionType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Action")
@Table(name = "users_actions",schema = "users")
public class ActionEntity extends BaseEntity{

    @ManyToOne
    private ProfileEntity owner;

    private ActionType actionType;

    private UUID actionTarget;
}
