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
import java.util.List;

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_ITEM_TYPE)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasItemTypeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã loại hàng
    @Basic
    @Id
    @Column(name = "ITEM_TYPE_ID", length = 20, nullable = false)
    private String itemTypeId;

    // Tên loại hàng
    @Basic
    @Column(name = "ITEM_TYPE_NAME", length = 100, nullable = false)
    private String itemTypeName;

    // Mã nhóm hàng
    @Basic
    @Column(name = "ITEM_GROUP_ID", length = 60, nullable = false)
    private String itemGroupId;

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
    @Column(name = "CREATEDBY")
    private String createdBy;

    // Người cập nhật
    @Basic
    @Column(name = "UPDATEDBY")
    private String updatedBy;

    @Transient
    private McasItemGroupEntity mcasItemGroupEntity;

    @Transient
    private McasListApproveDataEntity objMcasListApproveDataEntity;

    @Transient
    private List<McasServiceEntity> lstServices;


}

