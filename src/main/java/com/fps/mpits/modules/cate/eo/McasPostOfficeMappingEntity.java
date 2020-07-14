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
@Table(name = Constant.EntityTable.MCAS_POSTOFFICE_MAPPING)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasPostOfficeMappingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã bưu cục
    @Basic
    @Id
    @Column(name = "POSCODE", length = 50)
    private String posCode;

    // Mã bưu chính tương ứng
    @Basic
    @Column(name = "N_POSTCODE")
    private String postCode;

    // Mã đơn vị quản lý mới
    @Basic
    @Column(name = "N_ORGCODE", length = 50)
    private String orgCode;

    public McasPostOfficeMappingEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }
}


