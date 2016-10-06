package com.moomanow.web.security.authen.service;

import org.springframework.stereotype.Service;

@Service("plaintextEncryptService")
public class PlaintextEncryptServiceImpl implements EncryptService {

	@Override
	public String encryptString(String string) {
		return string;
	}

}
