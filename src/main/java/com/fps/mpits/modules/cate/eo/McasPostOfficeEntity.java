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
@Table(name = Constant.EntityTable.MCAS_POSTOFFICE)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasPostOfficeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã bưu cục
    @Basic
    @Id
    @Column(name = "POSCODE", length = 50)
    private String posCode;

    // Tên bưu cục
    @Basic
    @Column(name = "POSNAME")
    private String posName;

    // Địa chỉ
    @Basic
    @Column(name = "ADDRESS", length = 500)
    private String address;

    // Mã loại bưu cục
    @Basic
    @Column(name = "POSLEVELCODE", length = 50)
    private String posLevelCode;

    // Tên loại bưu cục
    @Basic
    @Column(name = "POSLEVELNAME")
    private String posLevelName;

    // Mã tỉnh thành
    @Basic
    @Column(name = "PROVINCECODE", length = 50)
    private String provinceCode;

    // Tên tỉnh thành
    @Basic
    @Column(name = "PROVINCENAME")
    private String provinceName;

    // Mã quận huyện
    @Basic
    @Column(name = "DISTRICTCODE", length = 50)
    private String districtCode;

    // Tên quận huyện
    @Basic
    @Column(name = "DISTRICTNAME")
    private String districtName;

    // Mã phường xã
    @Basic
    @Column(name = "COMMUNECODE", length = 50)
    private String communeCode;

    // Tên phường xã
    @Basic
    @Column(name = "COMMUNENAME")
    private String communeName;

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS")
    private int status;

    // Mã đơn vị
    @Basic
    @Column(name = "UNITCODE", length = 50)
    private String unitCode;

    // Tên đơn vị
    @Basic
    @Column(name = "UNITNAME")
    private String unitName;

    public McasPostOfficeEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }
}
