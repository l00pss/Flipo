package az.rock.ws.aggregate;

import az.rock.lib.jdomain.aggregate.JAggregateRoot;
import az.rock.lib.jdomain.id.UserID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Getter
public class AuthLogRoot extends JAggregateRoot<UserID> {

}