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
@Table(name = Constant.EntityTable.MCAS_UOM)
@Accessors(fluent = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasUomEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã đơn vị tính
    @Basic
    @Id
    @Column(name = "UOM_ID", length = 5, nullable = false)
    private String uomId;

    // Tên đơn vị tính eg: kg, gram, box...
    @Basic
    @Column(name = "UOM_NAME", length = 20, nullable = false)
    private String uomName;

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

    public McasUomEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }

}
