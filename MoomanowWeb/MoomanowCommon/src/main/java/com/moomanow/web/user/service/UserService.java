package com.moomanow.web.user.service;

import java.util.Collection;

import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.web.common.bean.User;

public interface UserService {
	public IProcessResult<User> save(User user)throws NonRollBackException,RollBackException;

	public IProcessResult<Collection<User>> findAll()throws NonRollBackException,RollBackException;

	public IProcessResult<User> find(String id)throws NonRollBackException,RollBackException;

}
