package com.fps.mpits.modules.cate_rate_postal.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fps.mpits.logging.AuditingEntityListener;
import com.fps.mpits.util.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.SerializationUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 13/07/2020 - 17:17
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_ITEM_GROUP_TYPE)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@IdClass(McasItemGroupTypeEntityId.class)
public class McasItemGroupTypeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã nhóm hàng
    @Basic
    @Id
    @Column(name = "ITEM_GROUP_ID", length = 20, nullable = false)
    private String itemGroupId;

    // Mã loại hàng
    @Basic
    @Id
    @Column(name = "ITEM_TYPE_ID", length = 20, nullable = false)
    private String itemTypeId;

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS", length = 1)
    private int status;

    // Ngày tạo
    @Basic
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;

    // Ngày cập nhật
    @Basic
    @Column(name = "UPDATED")
    @Temporal(TemporalType.DATE)
    private Date updated;

    // Người tạo
    @Basic
    @Column(name = "CREATEDBY")
    private String createdBy;

    // Người cập nhật
    @Basic
    @Column(name = "UPDATEDBY")
    private String updatedBy;

    public McasItemGroupTypeEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }
}
