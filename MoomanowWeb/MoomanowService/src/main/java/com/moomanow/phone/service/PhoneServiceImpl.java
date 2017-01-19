package com.moomanow.phone.service;

import java.util.Collection;

import com.moomanow.core.common.bean.PagingBean;
import com.moomanow.core.common.constant.CommonMessageCode;
import com.moomanow.core.common.constant.MessageCode;
import com.moomanow.core.common.context.CurrentThread;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.core.common.processhandler.ProcessContext;
import com.moomanow.phone.dao.PhoneDao;
import com.moomanow.web.common.bean.Phone;
import com.moomanow.web.common.process.bean.ProcessResult;

public class PhoneServiceImpl implements PhoneService {
	
	private PhoneDao phoneDao;

	@Override
	public IProcessResult<Collection<Phone>> searchPhone(Phone phone, PagingBean pagingBean)throws RollBackException, NonRollBackException {
		ProcessContext processContext = CurrentThread.getProcessContext();
		Collection<Phone> phones = phoneDao.searchPhone(phone, pagingBean);
		processContext.addMessage(CommonMessageCode.COM0000);
		return new ProcessResult<Collection<Phone>>(phones,pagingBean);
	}

}
