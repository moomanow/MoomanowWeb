package com.moomanow.phone.process;

import java.util.Collection;

import com.moomanow.core.common.bean.PagingBean;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.web.common.bean.Phone;

public interface PhoneProcess {

	public IProcessResult<Phone> userAddPhone(Phone phone)throws RollBackException, NonRollBackException;
	public IProcessResult<Collection<Phone>> userSearchPhone(Phone phone,PagingBean pagingBean) throws RollBackException, NonRollBackException;
}
