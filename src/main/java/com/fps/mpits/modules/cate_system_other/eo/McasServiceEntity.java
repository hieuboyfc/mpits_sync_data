package com.fps.mpits.modules.cate_system_other.eo;

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
import java.util.Date;

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_SERVICE)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class McasServiceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã dịch vụ
    @Basic
    @Id
    @Column(name = "MAIL_SERVICE_ID", length = 10, nullable = false)
    private String mailServiceId;

    // Tên dịch vụ
    @Basic
    @Column(name = "MAIL_SERVICE_NAME", length = 100, nullable = false)
    private String mailServiceName;

    // Tính chất (LH - Loại hàng, HH - Hàng hóa)
    @Basic
    @Column(name = "TYPE", length = 5, nullable = false)
    private String type;

    // Phạm vi (Trong nước, quốc tế)
    @Basic
    @Column(name = "SCOPE", length = 50)
    private String scope;

    // Nhập kích thước (0, 1)
    @Basic
    @Column(name = "ISSIZE", length = 5)
    private String isSize;

    // Nhóm dịch vụ
    @Basic
    @Column(name = "SERVICE_GROUP_ID", length = 20, nullable = false)
    private String serviceGroupId;

    // Mã thuế suất - Chọn từ danh mục: V0, V1, V2, V3, V4
    @Basic
    @Column(name = "TAX_RATE_CODE", length = 5, nullable = false)
    private String taxRateCode;

    // Nghiệp vụ (01 - DVBC, 02 - TCBC, 03 - PHBC, 04 - Phân phối hàng hóa)
    @Basic
    @Column(name = "SERVICE_REPORT", length = 30, nullable = false)
    private String serviceReport;

    // Mã kinh doanh
    // 1 - Cung cấp dịch vụ có giá vốn
    // 2 - Cung cấp dịch vụ không có giá vốn
    // 3 - Bán hàng hóa
    // 4 - Bán hàng, dịch vụ hưởng hoa hồng
    // 5 - Cung cấp dịch vụ đại lý hưởng hoa hồng
    @Basic
    @Column(name = "BUSINESS_CODE", length = 100, nullable = false)
    private String businessCode;

    // Đầu mối thanh toán: Chọn một trong các giá trị: BĐH, BĐT, TCT
    @Basic
    @Column(name = "CLUE_PAYMENT", length = 10)
    private String cluePayment;

    // Mã khai thác thuế - Chọn 1 trong các giá trị:
    // - C (Hàng hóa, dịch vụ kê khai thuế
    // - R (Trường hợp ghi nhận doanh thu hàng hóa, dịch vụ không phải kê khai nộp thuế.
    // - K (Hàng hóa, dịch vụ không chịu thuế).
    @Basic
    @Column(name = "TAX_DECLARATION_CODE", length = 5, nullable = false)
    private String taxDeclarationCode;

    // Mã chỉ tiêu kế toán
    @Basic
    @Column(name = "ITEM_CODE_ACCOUNT", length = 20)
    private String itemCodeAccount;

    // Ký hiệu dịch vụ
    @Basic
    @Column(name = "SERVICE_SYMBOL", length = 500)
    private String serviceSymbol;

    // Loại dịch vụ
    @Basic
    @Column(name = "SERVICE_TYPE", length = 20)
    private String serviceType;

    // Trạng thái: (0: Deactive, 1: Active, -9: Delete)
    @Basic
    @Column(name = "STATUS", length = 1, nullable = false)
    private int status;

    // Ngày tạo
    @Basic
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;

    // Ngày cập nhật
    @Basic
    @Column(name = "UPDATED")
    @Temporal(TemporalType.DATE)
    private Date updated;

    // Người tạo
    @Basic
    @Column(name = "CREATEDBY", length = 50)
    private String createdBy;

    // Người cập nhật
    @Basic
    @Column(name = "UPDATEDBY", length = 50)
    private String updatedBy;

    public McasServiceEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }

}
