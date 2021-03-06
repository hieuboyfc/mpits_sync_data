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

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 * @see <a href="https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm"></a>
 */

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = Constant.EntityTable.MCAS_GROUP)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@IdClass(McasGroupEntityId.class)
public class McasGroupEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Mã ứng dụng
    @Basic
    @Id
    @Column(name = "APP_CODE", nullable = false)
    private String appCode;

    // Mã nhóm người dùng
    @Basic
    @Id
    @Column(name = "GROUP_CODE", nullable = false)
    private String groupCode;

    // Tên nhóm người dùng
    @Basic
    @Column(name = "NAME")
    private String name;

    // Mô tả nhóm người dùng
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;

    // Trạng thái
    @Basic
    @Column(name = "STATUS")
    private int status;

    public McasGroupEntity cloneNotRef() {
        return SerializationUtils.clone(this);
    }

}