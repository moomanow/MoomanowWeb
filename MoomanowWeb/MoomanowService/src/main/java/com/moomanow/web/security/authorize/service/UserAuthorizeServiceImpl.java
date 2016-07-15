package com.moomanow.web.security.authorize.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.moomanow.core.common.bean.UserBean;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.exception.RollBackProcessException;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.web.common.constant.ProMessageCode;
import com.moomanow.web.common.process.bean.ProcessResult;
import com.moomanow.web.security.authorize.dao.UserAuthorizeDao;

public class UserAuthorizeServiceImpl implements UserAuthorizeService {

	
	private UserAuthorizeDao userAuthorizeDao;
	@Autowired
	@Required
	public void setUserAuthorizeDao(UserAuthorizeDao userAuthorizeDao) {
		this.userAuthorizeDao = userAuthorizeDao;
	}
	@Override
	public IProcessResult<UserBean> addRolesUser(UserBean userBean) throws NonRollBackException, RollBackException {
		Set<String> roles = userAuthorizeDao.getUserRoles(userBean.getUserId());
		if(roles.size()<=0){
			throw new RollBackProcessException(ProMessageCode.ATZ2002);
		}
		Set<String> privileges = userAuthorizeDao.getUserPrivileges(userBean.getUserId());
		userBean.setRoles(roles);
		userBean.setPrivileges(privileges);
		return new ProcessResult<UserBean>(userBean);
	}

}
