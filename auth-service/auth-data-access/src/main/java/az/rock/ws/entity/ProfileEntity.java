package az.rock.ws.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Profile")
@Table(name = "users_profiles", schema = "users", indexes = {
        @Index(name = "idx_profileentity_title", columnList = "title")
})
public class ProfileEntity extends BaseEntity {

    @OneToOne
    private UserEntity owner;

    private Boolean isPrivate  = Boolean.FALSE;

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

    @OneToOne
    private SettingEntity setting;

    @OneToMany
    private List<MarkedEntity> markedList;

    @OneToMany
    private List<ActionEntity> actions;


}
