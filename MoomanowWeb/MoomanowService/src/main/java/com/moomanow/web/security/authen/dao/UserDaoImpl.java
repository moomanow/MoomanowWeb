package com.moomanow.web.security.authen.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.eclipse.persistence.indirection.IndirectContainer;

import com.moomanow.core.common.bean.UserBean;
import com.moomanow.core.common.constant.CommonMessageCode;
import com.moomanow.core.common.dao.CommonDaoImpl;
import com.moomanow.core.common.dao.JdbcCommonDaoImpl;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.exception.RollBackProcessException;
import com.moomanow.web.common.bean.Phone;
import com.moomanow.web.common.bean.PhoneCode;
import com.moomanow.web.common.bean.User;


public class UserDaoImpl extends CommonDaoImpl  implements UserDao {
	@PersistenceContext(unitName="defaultPersistenceUnit")
	private EntityManager manager;
	
	@Override
	public UserBean findUserByUsername(String username) throws NonRollBackException , RollBackException {
		String sql = "SELECT * FROM SYS_M_USER WHERE USERNAME = ? AND STATUS = 'A'";
//		manager.createQuery("User.findAll");
		LinkedList<Object> params = new LinkedList<Object>();
        params.add( username );
        User userBean = (User) nativeQuerySingleResult(sql, params.toArray());
		if(userBean ==null)
			throw new RollBackProcessException(CommonMessageCode.COM0004);
		return userBean;
	}

	@Override
	public UserBean findUserByIdUser(Long id) throws NonRollBackException, RollBackException {
		String sql = "SELECT * FROM SYS_M_USER WHERE ID_USER = ? ";
		LinkedList<Object> params = new LinkedList<Object>();
        params.add( id );
		User userBean = (User) nativeQuerySingleResult(sql, User.class, params.toArray());
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
		return super.update(userBean);
	}


	@Override
	public UserBean update(UserBean user) throws RollBackException, NonRollBackException {
		return super.update(user);
	}

	@Override
	public List<User> findAll() throws RollBackException, NonRollBackException {
		return manager.createQuery("SELECT p FROM User p").getResultList();
	}

	@Override
	public User save(User user) throws RollBackException, NonRollBackException {
		return manager.merge(user);
	}

	@Override
	public User find(String id) throws RollBackException, NonRollBackException {
		return manager.find(User.class, id);
	}
	
}
