package az.rock.ws.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserRelationIDEntity implements Serializable {
    @Column(name = "request_id")
    UUID request_id;

    @Column(name = "approve_id")
    UUID approve_id;
}
