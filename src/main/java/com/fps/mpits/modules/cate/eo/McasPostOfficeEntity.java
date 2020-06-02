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

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_POSTOFFICE)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasPostOfficeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã bưu cục
    @Basic
    @Id
    @Column(name = "POSCODE", length = 50)
    private String posCode;

    // Tên bưu cục
    @Basic
    @Column(name = "POSNAME")
    private String posName;

    // Địa chỉ
    @Basic
    @Column(name = "ADDRESS", length = 500)
    private String address;

    // Mã loại bưu cục
    @Basic
    @Column(name = "POSLEVELCODE", length = 50)
    private String posLevelCode;

    // Tên loại bưu cục
    @Basic
    @Column(name = "POSLEVELNAME")
    private String posLevelName;

    // Mã tỉnh thành
    @Basic
    @Column(name = "PROVINCECODE", length = 50)
    private String provinceCode;

    // Tên tỉnh thành
    @Basic
    @Column(name = "PROVINCENAME")
    private String provinceName;

    // Mã quận huyện
    @Basic
    @Column(name = "DISTRICTCODE", length = 50)
    private String districtCode;

    // Tên quận huyện
    @Basic
    @Column(name = "DISTRICTNAME")
    private String districtName;

    // Mã phường xã
    @Basic
    @Column(name = "COMMUNECODE", length = 50)
    private String communeCode;

    // Tên phường xã
    @Basic
    @Column(name = "COMMUNENAME")
    private String communeName;

    // Trạng thái 0=deactive, 1=active, -9=delete
    @Basic
    @Column(name = "STATUS")
    private int status;

    // Mã đơn vị
    @Basic
    @Column(name = "UNITCODE", length = 50)
    private String unitCode;

    // Tên đơn vị
    @Basic
    @Column(name = "UNITNAME")
    private String unitName;

    @Transient
    private McasPostOfficeMappingEntity objMcasPostOfficeMappingEntity;

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosLevelCode() {
        return posLevelCode;
    }

    public void setPosLevelCode(String posLevelCode) {
        this.posLevelCode = posLevelCode;
    }

    public String getPosLevelName() {
        return posLevelName;
    }

    public void setPosLevelName(String posLevelName) {
        this.posLevelName = posLevelName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getCommuneCode() {
        return communeCode;
    }

    public void setCommuneCode(String communeCode) {
        this.communeCode = communeCode;
    }

    public String getCommuneName() {
        return communeName;
    }

    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public McasPostOfficeMappingEntity getObjMcasPostOfficeMappingEntity() {
        return objMcasPostOfficeMappingEntity;
    }

    public void setObjMcasPostOfficeMappingEntity(McasPostOfficeMappingEntity objMcasPostOfficeMappingEntity) {
        this.objMcasPostOfficeMappingEntity = objMcasPostOfficeMappingEntity;
    }
}
