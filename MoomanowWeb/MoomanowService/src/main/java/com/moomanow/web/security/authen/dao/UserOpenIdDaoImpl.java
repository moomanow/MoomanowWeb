package com.moomanow.web.security.authen.dao;

import java.util.LinkedList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.moomanow.core.common.bean.UserBean;
import com.moomanow.core.common.constant.CommonMessageCode;
import com.moomanow.core.common.dao.JdbcCommonDaoImpl;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.exception.RollBackProcessException;
import com.moomanow.web.common.bean.User;


public class UserOpenIdDaoImpl extends JdbcCommonDaoImpl  implements UserOpenIdDao {
	@PersistenceContext(unitName="defaultPersistenceUnit")
	private EntityManager manager;
	
	@Override
	public UserBean findUserByUsername(String username) throws NonRollBackException , RollBackException {
		String sql = "SELECT * FROM SYS_M_USER WHERE USERNAME = ? AND STATUS = 'A'";
//		manager.createQuery("User.findAll");
		LinkedList<Object> params = new LinkedList<Object>();
        params.add( username );
        User userBean = nativeQueryOneRow(sql, User.class, params.toArray());
		if(userBean ==null)
			throw new RollBackProcessException(CommonMessageCode.COM0004);
		return userBean;
	}

	@Override
	public UserBean findUserByIdUser(Long id) throws NonRollBackException, RollBackException {
		String sql = "SELECT * FROM SYS_M_USER WHERE ID_USER = ? ";
		LinkedList<Object> params = new LinkedList<Object>();
        params.add( id );
		User userBean = nativeQueryOneRow(sql, User.class, params.toArray());
		if(userBean ==null)
			throw new RollBackProcessException(CommonMessageCode.COM0004);
		return userBean;
	}
	
	
}
