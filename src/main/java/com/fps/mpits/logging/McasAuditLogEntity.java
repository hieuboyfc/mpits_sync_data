package com.fps.mpits.logging;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
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

@Entity
@Table(name = Constant.EntityTable.MCAS_AUDIT_LOG)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class McasAuditLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // ID
    @Basic
    @Id
    @SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "SEQ_MCAS_AUDIT_LOG", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
    @Column(name = "ID", nullable = false, updatable = false)
    private int id;

    // Mã ứng dụng
    @Basic
    @Column(name = "APP_CODE")
    private String appCode;

    // Mã chức năng
    @Basic
    @Column(name = "MENU_CODE")
    private String menuCode;

    // Mã thao tác trong chức năng
    @Basic
    @Column(name = "FUNC_CODE")
    private String funcCode;

    // Username thao tác
    @Basic
    @Column(name = "ACTION_USER")
    private String actionUser;

    // Ngày thao tác
    @Basic
    @Column(name = "ACTION_DT")
    private Date actionDt;

    // Dữ liệu thao tác dạng JSON
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ACTION_DATA")
    private String actionData;

    // Bảng thao tác
    @Basic
    @Column(name = "TABLE_NAME")
    private String tableName;

    // Sự kiện thao tác
    @Basic
    @Column(name = "JPA_EVENT")
    private String jpaEvent;

    // Địa chỉ IP
    @Basic
    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    // Thông tin trình duyệt user
    @Basic
    @Column(name = "USER_AGENT")
    private String userAgent;

    // Địa chỉ url gửi lên
    @Basic
    @Column(name = "URL_REQUEST")
    private String urlRequest;

    // Địa chỉ url tham chiếu
    @Basic
    @Column(name = "URL_REFERER")
    private String urlReferer;
}