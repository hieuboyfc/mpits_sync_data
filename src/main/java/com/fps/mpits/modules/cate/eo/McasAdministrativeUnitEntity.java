package com.fps.mpits.modules.cate.eo;

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

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */


@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_ADMINISTRATIVE_UNIT)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class McasAdministrativeUnitEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// Mã đơn vị hành chính
	@Basic
	@Id
	@Column(name = "CODE", nullable = false)
	private String code;

	// Tên đơn vị hành chính
	@Basic
	@Column(name = "NAME")
	private String name;

	// Mã đơn vị hành chính trên một cấp
	@Basic
	@Column(name = "PARENT_CODE")
	private String parentCode;

	// Loại đơn vị hành chính
	@Basic
	@Column(name = "UNIT_TYPE")
	private String unitType;

	// Mã đơn vị hành chính cũ
	@Basic
	@Column(name = "OLD_ADMINISTRATIVE_CODE")
	private String oldAdministrativeCode;

	// Trạng thái 0=deactive, 1=active, -9=delete
	@Basic
	@Column(name = "STATUS")
	private int status;

	// Mã bưu chính
	@Basic
	@Column(name = "MBC_CODE", length = 50)
	private String mbcCode;

	@Basic
	@Column(name = "COMMUNE", length = 50)
	private String commune;

	@Basic
	@Column(name = "POD", length = 50)
	private String pod;

	@Basic
	@Column(name = "HAN_TP_BCP", length = 50)
	private String hanTPBCP;

	@Basic
	@Column(name = "SORTINGCODE", length = 50)
	private String sortingCode;

	@Transient
	private McasAdministrativeUnitEntity objMcasAdministrativeUnitEntity;

	public McasAdministrativeUnitEntity cloneNotRef() {
		return SerializationUtils.clone(this);
	}

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

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getOldAdministrativeCode() {
		return oldAdministrativeCode;
	}

	public void setOldAdministrativeCode(String oldAdministrativeCode) {
		this.oldAdministrativeCode = oldAdministrativeCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMbcCode() {
		return mbcCode;
	}

	public void setMbcCode(String mbcCode) {
		this.mbcCode = mbcCode;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public String getHanTPBCP() {
		return hanTPBCP;
	}

	public void setHanTPBCP(String hanTPBCP) {
		this.hanTPBCP = hanTPBCP;
	}

	public String getSortingCode() {
		return sortingCode;
	}

	public void setSortingCode(String sortingCode) {
		this.sortingCode = sortingCode;
	}

	public McasAdministrativeUnitEntity getObjMcasAdministrativeUnitEntity() {
		return objMcasAdministrativeUnitEntity;
	}

	public void setObjMcasAdministrativeUnitEntity(McasAdministrativeUnitEntity objMcasAdministrativeUnitEntity) {
		this.objMcasAdministrativeUnitEntity = objMcasAdministrativeUnitEntity;
	}
}