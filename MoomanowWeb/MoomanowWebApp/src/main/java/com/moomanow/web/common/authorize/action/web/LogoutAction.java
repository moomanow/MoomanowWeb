package com.moomanow.web.common.authorize.action.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.moomanow.core.common.constant.CommonConstant;
import com.moomanow.core.common.service.ConfigService;
import com.moomanow.web.struts2.action.BaseAction;


@Component
@Scope("prototype")
public class LogoutAction extends BaseAction {

	@Autowired
	private ConfigService configService;
	private String url;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1313028725749490376L;

	@Override
	public String init() throws Exception {
		return logout();
	}
	
	public String logout() throws Exception{
		httpServletRequest.getSession().invalidate();
		url = configService.get("LOGOUT_URL");
		return "redirect";
//		return CommonConstant.FORCE_TO_LOGIN_PAGE;
	}

}
