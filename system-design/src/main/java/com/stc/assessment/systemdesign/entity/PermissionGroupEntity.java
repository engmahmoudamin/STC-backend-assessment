package com.stc.assessment.systemdesign.entity;

import com.stc.assessment.systemdesign.common.entity.STCAbstractEntity;
import javax.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PERMISSION_GROUPS")
public class PermissionGroupEntity extends STCAbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "GROUP_NAME")
    private String groupName;

    @Override
    public Long loadId() {
        return id;
    }
}
