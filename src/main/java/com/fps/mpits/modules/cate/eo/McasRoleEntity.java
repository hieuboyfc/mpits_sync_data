package com.fps.mpits.modules.cate.eo;

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
@Table(name = Constant.EntityTable.MCAS_ROLE)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã quyền
    @Basic
    @Id
    @Column(name = "ROLE_ID", length = 10)
    private String roleId;

    // Tên quyền
    @Basic
    @Column(name = "ROLE_NAME", length = 200)
    private String rolename;

    // Hệ thống
    @Basic
    @Column(name = "SYSTEM", length = 10)
    private String system;

    // Ngày tạo
    @Basic
    @Column(name = "CREATE_DATE")
    private Date createDate;

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS")
    private int status;

    public McasRoleEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }

}
