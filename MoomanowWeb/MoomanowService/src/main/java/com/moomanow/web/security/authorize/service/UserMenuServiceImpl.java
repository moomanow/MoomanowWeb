package com.moomanow.web.security.authorize.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.moomanow.core.common.bean.ActionBean;
import com.moomanow.core.common.bean.UserBean;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.core.common.processhandler.IProcessResult;
import com.moomanow.core.common.service.ConfigService;
import com.moomanow.web.common.process.bean.ProcessResult;
import com.moomanow.web.security.authen.bean.MenuVO;
import com.moomanow.web.security.authorize.bean.Menu;
import com.moomanow.web.security.authorize.bean.MenuBean;
import com.moomanow.web.security.authorize.dao.ActionDao;
import com.moomanow.web.security.authorize.dao.MenuDao;
import com.moomanow.web.security.authorize.dao.UserAuthorizeDao;

public class UserMenuServiceImpl implements UserMenuService {
	@Autowired
	private MenuDao userMenuDao;
	@Autowired
	private ActionDao actionDao;
	@Autowired
	private UserAuthorizeDao userAuthorizeDao;
	@Autowired
	private ConfigService configService;
	@Override
	public IProcessResult<MenuVO> generateMenuList(UserBean userBean) throws NonRollBackException, RollBackException {
		return generateMenuList(userBean.getPrivileges());
	}
	@Override
	public IProcessResult<MenuVO> generateMenuList(Set<String> privileges) throws NonRollBackException, RollBackException {
		List<Menu> menuList = userMenuDao.findAll();
		
		List<MenuBean> result = new LinkedList<MenuBean>();//output main list
		HashMap<Long, MenuBean> lookup = new HashMap<Long, MenuBean>();//lookup bean parent { for bean chide find bean parent }
		if(menuList!=null&&menuList.size()!=0){
//			Set<String> privileges = userBean.getPrivileges();
			if(privileges!=null){
//				
				for (Menu menu : menuList) {
					if(privileges.contains(menu.getObjId())){
						MenuBean menuBean = new MenuBean();
						
						ActionBean actionBean = actionDao.getActionByActionId(menu.getActionId());
						if(actionBean!=null){
							if("U".equalsIgnoreCase(actionBean.getType()) ){
								menuBean.setUrl(actionBean.getUrl());
							}else{
								menuBean.setUrl(actionBean.getNameSpace()+"/"+actionBean.getActionName()+".htm");
							}
						}
						menuBean.setMenuName(menu.getMenuName());
						menuBean.setLevel(menu.getLevel());
						menuBean.setParentId(menu.getParentId());
						menuBean.setMenuId(menu.getMenuId());
						menuBean.setType(menu.getMenuType());
//						menuBean.setUrl(menu.getUrl());
//						Add menu item to parent
						if(menu.getParentId()==null){//
//							case root or main list
							result.add(menuBean);
						}else{
//							case sub menu create sublist
							MenuBean parent = lookup.get(menu.getParentId());
							if (parent!=null) {
								parent.addChildMenu(menuBean);
							} else {
//								ignore case invalid parent m
							}
						}
						lookup.put(menu.getMenuId(), menuBean);// set parent lookup
					}
				}
			}
		}
		MenuVO menuVO = new MenuVO();
		menuVO.setMenuBeans(result);
		menuVO.setLookupMap(lookup);
		return new ProcessResult<MenuVO>(menuVO);
	}
	@Override
	public IProcessResult<MenuVO> generateMenuGuest() throws NonRollBackException, RollBackException {
		String idGuest = "7";
		try{
			idGuest = configService.get("GUEST_ID");
		}catch(Exception e){
			
		}
		Set<String> privileges = userAuthorizeDao.getUserPrivilegesByRoleId(idGuest);
		return generateMenuList(privileges);
	}

}
