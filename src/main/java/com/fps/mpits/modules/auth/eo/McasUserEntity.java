package com.fps.mpits.modules.auth.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fps.mpits.logging.AuditingEntityListener;
import com.fps.mpits.modules.app.eo.McasApplicationEntity;
import com.fps.mpits.modules.cate.eo.McasOrganizationEntity;
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
    private List<McasApplicationEntity> lstMcasApplicationEntity;

    @Transient
    private List<McasUserAppEntity> lstMcasUserAppEntity;

    @Transient
    private List<McasGroupEntity> lstMcasGroupEntity;

    @Transient
    private McasEmployeeEntity objMcasEmployeeEntity;

    @Transient
    private List<String> importingErrorMessages;

    @Transient
    private int appStatus;

    @Transient
    private String fullName;

    public McasUserEntity(String username, String employeeCode, String fullname) {
        this.username(username);
        this.employeeCode(employeeCode);
        this.fullName(fullname);
    }

    public McasUserEntity(McasUserEntity objMcasUserEntity,
                          McasEmployeeEntity objMcasEmployeeEntity,
                          int iUserAppStatus) {
        this.username(objMcasUserEntity.username());
        this.password(objMcasUserEntity.password());
        this.description(objMcasUserEntity.description());
        this.employeeCode(objMcasUserEntity.employeeCode());
        this.lastChangePassDt(objMcasUserEntity.lastChangePassDt());
        this.status(iUserAppStatus);
        this.alternativePassword(objMcasUserEntity.alternativePassword());
        this.objMcasEmployeeEntity(objMcasEmployeeEntity);
    }

    public McasUserEntity(McasUserEntity objMcasUserEntity,
                          McasEmployeeEntity objMcasEmployeeEntity) {
        this.username(objMcasUserEntity.username());
        this.password(objMcasUserEntity.password());
        this.description(objMcasUserEntity.description());
        this.employeeCode(objMcasUserEntity.employeeCode());
        this.lastChangePassDt(objMcasUserEntity.lastChangePassDt());
        this.status(objMcasUserEntity.status());
        this.alternativePassword(objMcasUserEntity.alternativePassword());
        this.objMcasEmployeeEntity(objMcasEmployeeEntity);
    }

    public McasUserEntity(McasUserEntity objMcasUserEntity,
                          McasEmployeeEntity objMcasEmployeeEntity,
                          McasOrganizationEntity organizationEntity) {
        this.username(objMcasUserEntity.username());
        this.password(objMcasUserEntity.password());
        this.description(objMcasUserEntity.description());
        this.employeeCode(objMcasUserEntity.employeeCode());
        this.lastChangePassDt(objMcasUserEntity.lastChangePassDt());
        this.status(objMcasUserEntity.status());
        this.alternativePassword(objMcasUserEntity.alternativePassword());
        this.objMcasEmployeeEntity(objMcasEmployeeEntity);
        this.objMcasEmployeeEntity.setObjMcasOrganizationEntity(organizationEntity);

    }

    public McasUserEntity(McasUserEntity objMcasUserEntity,
                          McasEmployeeEntity objMcasEmployeeEntity,
                          List<McasUserAppEntity> mcasUserAppEntities,
                          List<McasGroupEntity> mcasGroupEntities) {
        this.username(objMcasUserEntity.username());
        this.password(objMcasUserEntity.password());
        this.description(objMcasUserEntity.description());
        this.employeeCode(objMcasUserEntity.employeeCode());
        this.lastChangePassDt(objMcasUserEntity.lastChangePassDt());
        this.status(objMcasUserEntity.status());
        this.alternativePassword(objMcasUserEntity.alternativePassword());
        this.objMcasEmployeeEntity(objMcasEmployeeEntity);
        this.lstMcasUserAppEntity(mcasUserAppEntities);
        this.lstMcasGroupEntity(mcasGroupEntities);
    }

    public McasUserEntity(McasUserEntity objMcasUserEntity,
                          McasEmployeeEntity objMcasEmployeeEntity,
                          List<McasApplicationEntity> lstMcasApplicationEntity) {
        this.username(objMcasUserEntity.username());
        this.password(objMcasUserEntity.password());
        this.description(objMcasUserEntity.description());
        this.employeeCode(objMcasUserEntity.employeeCode());
        this.lastChangePassDt(objMcasUserEntity.lastChangePassDt());
        this.status(objMcasUserEntity.status());
        this.alternativePassword(objMcasUserEntity.alternativePassword());
        this.objMcasEmployeeEntity(objMcasEmployeeEntity);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlternativePassword() {
        return alternativePassword;
    }

    public void setAlternativePassword(String alternativePassword) {
        this.alternativePassword = alternativePassword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Date getLastChangePassDt() {
        return lastChangePassDt;
    }

    public void setLastChangePassDt(Date lastChangePassDt) {
        this.lastChangePassDt = lastChangePassDt;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<McasApplicationEntity> getLstMcasApplicationEntity() {
        return lstMcasApplicationEntity;
    }

    public void setLstMcasApplicationEntity(List<McasApplicationEntity> lstMcasApplicationEntity) {
        this.lstMcasApplicationEntity = lstMcasApplicationEntity;
    }

    public List<McasUserAppEntity> getLstMcasUserAppEntity() {
        return lstMcasUserAppEntity;
    }

    public void setLstMcasUserAppEntity(List<McasUserAppEntity> lstMcasUserAppEntity) {
        this.lstMcasUserAppEntity = lstMcasUserAppEntity;
    }

    public List<McasGroupEntity> getLstMcasGroupEntity() {
        return lstMcasGroupEntity;
    }

    public void setLstMcasGroupEntity(List<McasGroupEntity> lstMcasGroupEntity) {
        this.lstMcasGroupEntity = lstMcasGroupEntity;
    }

    public McasEmployeeEntity getObjMcasEmployeeEntity() {
        return objMcasEmployeeEntity;
    }

    public void setObjMcasEmployeeEntity(McasEmployeeEntity objMcasEmployeeEntity) {
        this.objMcasEmployeeEntity = objMcasEmployeeEntity;
    }

    public List<String> getImportingErrorMessages() {
        return importingErrorMessages;
    }

    public void setImportingErrorMessages(List<String> importingErrorMessages) {
        this.importingErrorMessages = importingErrorMessages;
    }

    public int getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(int appStatus) {
        this.appStatus = appStatus;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}