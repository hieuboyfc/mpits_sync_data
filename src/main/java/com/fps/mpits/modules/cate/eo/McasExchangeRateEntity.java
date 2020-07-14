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
@Table(name = Constant.EntityTable.MCAS_EXCHANGE_RATE)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class McasExchangeRateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // ID tự tăng
    @Basic
    @Id
    @SequenceGenerator(name = "SEQ_MCAS_EXCHANGE_RATE", sequenceName = "SEQ_MCAS_EXCHANGE_RATE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MCAS_EXCHANGE_RATE")
    @Column(name = "ID", nullable = false, updatable = false)
    private long id;

    // Mã nguyên tệ
    @Basic
    @Column(name = "EXCHANGE_CODE", length = 50)
    private String exchangeCode;

    // Mã ngoại tệ quy đổi sang
    @Basic
    @Column(name = "EXCHANGED_CODE", length = 50)
    private String exchangedCode;

    // Tỷ giá
    @Basic
    @Column(name = "RATE", columnDefinition = "NUMBER(10,2)")
    private Double rate;

    // Ngày tạo
    @Basic
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS")
    private int status;

    public McasExchangeRateEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }
}
