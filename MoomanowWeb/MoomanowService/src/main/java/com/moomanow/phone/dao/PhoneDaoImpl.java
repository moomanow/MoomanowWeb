package com.moomanow.phone.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.moomanow.core.common.bean.PagingBean;
import com.moomanow.core.common.constant.CommonMessageCode;
import com.moomanow.core.common.constant.Status;
import com.moomanow.core.common.context.CurrentThread;
import com.moomanow.core.common.dao.CommonDaoImpl;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.exception.RollBackProcessException;
import com.moomanow.core.common.processhandler.ProcessContext;
import com.moomanow.web.common.bean.Phone;
import com.moomanow.web.common.bean.PhoneCode;
import com.moomanow.web.common.bean.PhoneType;

public class PhoneDaoImpl extends CommonDaoImpl implements PhoneDao {

	@Override
	public Collection<Phone> searchPhone(Phone phone, PagingBean pagingBean)throws RollBackException, NonRollBackException {
		return findByExampleLike(phone, pagingBean);
	}

	@Override
	public Collection<Phone> finePhone(Phone phone, PagingBean pagingBean)throws RollBackException, NonRollBackException {
		return findByExample(phone, pagingBean);
	}

	@Override
	public Phone finePhoneById(Serializable id) throws RollBackException, NonRollBackException {
		return findById(Phone.class, id);
	}
	@Override
	public void savePhone(Phone phone) throws RollBackException, NonRollBackException {
		ProcessContext processContext = CurrentThread.getProcessContext();
		phone.setStatus(Status.ACTIVE.getShort());
		phone.setCreateDate(new Date());
		phone.setCreateUser(processContext.getUserName());
		save(phone);
	}

	@Override
	public void updatePhone(Phone phone) throws RollBackException, NonRollBackException {
		if(phone.getIdPhone()==null||phone.getIdPhone()==0)
			throw new RollBackProcessException(CommonMessageCode.COM4994);
		ProcessContext processContext = CurrentThread.getProcessContext();
		phone.setUpdateDate(new Date());
		phone.setUpdateUser(processContext.getUserName());
		update(phone);
	}

	@Override
	public void deletePhone(Phone phone) throws RollBackException, NonRollBackException {
		if(phone.getIdPhone()==null||phone.getIdPhone()==0)
			throw new RollBackProcessException(CommonMessageCode.COM4994);
		ProcessContext processContext = CurrentThread.getProcessContext();
		phone.setStatus(Status.INACTIVE.getShort());
		phone.setUpdateDate(new Date());
		phone.setUpdateUser(processContext.getUserName());
		update(phone);
	}


	@Override
	public Collection<PhoneCode> searchPhoneCode(PhoneCode phone, PagingBean pagingBean)throws RollBackException, NonRollBackException {
		return findByExampleLike(phone, pagingBean);
	}

	@Override
	public Collection<PhoneCode> finePhoneCode(PhoneCode phone, PagingBean pagingBean)throws RollBackException, NonRollBackException {
		return findByExample(phone, pagingBean);
	}

	@Override
	public PhoneCode finePhoneCodeById(Serializable id) throws RollBackException, NonRollBackException {
		return findById(PhoneCode.class, id);
	}
	@Override
	public void savePhoneCode(PhoneCode phone) throws RollBackException, NonRollBackException {
		ProcessContext processContext = CurrentThread.getProcessContext();
		phone.setStatus(Status.ACTIVE.getShort());
		phone.setCreateDate(new Date());
		phone.setCreateUser(processContext.getUserName());
		save(phone);
	}

	@Override
	public void updatePhoneCode(PhoneCode phone) throws RollBackException, NonRollBackException {
		if(phone.getIdPhoneCode()==null||phone.getIdPhoneCode()==0)
			throw new RollBackProcessException(CommonMessageCode.COM4994);
		ProcessContext processContext = CurrentThread.getProcessContext();
		phone.setUpdateDate(new Date());
		phone.setUpdateUser(processContext.getUserName());
		update(phone);
	}

	@Override
	public void deletePhoneCode(PhoneCode phone) throws RollBackException, NonRollBackException {
		if(phone.getIdPhoneCode()==null||phone.getIdPhoneCode()==0)
			throw new RollBackProcessException(CommonMessageCode.COM4994);
		ProcessContext processContext = CurrentThread.getProcessContext();
		phone.setStatus(Status.INACTIVE.getShort());
		phone.setUpdateDate(new Date());
		phone.setUpdateUser(processContext.getUserName());
		update(phone);
	}
	
	@Override
	public Collection<PhoneType> searchPhoneType(PhoneType phone, PagingBean pagingBean)throws RollBackException, NonRollBackException {
		return findByExampleLike(phone, pagingBean);
	}

	@Override
	public Collection<PhoneType> finePhoneType(PhoneType phone, PagingBean pagingBean)throws RollBackException, NonRollBackException {
		return findByExample(phone, pagingBean);
	}

	@Override
	public PhoneType finePhoneTypeById(Serializable id) throws RollBackException, NonRollBackException {
		return findById(PhoneType.class, id);
	}
	@Override
	public void savePhoneType(PhoneType phone) throws RollBackException, NonRollBackException {
		ProcessContext processContext = CurrentThread.getProcessContext();
		phone.setStatus(Status.ACTIVE.getShort());
		phone.setCreateDate(new Date());
		phone.setCreateUser(processContext.getUserName());
		save(phone);
	}

	@Override
	public void updatePhoneType(PhoneType phone) throws RollBackException, NonRollBackException {
		if(phone.getIdPhoneType()==null||phone.getIdPhoneType()==0)
			throw new RollBackProcessException(CommonMessageCode.COM4994);
		ProcessContext processContext = CurrentThread.getProcessContext();
		phone.setUpdateDate(new Date());
		phone.setUpdateUser(processContext.getUserName());
		update(phone);
	}

	@Override
	public void deletePhoneType(PhoneType phone) throws RollBackException, NonRollBackException {
		if(phone.getIdPhoneType()==null||phone.getIdPhoneType()==0)
			throw new RollBackProcessException(CommonMessageCode.COM4994);
		ProcessContext processContext = CurrentThread.getProcessContext();
		phone.setStatus(Status.INACTIVE.getShort());
		phone.setUpdateDate(new Date());
		phone.setUpdateUser(processContext.getUserName());
		update(phone);
	}

	

}
