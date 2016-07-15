package com.moomanow.web.common.bean;



import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserMapPhone generated by hbm2java
 */
@Entity
@Table(name="SYS_M_USER_MAP_PHONE"
)
public class UserMapPhone  implements java.io.Serializable,com.moomanow.core.common.bean.EntityBean {


     private Long idUserMapPhone;
     private Phone phone;
     private Long idUser;
     private String status;
     private Date createDate;
     private String createUser;
     private Date updateDate;
     private String updateUser;

    public UserMapPhone() {
    }

	
    public UserMapPhone(Phone phone, Long idUser) {
        this.phone = phone;
        this.idUser = idUser;
    }
    public UserMapPhone(Phone phone, Long idUser, String status, Date createDate, String createUser, Date updateDate, String updateUser) {
       this.phone = phone;
       this.idUser = idUser;
       this.status = status;
       this.createDate = createDate;
       this.createUser = createUser;
       this.updateDate = updateDate;
       this.updateUser = updateUser;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID_USER_MAP_PHONE", unique=true, nullable=false)
    public Long getIdUserMapPhone() {
        return this.idUserMapPhone;
    }
    
    public void setIdUserMapPhone(Long idUserMapPhone) {
        this.idUserMapPhone = idUserMapPhone;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PHONE", nullable=false)
    public Phone getPhone() {
        return this.phone;
    }
    
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    
    @Column(name="ID_USER", nullable=false)
    public Long getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    
    @Column(name="STATUS", length=1)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    
    @Column(name="CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    @Column(name="CREATE_USER")
    public String getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    
    @Column(name="UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    
    @Column(name="UPDATE_USER")
    public String getUpdateUser() {
        return this.updateUser;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }




}


