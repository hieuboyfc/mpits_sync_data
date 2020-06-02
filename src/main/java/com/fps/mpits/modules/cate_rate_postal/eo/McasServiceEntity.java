package com.fps.mpits.modules.cate_rate_postal.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fps.mpits.logging.AuditingEntityListener;
import com.fps.mpits.modules.app.eo.McasListApproveDataEntity;
import com.fps.mpits.util.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_SERVICE)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasServiceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã dịch vụ
    @Basic
    @Id
    @Column(name = "MAIL_SERVICE_ID", length = 10, nullable = false)
    private String mailServiceId;

    // Tên dịch vụ
    @Basic
    @Column(name = "MAIL_SERVICE_NAME", length = 60, nullable = false)
    private String mailServiceName;

    // Trạng thái 0=deactive, 1=active, -9=delete
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
    @Column(name = "CREATEDBY", length = 50)
    private String createdBy;

    // Người cập nhật
    @Basic
    @Column(name = "UPDATEDBY", length = 50)
    private String updatedBy;

    // Loại sản phẩm dịch vụ (LH - Loại hàng, HH - Hàng hóa)
    @Basic
    @Column(name = "TYPE", length = 5)
    private String type;

    // Phạm vi (Trong nước, quốc tế)
    @Basic
    @Column(name = "SCOPE", length = 50)
    private String scope;

    // Nhập kích thước (0, 1)
    @Basic
    @Column(name = "ISSIZE", length = 5)
    private String isSize;

    // Nhóm dịch vụ (C - Bưu kiện, E - EMS, P - Logisticeco)
    @Basic
    @Column(name = "SERVICE_GROUP", length = 20)
    private String serviceGroup;

    // Thuế xuất: (0 - thuế 0%; 5 - Thuế 5%; 10 - Thuế 10%; K - Không chịu thuế)
    @Basic
    @Column(name = "TAX_EXPORT", length = 5)
    private String taxExport;

    @Transient
    private McasListApproveDataEntity objMcasListApproveDataEntity;

}
