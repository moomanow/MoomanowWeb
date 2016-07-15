package com.moomanow.web.common.bean;



import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name="SYS_M_COUNTRY"
)
public class Country  implements java.io.Serializable,com.moomanow.core.common.bean.EntityBean {


     private Long idCountry;
     private String name;
     private String code2;
     private String code3;
     private String status;
     private Date createDate;
     private String createUser;
     private Date updateDate;
     private String updateUser;
     private List<Province> provinces = new ArrayList<Province>(0);

    public Country() {
    }

    public Country(String name, String code2, String code3, String status, Date createDate, String createUser, Date updateDate, String updateUser, List<Province> provinces) {
       this.name = name;
       this.code2 = code2;
       this.code3 = code3;
       this.status = status;
       this.createDate = createDate;
       this.createUser = createUser;
       this.updateDate = updateDate;
       this.updateUser = updateUser;
       this.provinces = provinces;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID_COUNTRY", unique=true, nullable=false)
    public Long getIdCountry() {
        return this.idCountry;
    }
    
    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    
    @Column(name="NAME")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="CODE2", length=2)
    public String getCode2() {
        return this.code2;
    }
    
    public void setCode2(String code2) {
        this.code2 = code2;
    }

    
    @Column(name="CODE3", length=3)
    public String getCode3() {
        return this.code3;
    }
    
    public void setCode3(String code3) {
        this.code3 = code3;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="country")
    public List<Province> getProvinces() {
        return this.provinces;
    }
    
    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }




}


