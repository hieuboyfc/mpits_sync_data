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
@Table(name = Constant.EntityTable.MCAS_NATIONAL)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasNationalEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã bưu chính quốc gia
    @Basic
    @Id
    @Column(name = "CODE", length = 50)
    private String code;

    // Tên bưu chính quốc gia
    @Basic
    @Column(name = "NAME")
    private String name;

    // Ngày tạo
    @Basic
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    // Thuộc Châu lục
    @Basic
    @Column(name = "CONT")
    private String cont;

    // Tên tiếng anh
    @Basic
    @Column(name = "ENAME")
    private String eName;

    // Vùng (Tây Á, Đông Nam Á...)
    @Basic
    @Column(name = "REGION")
    private String region;

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS")
    private int status;

    public McasNationalEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }
}
