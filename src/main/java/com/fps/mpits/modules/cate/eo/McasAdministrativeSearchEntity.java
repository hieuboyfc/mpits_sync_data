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
@Table(name = Constant.EntityTable.MCAS_ADMINISTRATIVE_SEARCH)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasAdministrativeSearchEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // ID Tự tăng
    @Basic
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Mã tỉnh, thành phố
    @Basic
    @Column(name = "PROVINCE_CODE")
    private String provinceCode;

    // Mã quận, huyện
    @Basic
    @Column(name = "DISTRICT_CODE")
    private String districtCode;

    // Mã phường, xã
    @Basic
    @Column(name = "WARD_CODE")
    private String wardCode;

    // Mã bưu chính
    @Basic
    @Column(name = "POSTCODE")
    private String postCode;

    // Tên có dấu
    @Basic
    @Column(name = "FNAME", length = 500)
    private String fName;

    // Tên không dấu
    @Basic
    @Column(name = "SNAME", length = 500)
    private String sName;

    // Loại đơn vị
    @Basic
    @Column(name = "UNIT_TYPE")
    private String unitType;

    public McasAdministrativeSearchEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }

}
