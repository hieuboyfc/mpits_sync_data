package com.fps.mpits.modules.auth.eo;

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
 * @see <a href="https://www.objectdb.com/java/jpa/entity/id"></a>
 */

@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Embeddable
public class McasGroupEntityId implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã ứng dụng
    private String appCode;

    // Mã nhóm người dùng
    private String groupCode;

}