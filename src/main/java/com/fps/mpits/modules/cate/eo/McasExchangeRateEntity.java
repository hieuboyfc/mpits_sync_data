package com.fps.mpits.modules.cate.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fps.mpits.logging.AuditingEntityListener;
import com.fps.mpits.util.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
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

    // Trạng thái 0=deactive, 1=active, -9=delete
    @Basic
    @Column(name = "STATUS")
    private int status;

    @Transient
    private String exchangeName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public String getExchangedCode() {
        return exchangedCode;
    }

    public void setExchangedCode(String exchangedCode) {
        this.exchangedCode = exchangedCode;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }
}
