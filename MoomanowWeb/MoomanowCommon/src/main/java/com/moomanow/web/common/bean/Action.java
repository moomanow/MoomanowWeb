package com.moomanow.web.common.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigInteger;


/**
 * The persistent class for the SYS_M_ACTION database table.
 * 
 */
@Entity
@Table(name="SYS_M_ACTION")
@NamedQuery(name="Action.findAll", query="SELECT a FROM Action a")
public class Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ACTION")
	private String idAction;

	@Column(name="ACTION_NAME")
	private String actionName;

	@Column(name="CREATE_DATE")
	private Timestamp createDate;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="ID_FUNCTION")
	private String idFunction;

	@Column(name="ID_MENU")
	private BigInteger idMenu;

	@Column(name="INPUT_RESULT_NAME")
	private String inputResultName;

	@Column(name="NAME_SPACE")
	private String nameSpace;

	@Column(name="PAGE_NAME")
	private String pageName;

	private String status;

	private String type;

	@Column(name="UPDATE_DATE")
	private Timestamp updateDate;

	@Column(name="UPDATE_USER")
	private String updateUser;

	private String url;

	public Action() {
	}

	public String getIdAction() {
		return this.idAction;
	}

	public void setIdAction(String idAction) {
		this.idAction = idAction;
	}

	public String getActionName() {
		return this.actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
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

	public String getIdFunction() {
		return this.idFunction;
	}

	public void setIdFunction(String idFunction) {
		this.idFunction = idFunction;
	}

	public BigInteger getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(BigInteger idMenu) {
		this.idMenu = idMenu;
	}

	public String getInputResultName() {
		return this.inputResultName;
	}

	public void setInputResultName(String inputResultName) {
		this.inputResultName = inputResultName;
	}

	public String getNameSpace() {
		return this.nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public String getPageName() {
		return this.pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}