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
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_ADMINISTRATIVE_POSTCODE)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasAdministrativePostCodeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã bưu chính quốc gia
    @Basic
    @Id
    @Column(name = "POSTAL_CODE")
    private String postalCode;

    // Mã đơn vị hành chính
    @Basic
    @Column(name = "ADMINISTRATIVE_CODE", nullable = false)
    private String administrativeCode;

    // Địa chỉ
    @Basic
    @Column(name = "ADDRESS")
    private String address;

    // Mã bưu chính cũ
    @Basic
    @Column(name = "OLD_POSTAL_CODE")
    private String oldPostalCode;

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS")
    private int status;

    public McasAdministrativePostCodeEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }
}
