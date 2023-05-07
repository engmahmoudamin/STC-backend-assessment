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
@Table(name = "FILES")
public class FileEntity extends STCAbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "FILE_BINARY")
    private byte[] data;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "id")
    private ItemEntity item;

    @Override
    public Long loadId() {
        return id;
    }

}
