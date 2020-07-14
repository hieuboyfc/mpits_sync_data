package com.fps.mpits.modules.auth.eo;

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
import java.util.List;

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 * @see <a href="https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm"></a>
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_USER_APP)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@IdClass(McasUserAppEntityId.class)
public class McasUserAppEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã ứng dụng
    @Basic
    @Id
    @Column(name = "APP_CODE", nullable = false)
    private String appCode;

    // Tên người dùng
    @Basic
    @Id
    @Column(name = "USERNAME", nullable = false)
    private String username;

    // Trạng thái (0 - chưa kích hoạt, 1 đã kích hoạt)
    @Basic
    @Column(name = "STATUS")
    private int status;

    @Transient
    private List<McasUserEntity> lstMcasUserEntity;

    @Transient
    private List<McasEmployeeEntity> lstMcasEmployeeEntity;

    public McasUserAppEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }
}