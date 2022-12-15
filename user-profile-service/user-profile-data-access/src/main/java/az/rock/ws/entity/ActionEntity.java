package az.rock.ws.entity;

import az.rock.lib.value.generic.JActionType;
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
@Table(name = "profiles_actions",schema = "profiles")
public class ActionEntity extends BaseEntity{

    @ManyToOne
    private ProfileEntity owner;

    private JActionType JActionType;

    private UUID actionTarget;
}
