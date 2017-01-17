package com.moomanow.phone.process;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.moomanow.core.common.bean.PagingBean;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.phone.service.PhoneService;
import com.moomanow.web.common.bean.Phone;

public class PhoneProcessImpl implements PhoneProcess {

	@Autowired
	private PhoneService phoneService;
	@Override
	public IProcessResult<Phone> userAddPhone(Phone phone) throws RollBackException, NonRollBackException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IProcessResult<Collection<Phone>> userSearchPhone(Phone phone, PagingBean pagingBean)throws RollBackException, NonRollBackException {
		return phoneService.searchPhone(phone, pagingBean);
	}
	
}
