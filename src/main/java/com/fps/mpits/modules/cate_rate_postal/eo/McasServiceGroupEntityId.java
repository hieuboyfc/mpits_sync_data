package com.fps.mpits.modules.cate_rate_postal.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 */

@Accessors(fluent = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Embeddable
public class McasServiceGroupEntityId implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã nhóm dịch vụ
    private String serviceGroupId;

    // Nghiệp vụ (01 - DVBC, 02 - TCBC, 03 - PHBC, 04 - Phân phối hàng hóa)
    private String serviceReport;

}