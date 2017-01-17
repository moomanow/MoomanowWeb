package com.moomanow.phone.dao;

import java.io.Serializable;
import java.util.Collection;

import com.moomanow.core.common.bean.PagingBean;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.web.common.bean.Phone;
import com.moomanow.web.common.bean.PhoneCode;
import com.moomanow.web.common.bean.PhoneType;

public interface PhoneDao {
	
	public Collection<Phone>searchPhone(Phone phone, PagingBean pagingBean)throws RollBackException, NonRollBackException;
	public Collection<Phone>finePhone(Phone phone, PagingBean pagingBean)throws RollBackException, NonRollBackException;
	public Phone finePhoneById(Serializable id)throws RollBackException, NonRollBackException;
	public void savePhone(Phone phone)throws RollBackException, NonRollBackException;
	public void updatePhone(Phone phone)throws RollBackException, NonRollBackException;
	public void deletePhone(Phone phone)throws RollBackException, NonRollBackException;
	
	public Collection<PhoneCode>searchPhoneCode(PhoneCode phone, PagingBean pagingBean)throws RollBackException, NonRollBackException;
	public Collection<PhoneCode>finePhoneCode(PhoneCode phone, PagingBean pagingBean)throws RollBackException, NonRollBackException;
	public PhoneCode finePhoneCodeById(Serializable id)throws RollBackException, NonRollBackException;
	public void savePhoneCode(PhoneCode phoneCode)throws RollBackException, NonRollBackException;
	public void updatePhoneCode(PhoneCode phoneCode)throws RollBackException, NonRollBackException;
	public void deletePhoneCode(PhoneCode phoneCode)throws RollBackException, NonRollBackException;
	
	public Collection<PhoneType>searchPhoneType(PhoneType phone, PagingBean pagingBean)throws RollBackException, NonRollBackException;
	public Collection<PhoneType>finePhoneType(PhoneType phone, PagingBean pagingBean)throws RollBackException, NonRollBackException;
	public PhoneType finePhoneTypeById(Serializable id)throws RollBackException, NonRollBackException;
	public void savePhoneType(PhoneType phoneType)throws RollBackException, NonRollBackException;
	public void updatePhoneType(PhoneType phoneType)throws RollBackException, NonRollBackException;
	public void deletePhoneType(PhoneType phoneType)throws RollBackException, NonRollBackException;
}
