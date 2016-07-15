package com.moomanow.web.common.authorize.action.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.moomanow.core.common.constant.CommonConstant;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.core.common.service.ConfigService;
import com.moomanow.web.security.authen.bean.LoginIO;
import com.moomanow.web.security.authen.service.LoginService;
import com.moomanow.web.struts2.action.BaseAction;
import com.moomanow.web.struts2.bean.IMessage;

@Component
@Scope("prototype")
public class SingleSignOnAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3350315605290898019L;
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private ConfigService configService;
	
	private String identifier;

	@Override
	public String init() throws Exception {
		IProcessResult<LoginIO> serviceResult = loginService.attemptAuthenticationAndPutDataSession(httpServletRequest, httpServletResponse);
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
			messageList = (List<? extends IMessage>) serviceResult.getMessages();
			return "loginPage";
		}
	}
	
	@Override
	public String start() throws Exception {
		if(identifier ==null){
			identifier=configService.get("OAUTH2_IDENTIFIER");
		}
		return super.start();
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

}
