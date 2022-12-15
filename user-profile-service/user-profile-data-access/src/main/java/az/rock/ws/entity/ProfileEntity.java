package az.rock.ws.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Profile")
@Table(name = "profiles_list", schema = "profiles", indexes = {
        @Index(name = "idx_profileentity_title", columnList = "title")
})
public class ProfileEntity extends BaseEntity {


    private UUID userUUID;

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
