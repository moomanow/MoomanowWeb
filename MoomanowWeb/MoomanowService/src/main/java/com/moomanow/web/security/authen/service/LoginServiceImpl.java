package com.moomanow.web.security.authen.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.moomanow.core.common.bean.UserBean;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.NonRollBackProcessException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.openid.connect.client.service.OpenIdClientService;
import com.moomanow.web.common.constant.ProMessageCode;
import com.moomanow.web.common.process.bean.ProcessResult;
import com.moomanow.web.security.authen.bean.LoginIO;
import com.moomanow.web.security.authen.bean.LoginIOBean;
import com.moomanow.web.security.authen.bean.MenuVO;
import com.moomanow.web.security.authen.dao.UserDao;
import com.moomanow.web.security.authorize.service.UserAuthorizeService;
import com.moomanow.web.security.authorize.service.UserMenuService;


public class LoginServiceImpl implements LoginService  {

	@Autowired(required=false)
	private OpenIdClientService openIdClientService;
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserAuthorizeService userAuthorizeService;
	@Autowired
	private UserMenuService userMenuService;
	@Autowired
	private AuthenService authenService;
	@Override
	public IProcessResult<LoginIO> attemptAuthenticationAndPutDataSession(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws NonRollBackException, RollBackException {
		LoginIO loginIO = new LoginIOBean();
		try {
			Authentication authentication = openIdClientService.attemptAuthentication(httpServletRequest, httpServletResponse);
			if(authentication ==null){
				loginIO.setGotoPage("null");
				return new ProcessResult<LoginIO>(loginIO);
			}else{
				String sub = null;
				if(authentication.getPrincipal() instanceof Map){
					Map principalMap = (Map) authentication.getPrincipal();
					sub = (String) principalMap.get("sub");
					
				}
				UserBean userBean =  userDao.findUserByIdUser(Long.parseLong(sub));
				IProcessResult<UserBean> serviceResult = userAuthorizeService.addRolesUser(userBean);
				userBean = serviceResult.getResult();
				IProcessResult<MenuVO> serviceResultMenu = userMenuService.generateMenuList(serviceResult.getResult());
				loginIO.setUserBean(userBean);
				loginIO.setMenuVO(serviceResultMenu.getResult());
				Map<String, Object> session = new HashMap<String, Object>();
				loginIO.setSession(session);
				return new ProcessResult<LoginIO>(loginIO);
			}
		} catch (AuthenticationException | IOException | ServletException e) {
			throw new NonRollBackProcessException(ProMessageCode.ATZ2002,e);
		}
	}
	@Override
	public IProcessResult<LoginIO> performLoginAndPutDataSession(String user, String password) throws NonRollBackException, RollBackException {
		LoginIO loginIO = new LoginIOBean();
		IProcessResult<UserBean> serviceResult = authenService.login(user, password);
		UserBean userBean =  serviceResult.getResult();
		serviceResult = userAuthorizeService.addRolesUser(userBean);
		userBean = serviceResult.getResult();
		IProcessResult<MenuVO> serviceResultMenu = userMenuService.generateMenuList(serviceResult.getResult());
		loginIO.setUserBean(userBean);
		loginIO.setMenuVO(serviceResultMenu.getResult());
		Map<String, Object> session = new HashMap<String, Object>();
		loginIO.setSession(session);
		return new ProcessResult<LoginIO>(loginIO);
	}

}
