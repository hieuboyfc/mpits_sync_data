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
 * @see <a href="https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm">https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm</a>
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_NATIONAL_POSTAL)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class McasNationalPostalEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã bưu chính quốc gia
    @Basic
    @Id
    @Column(name = "CODE", nullable = false)
    private String code;

    // Tên bưu chính quốc gia
    @Basic
    @Column(name = "NAME")
    private String name;

    // Địa chỉ
    @Basic
    @Column(name = "ADDRESS")
    private String address;

    // Mã chia
    @Basic
    @Column(name = "PART_CODE")
    private String partCode;

    // Mã bưu chính cũ
    @Basic
    @Column(name = "OLD_POSTAL_CODE")
    private String oldPostalCode;

    // Loại bưu cục
    @Basic
    @Column(name = "POST_OFFICE_TYPE")
    private String postOfficeType;

    // Đối tượng mã chia
    @Basic
    @Column(name = "PART_OBJECT")
    private String partObject;

    // Mã đơn vị hành chính
    @Basic
    @Column(name = "ADMINISTRATIVE_CODE")
    private String administrativeCode;

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS")
    private int status;

    public McasNationalPostalEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }
}