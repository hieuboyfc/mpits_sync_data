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
import java.util.Date;

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
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

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
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

    public McasOrganizationEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }

}