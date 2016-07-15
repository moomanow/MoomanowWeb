package com.moomanow.web.security.authen.dao;

import com.moomanow.core.common.bean.UserBean;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;

public interface UserDao {

	public UserBean findUserByUsername(String username) throws NonRollBackException, RollBackException;

	public UserBean addUser(UserBean user) throws RollBackException, NonRollBackException;

	public UserBean findUserByIdUser(Long id) throws RollBackException, NonRollBackException;
	
	public UserBean changePassword(UserBean userBean) throws RollBackException, NonRollBackException;

	public UserBean update(UserBean user) throws RollBackException, NonRollBackException;

}
