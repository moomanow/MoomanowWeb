package com.moomanow.web.common.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the SYS_M_ROLE_MAP_FUNCTION database table.
 * 
 */
@Entity
@Table(name="SYS_M_ROLE_MAP_FUNCTION")
@NamedQuery(name="RoleMapFunction.findAll", query="SELECT r FROM RoleMapFunction r")
public class RoleMapFunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RoleMapFunctionPK id;

	@Column(name="CREATE_DATE")
	private Timestamp createDate;

	@Column(name="CREATE_USER")
	private String createUser;

	private String status;

	@Column(name="UPDATE_DATE")
	private Timestamp updateDate;

	@Column(name="UPDATE_USER")
	private String updateUser;

	public RoleMapFunction() {
	}

	public RoleMapFunctionPK getId() {
		return this.id;
	}

	public void setId(RoleMapFunctionPK id) {
		this.id = id;
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

}