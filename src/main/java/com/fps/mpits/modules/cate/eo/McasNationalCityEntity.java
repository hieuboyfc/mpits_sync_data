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
@Table(name = Constant.EntityTable.MCAS_NATIONAL_CITY)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasNationalCityEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã bưu chính thành phố
    @Id
    @Column(name = "CODE", length = 50)
    private String code;

    // Tên bưu chính thành phố
    @Basic
    @Column(name = "NAME")
    private String name;

    // Mã bưu chính quốc gia
    @Basic
    @Column(name = "NATIONAL_CODE")
    private String nationalCode;

    // Ngày tạo
    @Basic
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    // Trạng thái 0=deactive, 1=active, -9=delete
    @Basic
    @Column(name = "STATUS")
    private int status;

    @Transient
    McasNationalEntity objMcasNationalEntity;

    @Transient
    String nationalName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public McasNationalEntity getObjMcasNationalEntity() {
        return objMcasNationalEntity;
    }

    public void setObjMcasNationalEntity(McasNationalEntity objMcasNationalEntity) {
        this.objMcasNationalEntity = objMcasNationalEntity;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }
}
