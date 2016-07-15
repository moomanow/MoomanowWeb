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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Address generated by hbm2java
 */
@Entity
@Table(name="SYS_M_ADDRESS"
)
public class Address  implements java.io.Serializable,com.moomanow.core.common.bean.EntityBean {


     private Long idAddress;
     private County county;
     private String housingNo;
     private String streetAddress1;
     private String streetAddress2;
     private String zipcode;
     private String lat;
     private String lng;
     private String description;
     private String status;
     private Date createDate;
     private String createUser;
     private Date updateDate;
     private String updateUser;
     private List<AddressMapPhone> addressMapPhones = new ArrayList<AddressMapPhone>(0);
     private List<UserMapAddress> userMapAddresses = new ArrayList<UserMapAddress>(0);

    public Address() {
    }

    public Address(County county, String housingNo, String streetAddress1, String streetAddress2, String zipcode, String lat, String lng, String description, String status, Date createDate, String createUser, Date updateDate, String updateUser, List<AddressMapPhone> addressMapPhones, List<UserMapAddress> userMapAddresses) {
       this.county = county;
       this.housingNo = housingNo;
       this.streetAddress1 = streetAddress1;
       this.streetAddress2 = streetAddress2;
       this.zipcode = zipcode;
       this.lat = lat;
       this.lng = lng;
       this.description = description;
       this.status = status;
       this.createDate = createDate;
       this.createUser = createUser;
       this.updateDate = updateDate;
       this.updateUser = updateUser;
       this.addressMapPhones = addressMapPhones;
       this.userMapAddresses = userMapAddresses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID_ADDRESS", unique=true, nullable=false)
    public Long getIdAddress() {
        return this.idAddress;
    }
    
    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="ID_COUNTRY", referencedColumnName="ID_COUNTRY"), 
        @JoinColumn(name="ID_PROVINCE", referencedColumnName="ID_PROVINCE"), 
        @JoinColumn(name="ID_CITY", referencedColumnName="ID_CITY"), 
        @JoinColumn(name="ID_COUNTY", referencedColumnName="ID_COUNTY") } )
    public County getCounty() {
        return this.county;
    }
    
    public void setCounty(County county) {
        this.county = county;
    }

    
    @Column(name="HOUSING_NO")
    public String getHousingNo() {
        return this.housingNo;
    }
    
    public void setHousingNo(String housingNo) {
        this.housingNo = housingNo;
    }

    
    @Column(name="STREET_ADDRESS1")
    public String getStreetAddress1() {
        return this.streetAddress1;
    }
    
    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    
    @Column(name="STREET_ADDRESS2")
    public String getStreetAddress2() {
        return this.streetAddress2;
    }
    
    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    
    @Column(name="ZIPCODE")
    public String getZipcode() {
        return this.zipcode;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    
    @Column(name="LAT")
    public String getLat() {
        return this.lat;
    }
    
    public void setLat(String lat) {
        this.lat = lat;
    }

    
    @Column(name="LNG")
    public String getLng() {
        return this.lng;
    }
    
    public void setLng(String lng) {
        this.lng = lng;
    }

    
    @Column(name="DESCRIPTION", length=65535)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="address")
    public List<AddressMapPhone> getAddressMapPhones() {
        return this.addressMapPhones;
    }
    
    public void setAddressMapPhones(List<AddressMapPhone> addressMapPhones) {
        this.addressMapPhones = addressMapPhones;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="address")
    public List<UserMapAddress> getUserMapAddresses() {
        return this.userMapAddresses;
    }
    
    public void setUserMapAddresses(List<UserMapAddress> userMapAddresses) {
        this.userMapAddresses = userMapAddresses;
    }



}


