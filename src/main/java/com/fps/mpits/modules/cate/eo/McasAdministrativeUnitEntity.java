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

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS")
    private int status;

    // Mã bưu chính
    @Basic
    @Column(name = "MBC_CODE", length = 50)
    private String mbcCode;

    // Mã xã
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

    // Vùng xa cho HTTC (1 - Có)
    @Basic
    @Column(name = "IS_FAR", length = 1)
    private Integer isFar;

    // Hải đảo cho HTTC (1 - Có)
    @Basic
    @Column(name = "IS_ISLAND", length = 1)
    private Integer isIsland;

    // Trung tâm cho HTTC (1 - Có)
    @Basic
    @Column(name = "IS_CENTER", length = 1)
    private Integer isCenter;

    public McasAdministrativeUnitEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }

}