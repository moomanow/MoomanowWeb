package com.moomanow.web.common.web.struts.interceptor;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.moomanow.core.common.constant.CommonConstant;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.web.security.authen.bean.MenuVO;
import com.moomanow.web.security.authorize.service.UserMenuService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MenuInterceptor extends AbstractInterceptor {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1340998841043618009L;
	private UserMenuService userMenuService;
	@Autowired
	@Required
	public void setUserMenuService(UserMenuService userMenuService) {
		this.userMenuService = userMenuService;
	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		try{
			if(session.get(CommonConstant.SESSION.MENU_BEAN_KEY) == null){
				IProcessResult<MenuVO> serviceResultMenu = userMenuService.generateMenuGuest();
				if(serviceResultMenu.isSuccess()){
					session.put(CommonConstant.SESSION.MENU_BEAN_KEY, serviceResultMenu.getResult().getMenuBeans());
					session.put(CommonConstant.SESSION.MENU_BEAN_MAP_KEY, serviceResultMenu.getResult().getLookupMap());
				}
			}
			
		}catch(Exception e){
			
		}
		
		return invocation.invoke();
	}
}
