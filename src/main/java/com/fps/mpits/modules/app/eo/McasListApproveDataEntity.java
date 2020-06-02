package com.fps.mpits.modules.app.eo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
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
 * @see <a href="https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm">https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm</a>
 */

@Entity
@Table(name = Constant.EntityTable.MCAS_LIST_APPROVE_DATA)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class McasListApproveDataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // ID tự tăng
    @Basic
    @Id
    @SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "SEQ_MCAS_LIST_APPROVE_DATA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
    @Column(name = "ID", nullable = false, updatable = false)
    private long id;

    // Tên danh mục
    @Basic
    @Column(name = "LIST_TYPE")
    private String listType;

    // Hành động với danh mục
    @Basic
    @Column(name = "LIST_ACTION")
    private String listAction;

    // ID danh mục
    @Basic
    @Column(name = "LIST_ID")
    private String listId;

    // Dữ liệu danh mục dạng JSON
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "LIST_DATA")
    private String listData;

    // Trạng thái duyệt
    @Basic
    @Column(name = "STATUS")
    private int status;

    // UID gửi yêu cầu
    @Basic
    @Column(name = "REQUEST_USER")
    private String requestUser;

    // Ngày gửi yêu cầu
    @Basic
    @Column(name = "REQUEST_DT")
    private Date requestDt;

    // UID duyệt yêu cầu
    @Basic
    @Column(name = "APPROVED_USER")
    private String approvedUser;

    // Ngày duyệt yêu cầu
    @Basic
    @Column(name = "APPROVED_DT")
    private Date approvedDt;

    @Transient
    private transient Object objEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getListAction() {
        return listAction;
    }

    public void setListAction(String listAction) {
        this.listAction = listAction;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getListData() {
        return listData;
    }

    public void setListData(String listData) {
        this.listData = listData;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRequestUser() {
        return requestUser;
    }

    public void setRequestUser(String requestUser) {
        this.requestUser = requestUser;
    }

    public Date getRequestDt() {
        return requestDt;
    }

    public void setRequestDt(Date requestDt) {
        this.requestDt = requestDt;
    }

    public String getApprovedUser() {
        return approvedUser;
    }

    public void setApprovedUser(String approvedUser) {
        this.approvedUser = approvedUser;
    }

    public Date getApprovedDt() {
        return approvedDt;
    }

    public void setApprovedDt(Date approvedDt) {
        this.approvedDt = approvedDt;
    }

    public Object getObjEntity() {
        return objEntity;
    }

    public void setObjEntity(Object objEntity) {
        this.objEntity = objEntity;
    }

}