package com.stc.assessment.systemdesign.entity;

import com.stc.assessment.systemdesign.common.entity.STCAbstractEntity;
import javax.persistence.*;

import com.stc.assessment.systemdesign.enums.ItemType;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ITEMS")
public class ItemEntity extends STCAbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "TYPE")
    private ItemType type;

    @Basic
    @Column(name = "NAME")
    private String name;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "id")
    private ItemEntity parentItem;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PERMISSION_GROUP_ID", referencedColumnName = "id")
    private PermissionGroupEntity permissionGroup;

    @Override
    public Long loadId() {
        return id;
    }
}
