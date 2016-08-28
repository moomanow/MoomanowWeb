package com.moomanow.web.security.authen.dao;

import java.util.LinkedList;

import com.moomanow.core.common.bean.UserBean;
import com.moomanow.core.common.constant.CommonMessageCode;
import com.moomanow.core.common.dao.JdbcCommonDaoImpl;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.exception.RollBackProcessException;
import com.moomanow.web.common.bean.User;


public class UserDaoImpl extends JdbcCommonDaoImpl  implements UserDao {
	
	@Override
	public UserBean findUserByUsername(String username) throws NonRollBackException , RollBackException {
		String sql = "SELECT * FROM SYS_M_USER WHERE USERNAME = ? AND STATUS = 'A'";
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
	
	@Override
	public UserBean addUser(UserBean userBean) throws RollBackException, NonRollBackException {
		UserBean user = (UserBean) userBean;
		super.save(user);
		return user;
	}

	@Override
	public UserBean changePassword(UserBean userBean) throws RollBackException, NonRollBackException {
		return super.updateOnlyNotNullBasic(userBean);
	}


	@Override
	public UserBean update(UserBean user) throws RollBackException, NonRollBackException {
		return super.updateOnlyNotNullBasic(user);
	}
	
}
