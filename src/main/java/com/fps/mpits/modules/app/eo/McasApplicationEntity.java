package com.fps.mpits.modules.app.eo;

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
@Table(name = Constant.EntityTable.MCAS_APPLICATION)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class McasApplicationEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// Mã ứng dụng
	@Basic
	@Id
	@Column(name = "APP_CODE", nullable = false)
	private String appCode;

	// Tên ứng dụng
	@Basic
	@Column(name = "NAME")
	private String name;

	// Mô tả
	@Basic
	@Column(name = "DESCRIPTION")
	private String description;

	// Trạng thái
	@Basic
	@Column(name = "STATUS")
	private int status;

	// Mã bảo mật JWT
	@Basic
	@Column(name = "JWT_SECRET_KEY")
	private String jwtSecretKey;

	// Mã bảo mật API
	@Basic
	@Column(name = "API_KEY")
	private String apiKey;

	public McasApplicationEntity cloneNotRef() {
		return SerializationUtils.clone(this);
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
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

	public String getJwtSecretKey() {
		return jwtSecretKey;
	}

	public void setJwtSecretKey(String jwtSecretKey) {
		this.jwtSecretKey = jwtSecretKey;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
}