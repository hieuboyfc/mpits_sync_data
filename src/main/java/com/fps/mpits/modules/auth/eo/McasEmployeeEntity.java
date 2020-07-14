package com.fps.mpits.modules.auth.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
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

	public McasEmployeeEntity cloneNotRef() {
		return SerializationUtils.clone(this);
	}

}