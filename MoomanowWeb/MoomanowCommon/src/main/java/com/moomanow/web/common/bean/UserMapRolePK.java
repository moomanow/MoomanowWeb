package com.moomanow.web.common.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SYS_M_USER_MAP_ROLE database table.
 * 
 */
@Embeddable
public class UserMapRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USER")
	private String idUser;

	@Column(name="ID_ROLE")
	private String idRole;

	public UserMapRolePK() {
	}
	public String getIdUser() {
		return this.idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getIdRole() {
		return this.idRole;
	}
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserMapRolePK)) {
			return false;
		}
		UserMapRolePK castOther = (UserMapRolePK)other;
		return 
			this.idUser.equals(castOther.idUser)
			&& this.idRole.equals(castOther.idRole);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUser.hashCode();
		hash = hash * prime + this.idRole.hashCode();
		
		return hash;
	}
}