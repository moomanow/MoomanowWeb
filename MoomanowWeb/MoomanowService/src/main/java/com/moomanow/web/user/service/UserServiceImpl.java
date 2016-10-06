package com.moomanow.web.user.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.web.common.bean.User;
import com.moomanow.web.common.process.bean.ProcessResult;
import com.moomanow.web.security.authen.dao.UserDao;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public IProcessResult<User> save(User user) throws NonRollBackException, RollBackException {
		return new ProcessResult<>(userDao.save(user));
	}

	@Override
	public IProcessResult<Collection<User>> findAll() throws NonRollBackException, RollBackException {
		return new ProcessResult<>(userDao.findAll());
	}

	@Override
	public IProcessResult<User> find(String id) throws NonRollBackException, RollBackException {
		return new ProcessResult<>(userDao.find(id));
	}

}
