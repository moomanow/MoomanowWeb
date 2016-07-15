package com.moomanow.web.common.authorize.action.web;
//package com.jobsmatcher.jm.common.login.action.web;
//
//import org.kanomchan.core.common.processhandler.ServiceResult;
//import org.kanomchan.core.common.web.struts.action.BaseAction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Required;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//import com.jobsmatcher.jm.common.bean.GenKey;
//import com.jobsmatcher.jm.common.bean.User;
//import com.jobsmatcher.jm.usermanament.service.GenKeyService;
//import com.jobsmatcher.jm.usermanament.service.UserService;
//
//@Component
//@Scope("prototype")
//public class ForgotAction extends BaseAction {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1648648581235582680L;
//	
////	private UserService userSerivce;
////	@Autowired
////	@Required
////	public void setUserService(UserService userSerivce) {
////		this.userSerivce = userSerivce;
////	}
////	
////	private GenKeyService genKeyService;
////	@Autowired
////	@Required
////	public void setGenKeyService(GenKeyService genKeyService) {
////		this.genKeyService = genKeyService;
////	}
//	
//	private String result;
//	private String code;
//	private String password;
//	
//	private GenKey genKey;
//
//	private static final String LOGIN_PAGE_RESULT = "loginPage";
//	
//	@Override
//	public String init() throws Exception {
//		return null;
//	}
//	
//	public String genkey()throws Exception{
//		String email = httpServletRequest.getParameter("email");
//		ServiceResult<GenKey> genKey = genKeyService.genKey(email);
//		if(genKey.isSuccess()){
//			result = "done";
//		}else{
//			result = "fail";
//		}
//		return "jsonResult";
//	}
//	
//	public String reset() throws Exception{
//		if(code == null)
//			code = httpServletRequest.getParameter("code");
//		ServiceResult<GenKey> serviceResult = genKeyService.findKey(code);
//		genKey = serviceResult.getResult();
//		messageList = serviceResult.getMessages();
//		if(serviceResult.isSuccess()){
//			return "resetpassword";
//		}else{
//			return "resetpassword";
//		}
//	}
//	
//	public String changePassword() throws Exception{
//		ServiceResult<User> serviceResult = userSerivce.changePassword(genKey, password);
//		if(serviceResult.isSuccess()){
//			messageList = serviceResult.getMessages();
//			return LOGIN_PAGE_RESULT;
//		}else{
//			messageList = serviceResult.getMessages();
//			return "resetpassword";
//		}
//	}
//	
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getResult() {
//		return result;
//	}
//
//	public void setResult(String result) {
//		this.result = result;
//	}
//	
//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	public GenKey getGenKey() {
//		return genKey;
//	}
//
//	public void setGenKey(GenKey genKey) {
//		this.genKey = genKey;
//	}
//
//}
