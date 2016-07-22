package com.moomanow.web.common.bean;

// Generated Jul 16, 2014 1:23:31 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.moomanow.core.common.bean.EntityBean;
import com.moomanow.core.common.bean.UserBean;


/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "SYS_M_USER")
public class User implements java.io.Serializable, EntityBean , UserBean {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_USER", unique = true, nullable = false)
	private Long id;
	private String username;
	private Long prefixNameId;
	private String password;
	private String firstName;
	private String midName;
	private String lastName;
	private String maidenSurname;
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	private String createUser;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	private String updateUser;
//	private List<Phone> phones = new ArrayList<Phone>(0);
//	private List<UserMapAddress> userMapAddresses = new ArrayList<UserMapAddress>(0);
	
	@Transient
	private Set<String> roles;
	@Transient
	private Set<String> privileges;
	@Transient
	private String roleName;
	@Transient
	private String passwordAgain;

	public User() {
	}

	public User(String username, Date createDate, Date updateDate) {
		this.username = username;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public User(String username, Long prefixNameId, String password,
			String firstName, String midName, String lastName, String maidenSurname, String status,
			Date createDate, String createUser, Date updateDate,
			String updateUser
//			,List<Phone> phones,
//			List<UserMapAddress> userMapAddresses
			) {
		this.username = username;
		this.prefixNameId = prefixNameId;
		this.password = password;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.maidenSurname = maidenSurname;
		this.status = status;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
//		this.phones = phones;
//		this.userMapAddresses = userMapAddresses;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_USER", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USERNAME", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "ID_PREFIX_NAME")
	public Long getPrefixNameId() {
		return this.prefixNameId;
	}

	public void setPrefixNameId(Long prefixNameId) {
		this.prefixNameId = prefixNameId;
	}

	@Column(name = "PASSWORD", length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "MID_NAME")
	public String getMidName() {
		return this.midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "MAIDEN_SURNAME")
	public String getMaidenSurname() {
		return this.maidenSurname;
	}

	public void setMaidenSurname(String maidenSurname) {
		this.maidenSurname = maidenSurname;
	}
	
	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CREATE_USER")

    @Temporal(TemporalType.TIMESTAMP)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	
	@Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_USER")
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Transient
	
	public String getName() {
		return firstName + " "+lastName;
	}
	@Transient
	
	public String getRole() {
		if(roles==null)
			return null;
		List<String> list = new ArrayList<String>(roles);
		return list.get(list.size()-1);
	}
	@Transient
	
	public void setRole(String role) {
		if(roles==null)
			roles = new HashSet<String>();
		roles.add(role);
	}

	@Transient
	public Set<String> getPrivileges() {
		return privileges;
	}
	@Transient
	public void setPrivileges(Set<String> privileges) {
		this.privileges = privileges;
	}

	@Transient
	public String getUserId() {
		return id+"";
	}
	
	@Transient
	public Set<String> getRoles() {
		return roles;
	}
	@Transient
	public String getUserName() {
		return username;
	}
	@Transient
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	@Transient
	public void setUserId(String userId) {
		id = Long.parseLong(userId);
	}
	@Transient
	
	public void setUserName(String userName) {
		this.username = userName;
	}

	@Transient
	
	public String getRoleName() {
		return roleName;
	}

	@Transient
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Transient
	public String getPasswordAgain() {
		return passwordAgain;
	}
	
	@Transient
	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}
//	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//	public List<Phone> getPhones() {
//		return this.phones;
//	}
//
//	public void setPhones(List<Phone> phones) {
//		this.phones = phones;
//	}
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//	public List<UserMapAddress> getUserMapAddresses() {
//		return this.userMapAddresses;
//	}
//
//	public void setUserMapAddresses(
//			List<UserMapAddress> userMapAddresses) {
//		this.userMapAddresses = userMapAddresses;
//	}
	@Transient
	@Override
	public String getUserImagePath() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	@Override
	public void setUserImagePath(String userImagePath) {
		// TODO Auto-generated method stub
		
	}
	
}