package com.moomanow.phone.service;

import java.util.Collection;

import com.moomanow.core.common.bean.PagingBean;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.web.common.bean.Phone;

public interface PhoneService {
	
	public IProcessResult<Collection<Phone>> searchPhone(Phone phone, PagingBean pagingBean)throws RollBackException, NonRollBackException;

}
