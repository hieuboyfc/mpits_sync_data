package com.fps.mpits.modules.cate.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
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
 * @see <a href="https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm">https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm</a>
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_NATIONAL_POSTAL)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class McasNationalPostalEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// Mã bưu chính quốc gia
	@Basic
	@Id
	@Column(name = "CODE", nullable = false)
	private String code;

	// Tên bưu chính quốc gia
	@Basic
	@Column(name = "NAME")
	private String name;

	// Địa chỉ
	@Basic
	@Column(name = "ADDRESS")
	private String address;

	// Mã chia
	@Basic
	@Column(name = "PART_CODE")
	private String partCode;

	// Mã bưu chính cũ
	@Basic
	@Column(name = "OLD_POSTAL_CODE")
	private String oldPostalCode;

	// Loại bưu cục
	@Basic
	@Column(name = "POST_OFFICE_TYPE")
	private String postOfficeType;

	// Đối tượng mã chia
	@Basic
	@Column(name = "PART_OBJECT")
	private String partObject;

	// Mã đơn vị hành chính
	@Basic
	@Column(name = "ADMINISTRATIVE_CODE")
	private String administrativeCode;

	// Trạng thái 0=deactive, 1=active, -9=delete
	@Basic
	@Column(name = "STATUS")
	private int status;

	@Transient
	private McasNationalPostalEntity objMcasNationalPostalEntity;

	@Transient
	private McasAdministrativeUnitEntity objMcasAdministrativeUnitEntity;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getOldPostalCode() {
		return oldPostalCode;
	}

	public void setOldPostalCode(String oldPostalCode) {
		this.oldPostalCode = oldPostalCode;
	}

	public String getPostOfficeType() {
		return postOfficeType;
	}

	public void setPostOfficeType(String postOfficeType) {
		this.postOfficeType = postOfficeType;
	}

	public String getPartObject() {
		return partObject;
	}

	public void setPartObject(String partObject) {
		this.partObject = partObject;
	}

	public String getAdministrativeCode() {
		return administrativeCode;
	}

	public void setAdministrativeCode(String administrativeCode) {
		this.administrativeCode = administrativeCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public McasNationalPostalEntity getObjMcasNationalPostalEntity() {
		return objMcasNationalPostalEntity;
	}

	public void setObjMcasNationalPostalEntity(McasNationalPostalEntity objMcasNationalPostalEntity) {
		this.objMcasNationalPostalEntity = objMcasNationalPostalEntity;
	}

	public McasAdministrativeUnitEntity getObjMcasAdministrativeUnitEntity() {
		return objMcasAdministrativeUnitEntity;
	}

	public void setObjMcasAdministrativeUnitEntity(McasAdministrativeUnitEntity objMcasAdministrativeUnitEntity) {
		this.objMcasAdministrativeUnitEntity = objMcasAdministrativeUnitEntity;
	}
}