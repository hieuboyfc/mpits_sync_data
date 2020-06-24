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
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_SERVICE_GROUP)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class McasServiceGroupEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Nghiệp vụ (01 - DVBC, 02 - TCBC, 03 - PHBC, 04 - Phân phối hàng hóa)
    @Id
    @Basic
    @Column(name = "SERVICE_REPORT", length = 30, nullable = false)
    private String serviceReport;

    // Mã nhóm dịch vụ
    @Id
    @Basic
    @Column(name = "SERVICE_GROUP_ID", length = 20, nullable = false)
    private String serviceGroupId;

    // Tên nhóm dịch vụ
    @Basic
    @Column(name = "SERVICE_GROUP_NAME", length = 60, nullable = false)
    private String serviceGroupName;

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS", length = 1, nullable = false)
    private int status;

    // Ngày tạo
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;

    // Ngày cập nhật
    @Column(name = "UPDATED")
    @Temporal(TemporalType.DATE)
    private Date updated;

    // Người tạo
    @Basic
    @Column(name = "CREATEDBY", length = 50)
    private String createdBy;

    // Người cập nhật
    @Basic
    @Column(name = "UPDATEDBY", length = 50)
    private String updatedBy;

    public McasServiceGroupEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }
}
