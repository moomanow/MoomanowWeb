package com.moomanow.web.common.user.action.web;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.web.common.bean.User;
import com.moomanow.web.struts2.action.SuperBaseRestAction;
import com.moomanow.web.struts2.bean.Button;
import com.moomanow.web.user.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

@Component
@Scope("prototype")
public class UserAction extends SuperBaseRestAction implements ModelDriven<Object> {

	@Autowired
	private UserService userService; 
	private User model = new User();
	private Object out;
	private String id;
	private IProcessResult<Collection<User>> list;
	
	
//	index -> editNew -> create
//	index -> edit -> update
//	index -> edit -> update

//			+-------------+----------------------+--------------+----------------+
//			| HTTP method |          URI         | Class.method | parameters     |
//			+-------------+----------------------+--------------+----------------+
//			| GET         | /user                | user.index   |                |
//			+-------------+----------------------+--------------+----------------+
//			| POST        | /user                | user.create  |                |
//			+-------------+----------------------+--------------+----------------+
//			| PUT         | /user/Thrillers      | user.update  | id="Thrillers" |
//			+-------------+----------------------+--------------+----------------+
//			| DELETE      | /user/Thrillers      | user.destroy | id="Thrillers" |
//			+-------------+----------------------+--------------+----------------+
//			| GET         | /user/Thrillers      | user.show    | id="Thrillers" |
//			+-------------+----------------------+--------------+----------------+
//			| GET         | /user/Thrillers/edit | user.edit    | id="Thrillers" |
//			+-------------+----------------------+--------------+----------------+
//			| GET         | /user/new            | user.editNew |                |
//			+-------------+----------------------+--------------+----------------+
	public HttpHeaders index()throws Exception {
		IProcessResult<Collection<User>> processResult = userService.findAll();
		if(processResult.isSuccess()){
			out = processResult;
			return new DefaultHttpHeaders("index").disableCaching();
		}else{
			messageList = processResult.getMessages();
			buttonList = new ArrayList<>();
			Button button = new Button();
			button.setAction("home-init");
			button.setNamespace("/home");
			button.setName("Home");
			buttonList.add(button);
			return new DefaultHttpHeaders("message").disableCaching();
		}
		
	}
	public HttpHeaders editNew()throws Exception {
		out = new User();
		return new DefaultHttpHeaders("edit").disableCaching();
	}
	public HttpHeaders edit()throws Exception {
		out = userService.find(id);
		return new DefaultHttpHeaders("edit").disableCaching();
	}
	public HttpHeaders create() throws Exception {
		userService.save(model);
		return new DefaultHttpHeaders("create");
	}

	public HttpHeaders destroy()throws Exception {
		return new DefaultHttpHeaders("destroy");
	}

	public HttpHeaders show()throws Exception {
		if (id != null) {
			this.out = userService.find(id);
		}
		return new DefaultHttpHeaders("show").disableCaching();
	}

	public HttpHeaders update()throws Exception {
		userService.save(model);
		return new DefaultHttpHeaders("update");
	}



	@Override
	public Object getModel() {
		return out;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
