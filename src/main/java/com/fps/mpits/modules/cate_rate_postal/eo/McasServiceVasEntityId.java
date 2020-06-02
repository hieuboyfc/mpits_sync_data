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
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

@Accessors(fluent = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Embeddable
public class McasServiceVasEntityId implements Serializable {

    private static final long serialVersionUID = 1L;

    //Mã ứng dụng
    private String vaServiceId;

    //Mã nhóm người dùng
    private String mailServiceId;

}