package com.moomanow.web.common.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.moomanow.authentication.bean.UserAuthenticationBean;
import com.moomanow.core.common.bean.UserBean;


/**
 * The persistent class for the SYS_M_USER database table.
 * 
 */
@Entity
@Table(name="SYS_M_USER")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable,UserBean,UserAuthenticationBean {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USER")
	private String idUser;

	@Column(name="CREATE_DATE")
	private Timestamp createDate;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="ID_PREFIX_NAME")
	private BigInteger idPrefixName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="MAIDEN_SURNAME")
	private String maidenSurname;

	@Column(name="MID_NAME")
	private String midName;

	@Column(name="NICK_NAME")
	private String nickName;

	private String password;

	private String status;

	@Column(name="UPDATE_DATE")
	private Timestamp updateDate;

	@Column(name="UPDATE_USER")
	private String updateUser;

	private String username;
	
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

	public String getIdUser() {
		return this.idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public BigInteger getIdPrefixName() {
		return this.idPrefixName;
	}

	public void setIdPrefixName(BigInteger idPrefixName) {
		this.idPrefixName = idPrefixName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaidenSurname() {
		return this.maidenSurname;
	}

	public void setMaidenSurname(String maidenSurname) {
		this.maidenSurname = maidenSurname;
	}

	public String getMidName() {
		return this.midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Transient
	@Override
	public String getUserId() {
		return idUser;
	}

	@Transient
	public void setUserId(String userId) {
		this.idUser = userId;
	}

	@Transient
	public String getUserName() {
		return username;
	}

	@Transient
	public void setUserName(String userName) {
		this.username =userName;
	}


	@Transient
	public Set<String> getRoles() {
		return roles;
	}

	
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
	public void setRoles(Set<String> roles) {
		this.roles = roles;
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

}