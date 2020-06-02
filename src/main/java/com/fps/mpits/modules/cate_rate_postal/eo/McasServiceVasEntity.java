package com.fps.mpits.modules.cate_rate_postal.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
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
@Table(name = Constant.EntityTable.MCAS_SERVICE_VAS)
@Accessors(fluent = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@IdClass(McasServiceVasEntityId.class)
public class McasServiceVasEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã dịch vụ GTGT
    @Basic
    @Id
    @Column(name = "VA_SERVICE_ID", length = 100, nullable = false)
    private String vaServiceId;

    // Mã dịch vụ
    @Basic
    @Id
    @Column(name = "MAIL_SERVICE_ID", length = 10, nullable = false)
    private String mailServiceId;

    // Trạng thái 0=deactive, 1=active, -9=delete
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

    @Transient
    private McasVaServiceEntity mcasVaServiceEntity;

    @Transient
    private McasServiceEntity mcasServiceEntity;

    @Transient
    private McasListApproveDataEntity objMcasListApproveDataEntity;

}