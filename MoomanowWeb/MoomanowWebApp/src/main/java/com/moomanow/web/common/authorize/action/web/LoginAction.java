package com.moomanow.web.common.authorize.action.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.moomanow.core.common.constant.CommonConstant;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.web.security.authen.bean.LoginIO;
import com.moomanow.web.security.authen.service.LoginService;
import com.moomanow.web.struts2.action.BaseAction;

@Component
@Scope("prototype")
public class LoginAction extends BaseAction  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2443463882312905612L;



	@Autowired
	private LoginService loginService;
	
	
	
	private String username;
	private String password;
	@Override
	public String init() throws Exception {

		return "loginPage";
	}
	
	public String login() throws Exception{
		IProcessResult<LoginIO> serviceResult = loginService.performLoginAndPutDataSession(username,password);
		
		if(serviceResult.isSuccess()){	
			LoginIO loginIO = serviceResult.getResult();
			if("null".equals(loginIO.getGotoPage())){
				return null;
			}
			session.put(CommonConstant.SESSION.USER_BEAN_KEY, serviceResult.getResult().getUserBean());
			session.put(CommonConstant.SESSION.MENU_BEAN_KEY, serviceResult.getResult().getMenuVO().getMenuBeans());
			session.put(CommonConstant.SESSION.MENU_BEAN_MAP_KEY, serviceResult.getResult().getMenuVO().getLookupMap());
			
			session.putAll(serviceResult.getResult().getSession());
			if(session.get(CommonConstant.SESSION.NEXT_URL_KEY)!=null){
				nextUrl = (String) session.get(CommonConstant.SESSION.NEXT_URL_KEY);
				session.remove(CommonConstant.SESSION.NEXT_URL_KEY);
				return CommonConstant.FORCE_TO_NEXT_URL;
			}else{
				return CommonConstant.FORCE_TO_LOGGEDIN_WELCOME_PAGE;
			}
		}else{
			messageList = serviceResult.getMessages();
			return "loginPage";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
