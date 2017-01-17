package com.moomanow.web.security.authen.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moomanow.core.common.bean.UserBean;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.web.security.authen.bean.IUserDefault;
import com.moomanow.web.security.authen.bean.LoginIO;


public interface LoginService {
	public IProcessResult<LoginIO> attemptAuthenticationAndPutDataSession(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws NonRollBackException,RollBackException;

	public IProcessResult<LoginIO> performLoginAndPutDataSession(String user, String password)throws NonRollBackException,RollBackException;

	public IProcessResult<LoginIO> performLoginAndPutDataSession(UserBean userBean, IUserDefault userDefault)throws NonRollBackException, RollBackException;

}
