package com.moomanow.web.common.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SYS_M_MESSAGE database table.
 * 
 */
@Embeddable
public class MessagePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MESSAGE_CODE")
	private String messageCode;

	@Column(name="MESSAGE_LANG")
	private String messageLang;

	public MessagePK() {
	}
	public String getMessageCode() {
		return this.messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getMessageLang() {
		return this.messageLang;
	}
	public void setMessageLang(String messageLang) {
		this.messageLang = messageLang;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MessagePK)) {
			return false;
		}
		MessagePK castOther = (MessagePK)other;
		return 
			this.messageCode.equals(castOther.messageCode)
			&& this.messageLang.equals(castOther.messageLang);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.messageCode.hashCode();
		hash = hash * prime + this.messageLang.hashCode();
		
		return hash;
	}
}