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
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_VA_SERVICE)
@Accessors(fluent = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasVaServiceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã dịch vụ GTGT
    @Basic
    @Id
    @Column(name = "VA_SERVICE_ID", length = 100, nullable = false)
    private String vaServiceId;

    // Tên dịch vụ GTGT
    @Basic
    @Column(name = "VA_SERVICE_NAME", length = 100, nullable = false)
    private String vaServiceName;

    // Mã nhóm cước
    @Basic
    @Column(name = "FEE_TYPE_GROUP_ID", length = 20, nullable = false)
    private String feeTypeGroupId;

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

    public McasVaServiceEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }

}
