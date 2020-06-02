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
import java.util.ArrayList;
import java.util.List;

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_ORGANIZATION_STANDARD)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class McasOrganizationStandardEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã đơn vị
    @Basic
    @Id
    @Column(name = "UNIT_CODE", length = 50)
    private String unitCode;

    // Tên đơn vị
    @Basic
    @Column(name = "UNIT_NAME")
    private String unitName;

    // Loại đơn vị (UNIT: Đối với TCT, BĐT, BĐH,POS: Bưu cục, CENTER:Ban, DIVISION: Phòng)
    @Basic
    @Column(name = "UNIT_TYPE", length = 50)
    private String unitType;

    // Cấp đơn vị (1: TCT;2:BĐT, BAN;3:BĐH, Phòng;4:Điểm phục vụ)
    @Basic
    @Column(name = "TYPE_CODE", length = 1)
    private Byte typeCode;

    // Mã đv cha
    @Basic
    @Column(name = "PARENT_CODE", length = 50)
    private String parentCode;

    // Mã xã phường của đơn vị
    @Basic
    @Column(name = "COMMUNE_CODE", length = 50)
    private String communeCode;

    // Mã địa chỉ bưu chính
    @Basic
    @Column(name = "POSTAL_CODE", length = 10)
    private String postalCode;

    // Loại bưu cục (Nếu TYPE_CODE =4)
    @Basic
    @Column(name = "POST_TYPE", length = 50)
    private String postType;

    // Địa chỉ đơn vị
    @Basic
    @Column(name = "ADDRESS", length = 500)
    private String address;

    // Trạng thái
    @Basic
    @Column(name = "STATUS", length = 1)
    private int status;

    // Số điện thoại
    @Basic
    @Column(name = "TEL", length = 50)
    private String tel;

    @Transient
    private String provinceCode;

    @Transient
    private String districtCode;

    @Transient
    private McasAdministrativeUnitEntity postal;

    @Transient
    private McasOrganizationStandardEntity parent;

    @Transient
    private List<McasOrganizationStandardEntity> children = new ArrayList<>();

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

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Byte getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Byte typeCode) {
        this.typeCode = typeCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getCommuneCode() {
        return communeCode;
    }

    public void setCommuneCode(String communeCode) {
        this.communeCode = communeCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public McasAdministrativeUnitEntity getPostal() {
        return postal;
    }

    public void setPostal(McasAdministrativeUnitEntity postal) {
        this.postal = postal;
    }

    public McasOrganizationStandardEntity getParent() {
        return parent;
    }

    public void setParent(McasOrganizationStandardEntity parent) {
        this.parent = parent;
    }

    public List<McasOrganizationStandardEntity> getChildren() {
        return children;
    }

    public void setChildren(List<McasOrganizationStandardEntity> children) {
        this.children = children;
    }
}
