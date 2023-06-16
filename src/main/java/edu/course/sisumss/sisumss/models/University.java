package edu.course.sisumss.sisumss.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE universty SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class University {

    // @JsonIgnore
    @Id
    @GeneratedValue
    private Integer id;

    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private String uuid;

    @Column(nullable = false, length = 20)
    private String code;

    @Column(nullable = false, length = 500)
    private String name;

    @CreatedDate
    @Column(updatable = false, columnDefinition = "timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date createDate;

    @LastModifiedDate
    @Column(updatable = false, columnDefinition = "timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date notifieldDate;

    @OneToMany(mappedBy = "university", cascade = CascadeType.REMOVE)
    private List<Faculty> facultyList;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT '0'")
    private boolean deleted;

    /*
     * @CreatedBy
     * private User createBy;
     * 
     * @LastModifiedBy
     */

    public University() {
    }

    public University(Integer id, String uuid, String name, String code, Date createDate) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.code = code;
        this.createDate = createDate;
    }

    public University(Integer id) {
        this.id = id;

    }

    public University(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUiud(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getNotifieldDate() {
        return notifieldDate;
    }

    public void setNotifieldDate(Date notifieldDate) {
        this.notifieldDate = notifieldDate;
    }

    @PrePersist
    public void initializeUuid() {
        this.setUiud(UUID.randomUUID().toString());

    }

    public List<Faculty> getFaculty() {
        return facultyList;
    }

    public void setFaculty(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean getDeleted() {
        return deleted;
    }

}
