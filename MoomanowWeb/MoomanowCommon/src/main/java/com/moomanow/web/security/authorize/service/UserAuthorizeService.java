package com.moomanow.web.security.authorize.service;


import com.moomanow.core.common.bean.UserBean;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.processhandler.IProcessResult;

public interface UserAuthorizeService {
	public IProcessResult<UserBean> addRolesUser(UserBean userBean) throws NonRollBackException , RollBackException;
}
