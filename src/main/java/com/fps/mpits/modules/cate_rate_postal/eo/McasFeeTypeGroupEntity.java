package com.fps.mpits.modules.cate_rate_postal.eo;

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
@Table(name = Constant.EntityTable.MCAS_FEE_TYPE_GROUP)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasFeeTypeGroupEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã nhóm cước
    @Basic
    @Id
    @Column(name = "FEE_TYPE_GROUP_ID", length = 10, nullable = false)
    private String feeTypeGroupId;

    // Tên nhóm cước
    @Basic
    @Column(name = "FEE_TYPE_GROUP_NAME", length = 60, nullable = false)
    private String feeTypeGroupName;

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

    public McasFeeTypeGroupEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }
}
