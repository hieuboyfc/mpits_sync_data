package com.fps.mpits.modules.cate_system_other.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 13/07/2020 - 17:30
 */

@Accessors(fluent = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Embeddable
public class McasItemGroupTypeEntityId implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã nhóm hàng
    private String itemGroupId;

    // Mã loại hàng
    private String itemTypeId;

}
