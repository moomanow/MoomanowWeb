package com.moomanow.web.security.authen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.moomanow.core.common.bean.UserBean;
import com.moomanow.core.common.constant.CommonConstant;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.exception.RollBackProcessException;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.web.common.constant.ProMessageCode;
import com.moomanow.web.common.process.bean.ProcessResult;
import com.moomanow.web.security.authen.dao.UserOpenIdDao;

public class AuthenServiceImpl implements AuthenService {

	@Autowired
	private UserOpenIdDao userOpenIdDao;
	@Autowired
	@Qualifier("md5EncryptService")
	private EncryptService encryptService;
	@Override
	public IProcessResult<UserBean> login(String username, String password)throws NonRollBackException, RollBackException {
		UserBean userBean = userOpenIdDao.findUserByUsername(username);
		String passwordEncrypt = encryptService.encryptString(password);
		if(userBean==null||!userBean.getPassword().equals(passwordEncrypt)){
			throw new RollBackProcessException(ProMessageCode.ATC2001);
		}
		if(!CommonConstant.ACTIVE.equals(userBean.getStatus())){
			throw new RollBackProcessException(ProMessageCode.ATC2002);
		}
		
		return new ProcessResult<UserBean>(userBean);
	}

}
