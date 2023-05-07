package com.stc.assessment.systemdesign.entity;

import com.stc.assessment.systemdesign.common.entity.STCAbstractEntity;
import javax.persistence.*;

import com.stc.assessment.systemdesign.enums.PermissionLevel;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PERMISSIONS")
public class PermissionEntity extends STCAbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Basic
    @Column(name = "PERMISSION_LEVEL")
    private PermissionLevel permissionLevel;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "id")
    private PermissionGroupEntity permissionGroup;

    @Override
    public Long loadId() {
        return id;
    }
}
