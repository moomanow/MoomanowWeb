package com.moomanow.web.common.bean;
// Generated Nov 1, 2016 2:55:18 PM by Hibernate Tools 4.3.5.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.moomanow.core.common.context.CurrentThread;
import com.moomanow.core.common.processhandler.ProcessContext;

/**
 * PhoneType generated by hbm2java
 */
@Entity
@Table(name="SYS_M_PHONE_TYPE"
)
public class PhoneType  implements java.io.Serializable {


     private Long idPhoneType;
     private Integer seq;
     private String name;
     private String status;
     private Date createDate;
     private String createUser;
     private Date updateDate;
     private String updateUser;
     private Set<Phone> phones = new HashSet<Phone>(0);

    public PhoneType() {
    }

    public PhoneType(Integer seq, String name, String status, Date createDate, String createUser, Date updateDate, String updateUser, Set<Phone> phones) {
       this.seq = seq;
       this.name = name;
       this.status = status;
       this.createDate = createDate;
       this.createUser = createUser;
       this.updateDate = updateDate;
       this.updateUser = updateUser;
       this.phones = phones;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID_PHONE_TYPE", unique=true, nullable=false)
    public Long getIdPhoneType() {
        return this.idPhoneType;
    }
    
    public void setIdPhoneType(Long idPhoneType) {
        this.idPhoneType = idPhoneType;
    }

    
    @Column(name="SEQ")
    public Integer getSeq() {
        return this.seq;
    }
    
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    
//    @Column(name="NAME")
//    public String getName() {
//        return this.name;
//    }
//    
//    public void setName(String name) {
//        this.name = name;
//    }

  //##############################################################
    private Map<String, String> names;
    private String nameLang;
    @Transient
    public String getNameLang() {
		return nameLang;
	}

	public void setNameLang(String nameLang) {
		this.nameLang = nameLang;
	}
    
    @Column(name="NAME")
    public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
        ProcessContext processContext = CurrentThread.getProcessContext();
    	String lang = processContext.getLang();
        if("ENG".equals(lang))
        	this.nameLang = name;
    }
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
      name="SYS_M_PHONE_TYPE_LANG",
      joinColumns=@JoinColumn(name="ID_PHONE_TYPE")
      )
    @Column(name="NAME")
    @MapKeyColumn(name="LANG_CODE3")
    public Map<String, String> getNames() {
        return this.names;
    }
    
    public void setNames(Map<String, String> names) {
        this.names = names;
        ProcessContext processContext = CurrentThread.getProcessContext();
    	String lang = processContext.getLang();
        if(lang!=null&&!"ENG".equals(lang)&&names!=null&&names.containsKey(lang))
        	this.nameLang = names.get(lang);
    }
  //####################################################################
    
    @Column(name="STATUS", length=1)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATE_DATE", length=19)
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATE_DATE", length=19)
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="phoneType")
    public Set<Phone> getPhones() {
        return this.phones;
    }
    
    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }




}

