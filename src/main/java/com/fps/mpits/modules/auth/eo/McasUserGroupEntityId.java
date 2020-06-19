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
 * @author HieuDT28 (Hiếu Boy) - 19/06/2020
 * @see <a href="https://www.objectdb.com/java/jpa/entity/id">https://www.objectdb.com/java/jpa/entity/id</a>
 */

@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Embeddable
public class McasUserGroupEntityId implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã ứng dụng
    private String appCode;

    // Mã nhóm người dùng
    private String groupCode;

    // Mã đơn vị
    private String orgCode;

    // Tên đăng nhập
    private String username;


}