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
import java.util.Date;

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_NATIONAL_CITY)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasNationalCityEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã bưu chính thành phố
    @Id
    @Column(name = "CODE", length = 50)
    private String code;

    // Tên bưu chính thành phố
    @Basic
    @Column(name = "NAME")
    private String name;

    // Mã bưu chính quốc gia
    @Basic
    @Column(name = "NATIONAL_CODE")
    private String nationalCode;

    // Ngày tạo
    @Basic
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS")
    private int status;

    // Vùng xa cho HTTC (1 - Có)
    @Basic
    @Column(name = "IS_FAR", length = 1)
    private Integer isFar;

    // Trung tâm cho HTTC (1 - Có)
    @Basic
    @Column(name = "IS_CENTER", length = 1)
    private Integer isCenter;

    public McasNationalCityEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }
}
