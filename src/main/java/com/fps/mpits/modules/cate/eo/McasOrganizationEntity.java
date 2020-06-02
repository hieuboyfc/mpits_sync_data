package com.fps.mpits.modules.cate.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fps.mpits.logging.AuditingEntityListener;
import com.fps.mpits.modules.app.eo.McasListApproveDataEntity;
import com.fps.mpits.util.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.SerializationUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 * @see <a href="https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm">https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm</a>
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_ORGANIZATION)
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class McasOrganizationEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// Mã tổ chức
	@Basic
	@Id
	@Column(name = "ORG_CODE", nullable = false)
	private String orgCode;

	// Tên tổ chức
	@Basic
	@Column(name = "NAME")
	private String name;

	// Mô tả
	@Basic
	@Column(name = "DESCRIPTION")
	private String description;

	// Trạng thái 0=deactive, 1=active, -9=delete
	@Basic
	@Column(name = "STATUS")
	private int status;

	// Mã tổ chức trên một cấp
	@Basic
	@Column(name = "PARENT_CODE")
	private String parentCode;

	// Cấp tổ chức (1=TCT, 2=BĐT, 3=BĐH, 4=BĐX)
	@Basic
	@Column(name = "ORG_LEVEL")
	private Integer orgLevel;

	// Loại tổ chức
	@Basic
	@Column(name = "ORG_TYPE")
	private String orgType;

	// Địa chỉ
	@Basic
	@Column(name = "ADDRESS")
	private String address;

	// Số điện thoại
	@Basic
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	// Mã đơn vị hành chính
	@Basic
	@Column(name = "ADMINISTRATIVE_CODE")
	private String administrativeCode;

	// Mã địa chỉ bưu chính
	@Basic
	@Column(name = "POSTAL_CODE", length = 10)
	private String postalCode;

	// Loại bưu cục (Trường hợp ORG_TYPE = POST)
	@Basic
	@Column(name = "POST_TYPE", length = 50)
	private String postType;

	// Ngày có hiệu lực
	@Basic
	@Column(name = "START_DATE")
	private Date startDate;

	// Mã phường xã
	@Basic
	@Column(name = "COMMUNE_CODE", length = 50)
	private String communeCode;

	// Tổ chức ảo
	@Basic
	@Column(name = "NOT_REAL")
	private byte notReal;

	// Có quyền thao tác với case
	@Basic
	@Column(name = "MGTCASE")
	private Integer mgtCase;

	@Transient
	private McasOrganizationEntity objMcasOrganizationEntity;

	@Transient
	private McasAdministrativeUnitEntity objMcasAdministrativeUnitEntity;

	@Transient
	private List<McasOrganizationEntity> lstMcasOrganizationEntityChild;

	@Transient
	private McasListApproveDataEntity objMcasListApproveDataEntity;

	@Transient
	private Long numberOfChild;

	public McasOrganizationEntity(McasOrganizationEntity objInput, Long numberOfChild) {
		this.orgCode(objInput.orgCode());
		this.name(objInput.name());
		this.description(objInput.description());
		this.status(objInput.status());
		this.parentCode(objInput.parentCode());
		this.orgLevel(objInput.orgLevel());
		this.orgType(objInput.orgType());
		this.address(objInput.address());
		this.phoneNumber(objInput.phoneNumber());
		this.administrativeCode(objInput.administrativeCode());
		this.postalCode(objInput.postalCode());
		this.postType(objInput.postType());
		this.startDate(objInput.startDate());
		this.communeCode(objInput.communeCode());
		this.notReal(objInput.notReal());
		this.mgtCase(objInput.mgtCase());
		this.numberOfChild(numberOfChild);
	}

	public McasOrganizationEntity cloneNotRef() {
		return SerializationUtils.clone(this);
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Integer getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdministrativeCode() {
		return administrativeCode;
	}

	public void setAdministrativeCode(String administrativeCode) {
		this.administrativeCode = administrativeCode;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getCommuneCode() {
		return communeCode;
	}

	public void setCommuneCode(String communeCode) {
		this.communeCode = communeCode;
	}

	public byte getNotReal() {
		return notReal;
	}

	public void setNotReal(byte notReal) {
		this.notReal = notReal;
	}

	public int getMgtCase() {
		return mgtCase;
	}

	public void setMgtCase(int mgtCase) {
		this.mgtCase = mgtCase;
	}

	public McasOrganizationEntity getObjMcasOrganizationEntity() {
		return objMcasOrganizationEntity;
	}

	public void setObjMcasOrganizationEntity(McasOrganizationEntity objMcasOrganizationEntity) {
		this.objMcasOrganizationEntity = objMcasOrganizationEntity;
	}

	public McasAdministrativeUnitEntity getObjMcasAdministrativeUnitEntity() {
		return objMcasAdministrativeUnitEntity;
	}

	public void setObjMcasAdministrativeUnitEntity(McasAdministrativeUnitEntity objMcasAdministrativeUnitEntity) {
		this.objMcasAdministrativeUnitEntity = objMcasAdministrativeUnitEntity;
	}

	public List<McasOrganizationEntity> getLstMcasOrganizationEntityChild() {
		return lstMcasOrganizationEntityChild;
	}

	public void setLstMcasOrganizationEntityChild(List<McasOrganizationEntity> lstMcasOrganizationEntityChild) {
		this.lstMcasOrganizationEntityChild = lstMcasOrganizationEntityChild;
	}

	public McasListApproveDataEntity getObjMcasListApproveDataEntity() {
		return objMcasListApproveDataEntity;
	}

	public void setObjMcasListApproveDataEntity(McasListApproveDataEntity objMcasListApproveDataEntity) {
		this.objMcasListApproveDataEntity = objMcasListApproveDataEntity;
	}

	public Long getNumberOfChild() {
		return numberOfChild;
	}

	public void setNumberOfChild(Long numberOfChild) {
		this.numberOfChild = numberOfChild;
	}
}