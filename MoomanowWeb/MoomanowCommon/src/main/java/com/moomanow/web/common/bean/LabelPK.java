package com.moomanow.web.common.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SYS_M_LABEL database table.
 * 
 */
@Embeddable
public class LabelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String language;

	private String page;

	@Column(name="`LABEL`")
	private String label;

	public LabelPK() {
	}
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPage() {
		return this.page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getLabel() {
		return this.label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LabelPK)) {
			return false;
		}
		LabelPK castOther = (LabelPK)other;
		return 
			this.language.equals(castOther.language)
			&& this.page.equals(castOther.page)
			&& this.label.equals(castOther.label);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.language.hashCode();
		hash = hash * prime + this.page.hashCode();
		hash = hash * prime + this.label.hashCode();
		
		return hash;
	}
}