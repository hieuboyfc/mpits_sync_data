package com.fps.mpits.modules.auth.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fps.mpits.logging.AuditingEntityListener;
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
@Table(name = Constant.EntityTable.MCAS_EMPLOYEE)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class McasEmployeeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// Mã nhân viên
	@Basic
	@Id
	@Column(name = "CODE", nullable = false)
	private String code;

	// Tên nhân viên
	@Basic
	@Column(name = "FULLNAME")
	private String fullname;

	// Ngày sinh
	@Basic
	@Column(name = "DATE_OF_BIRTH")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	// Số CMT/ Số an sinh xã hội
	@Basic
	@Column(name = "ID_CARD")
	private String idCard;

	// Địa chỉ email
	@Basic
	@Column(name = "EMAIL")
	private String email;

	// Mã tổ chức
	@Basic
	@Column(name = "ORG_CODE")
	private String orgCode;

	// Số điện thoại
	@Basic
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	// Trạng thái (0 - chưa kích hoạt, 1 đã kích hoạt)
	@Basic
	@Column(name = "STATUS")
	private int status;

	// Loại giấy tờ: 1 - CMT, 2 - Thẻ căn cước, 3 - Hộ chiếu
	@Basic
	@Column(name = "ID_CARD_TYPE")
	private int idCardType;

	// Mã chức vụ
	@Basic
	@Column(name = "POSITION_ID", length = 50)
	private String positionId;

	// Tên chức vụ
	@Basic
	@Column(name = "POSITION_NAME")
	private String positionName;

	// Mã chức danh
	@Basic
	@Column(name = "TITLE_ID", length = 50)
	private String titleId;

	// Tên chức danh
	@Basic
	@Column(name = "TITLE_NAME")
	private String titleName;

	// Giới tính
	@Basic
	@Column(name = "GENDER")
	private Integer gender;

	// Địa chỉ
	@Basic
	@Column(name = "ADDRESS", length = 500)
	private String address;

	@Transient
	private McasOrganizationEntity objMcasOrganizationEntity;

	@Transient
	private int rowNum;

	@Transient
	private List<String> importingErrorMessages;

	//update business area for PRS employee
	//Lĩnh vực kinh doanh
	@Transient
	private String typeofBusinessPartner;
	//Là nhân viên bán hàng : 1 - là nhân viên bán hàng, 0 - không phải là nhân viên bán hàng
	@Transient
	private Integer isSales;


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(int idCardType) {
		this.idCardType = idCardType;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public McasOrganizationEntity getObjMcasOrganizationEntity() {
		return objMcasOrganizationEntity;
	}

	public void setObjMcasOrganizationEntity(McasOrganizationEntity objMcasOrganizationEntity) {
		this.objMcasOrganizationEntity = objMcasOrganizationEntity;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public List<String> getImportingErrorMessages() {
		return importingErrorMessages;
	}

	public void setImportingErrorMessages(List<String> importingErrorMessages) {
		this.importingErrorMessages = importingErrorMessages;
	}

	public String getTypeofBusinessPartner() {
		return typeofBusinessPartner;
	}

	public void setTypeofBusinessPartner(String typeofBusinessPartner) {
		this.typeofBusinessPartner = typeofBusinessPartner;
	}

	public Integer getIsSales() {
		return isSales;
	}

	public void setIsSales(Integer isSales) {
		this.isSales = isSales;
	}
}