package com.fps.mpits.modules.auth.eo;

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
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_USER)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class McasUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Tên người dùng
    @Basic
    @Id
    @Column(name = "USERNAME", nullable = false)
    private String username;

    // Mật khẩu
    @Basic
    @Column(name = "PASSWORD")
    private String password;

    // Mật khẩu hệ thống khác
    @Basic
    @Column(name = "ALTERNATIVE_PASSWORD")
    private String alternativePassword;

    // Mô tả
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;

    // Mã nhân viên
    @Basic
    @Column(name = "EMPLOYEE_CODE")
    private String employeeCode;

    // Ngày, giờ lần thay đổi mật khẩu gần nhất
    @Basic
    @Column(name = "LAST_CHANGE_PASS_DT")
    private Date lastChangePassDt;

    // Ngày, giờ tạo tài khoản
    @Basic
    @Column(name = "DATE_CREATE")
    private Date dateCreate;

    // Trạng thái (1 - Đang hoạt động, 0 - Ngừng hoạt động)
    @Basic
    @Column(name = "STATUS")
    private Integer status;

    @Transient
    private McasEmployeeEntity mcasEmployeeEntity;

    public McasUserEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }

}