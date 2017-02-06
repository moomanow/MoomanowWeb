package com.moomanow.web.security.openid.service;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.mitre.oauth2.model.RegisteredClient;
import org.mitre.openid.connect.client.service.RegisteredClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.web.security.openid.dao.OpenIdDao;

public class RegisteredClientServiceImpl implements RegisteredClientService {

	private Map<String, RegisteredClient> clients = new ConcurrentHashMap<>();
	private OpenIdDao openIdDao;
	@Autowired
	@Required
	public void setOpenIdDao(OpenIdDao openIdDao) {
		this.openIdDao = openIdDao;
	}
	
	@Override
	public RegisteredClient getByIssuer(String issuer) {
		try {
			RegisteredClient registeredClient =null;
			if(!clients.containsKey(issuer)){
				registeredClient = openIdDao.findByIssuer(issuer);
				if(registeredClient!=null)
				clients.put(issuer, registeredClient);
			}else{
				registeredClient = clients.get(issuer);
			}
			return registeredClient;
		} catch (RollBackException | NonRollBackException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(String issuer, RegisteredClient client) {
		try {
			openIdDao.saveRegisteredClient(issuer,client);
		} catch (RollBackException | NonRollBackException e) {
			e.printStackTrace();
		}
	}

}
