package com.fps.mpits.modules.cate.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fps.mpits.logging.AuditingEntityListener;
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

    // Trạng thái 0=deactive, 1=active, -9=delete
    @Basic
    @Column(name = "STATUS")
    private int status;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
