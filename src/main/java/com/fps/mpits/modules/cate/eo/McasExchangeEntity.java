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
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_EXCHANGE)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasExchangeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã ngoại tệ
    @Basic
    @Id
    @Column(name = "CODE", length = 50)
    private String code;

    // Tên ngoại tệ
    @Basic
    @Column(name = "NAME")
    private String name;

    // Đồng bộ tự động 0=không, 1=có
    @Basic
    @Column(name = "AUTO_SYNC")
    private boolean autoSync;

    // Ngày tạo
    @Basic
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS")
    private int status;

    public McasExchangeEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }
}
