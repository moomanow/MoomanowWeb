package com.moomanow.web.common.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigInteger;


/**
 * The persistent class for the SYS_M_MENU database table.
 * 
 */
@Entity
@Table(name="SYS_M_MENU")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MENU")
	private String idMenu;

	@Column(name="CREATE_DATE")
	private Timestamp createDate;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="ID_ACTION")
	private BigInteger idAction;

	@Column(name="ID_FUNCTION")
	private String idFunction;

	@Column(name="ID_PARENT")
	private BigInteger idParent;

	private short level;

	@Column(name="MENU_TYPE")
	private String menuType;

	private String name;

	private int seq;

	private String status;

	@Column(name="UPDATE_DATE")
	private Timestamp updateDate;

	@Column(name="UPDATE_USER")
	private String updateUser;

	public Menu() {
	}

	public String getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
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

	public BigInteger getIdAction() {
		return this.idAction;
	}

	public void setIdAction(BigInteger idAction) {
		this.idAction = idAction;
	}

	public String getIdFunction() {
		return this.idFunction;
	}

	public void setIdFunction(String idFunction) {
		this.idFunction = idFunction;
	}

	public BigInteger getIdParent() {
		return this.idParent;
	}

	public void setIdParent(BigInteger idParent) {
		this.idParent = idParent;
	}

	public short getLevel() {
		return this.level;
	}

	public void setLevel(short level) {
		this.level = level;
	}

	public String getMenuType() {
		return this.menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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