package com.fps.mpits.modules.cate.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
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

    // Loại đơn vị (UNIT: Đối với TCT, BĐT, BĐH, POS: Bưu cục, CENTER: Ban, DIVISION: Phòng)
    @Basic
    @Column(name = "UNIT_TYPE", length = 50)
    private String unitType;

    // Cấp đơn vị (1: TCT; 2: BĐT, BAN; 3: BĐH, Phòng; 4: Điểm phục vụ)
    @Basic
    @Column(name = "TYPE_CODE", length = 1)
    private Byte typeCode;

    // Mã đơn vị cha
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

    // Loại bưu cục (Nếu TYPE_CODE = 4)
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

    public McasOrganizationStandardEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }

}
