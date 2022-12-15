package az.rock.ws.entity;

import az.rock.lib.value.generic.JSwitch;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Setting")
@Table(name = "users_settings",schema = "users")
public class SettingEntity extends BaseEntity{

    @OneToOne
    private ProfileEntity owner;

    private JSwitch darkTheme;

    private JSwitch messageNotification;

    private JSwitch postNotification;
}
