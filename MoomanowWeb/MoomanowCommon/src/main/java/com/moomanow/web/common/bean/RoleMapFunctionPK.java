package com.moomanow.web.common.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SYS_M_ROLE_MAP_FUNCTION database table.
 * 
 */
@Embeddable
public class RoleMapFunctionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ROLE")
	private String idRole;

	@Column(name="ID_FUNCTION")
	private String idFunction;

	public RoleMapFunctionPK() {
	}
	public String getIdRole() {
		return this.idRole;
	}
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}
	public String getIdFunction() {
		return this.idFunction;
	}
	public void setIdFunction(String idFunction) {
		this.idFunction = idFunction;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RoleMapFunctionPK)) {
			return false;
		}
		RoleMapFunctionPK castOther = (RoleMapFunctionPK)other;
		return 
			this.idRole.equals(castOther.idRole)
			&& this.idFunction.equals(castOther.idFunction);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRole.hashCode();
		hash = hash * prime + this.idFunction.hashCode();
		
		return hash;
	}
}