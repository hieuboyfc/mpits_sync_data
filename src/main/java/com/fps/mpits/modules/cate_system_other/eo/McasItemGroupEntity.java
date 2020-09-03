package com.fps.mpits.modules.cate_system_other.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
 * created 19/05/2020 - 17:30
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_ITEM_GROUP)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasItemGroupEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã nhóm hàng
    @Basic
    @Id
    @Column(name = "ITEM_GROUP_ID", length = 20, nullable = false)
    private String itemGroupId;

    // Tên nhóm hàng
    @Basic
    @Column(name = "ITEM_GROUP_NAME", length = 60, nullable = false)
    private String itemGroupName;

    // Loại nhóm hàng
    @Basic
    @Column(name = "ITEM_GROUP_TYPE", length = 10)
    private String itemGroupType;

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS", length = 1, nullable = false)
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

    public McasItemGroupEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }

}
