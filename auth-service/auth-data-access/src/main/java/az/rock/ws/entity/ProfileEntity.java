package az.rock.ws.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Profile")
@Table(name = "users_profiles", schema = "users", indexes = {
        @Index(name = "idx_profileentity_title", columnList = "title")
})
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

    @OneToMany
    private List<PostEntity> posts;
}
