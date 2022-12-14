package az.rock.ws.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "Profile")
@Table(name = "users_profiles",schema = "users")
public class ProfileEntity extends BaseEntity {

    @OneToOne
    private UserEntity owner;

    private Boolean isApproved = Boolean.FALSE;

    private Byte[] coverImage;

    private Byte[] profileImage;

    private String title;

    private String about;

    private String link;

    private String phoneNumber;

    private String publicEmail;
}
