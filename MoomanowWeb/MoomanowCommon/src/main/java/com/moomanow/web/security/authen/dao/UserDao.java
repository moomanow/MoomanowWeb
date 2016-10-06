package com.moomanow.web.security.authen.dao;

import java.util.List;

import com.moomanow.core.common.bean.UserBean;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.web.common.bean.User;

public interface UserDao {

	public UserBean findUserByUsername(String username) throws NonRollBackException, RollBackException;

	public UserBean addUser(UserBean user) throws RollBackException, NonRollBackException;

	public UserBean findUserByIdUser(Long id) throws RollBackException, NonRollBackException;
	
	public UserBean changePassword(UserBean userBean) throws RollBackException, NonRollBackException;

	public UserBean update(UserBean user) throws RollBackException, NonRollBackException;

	public List<User> findAll() throws RollBackException, NonRollBackException;

	public User save(User user)throws RollBackException, NonRollBackException;

	public User find(String id)throws RollBackException, NonRollBackException;

}
