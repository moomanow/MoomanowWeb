package com.moomanow.web.security.openid.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.mitre.oauth2.model.RegisteredClient;
import org.springframework.jdbc.core.RowMapper;

import com.moomanow.core.common.dao.JdbcCommonDaoImpl;
import com.moomanow.core.common.exception.NonRollBackException;
import com.moomanow.core.common.exception.RollBackException;
import com.moomanow.web.security.openid.bean.ClientDetail;



public class OpenIdDaoImpl extends JdbcCommonDaoImpl implements OpenIdDao {
	private final String sql = "SELECT * FROM SYS_T_CLIENT_DETAIL "
			+" where STATUS = 'A' "
			+" and ISSUER = :ISSUER ";
	@Override
	public RegisteredClient findByIssuer(String issuer) throws RollBackException, NonRollBackException {
		Map<String,Object> params = new HashMap<>();
		params.put("ISSUER", issuer);
		return nativeQueryOneRow(sql, REGISTERED_CLIENT_MAPPER, params );
	}
	
	private static final RowMapper<RegisteredClient> REGISTERED_CLIENT_MAPPER  = new RowMapper<RegisteredClient>() {
		public RegisteredClient mapRow(ResultSet rs, int num) throws SQLException {
			RegisteredClient registeredClient = new RegisteredClient();
			registeredClient.setClientId(rs.getString("CLIENT_ID"));
			registeredClient.setClientSecret(rs.getString("CLIENT_SECRET"));
			String redirectUrisStr = rs.getString("REDIRECT_URIS");
			if(redirectUrisStr!=null&&!"".equals(redirectUrisStr)){
				Set<String> redirectUris = new HashSet<>(Arrays.asList(redirectUrisStr.split(" ")));
				registeredClient.setRedirectUris(redirectUris );
			}
			String scopeStr = rs.getString("SCOPE");
			if(scopeStr!=null&&!"".equals(scopeStr)){
				Set<String> scope = new HashSet<>(Arrays.asList(scopeStr.split(" ")));
				registeredClient.setScope(scope );
			}
			
			return registeredClient;
		}
		
	};

	@Override
	public void saveRegisteredClient(String issuer, RegisteredClient client) throws RollBackException, NonRollBackException {
		ClientDetail clientDetail = new ClientDetail();
		
		clientDetail.setClientId(client.getClientId());
		clientDetail.setClientSecret(client.getClientSecret());
		clientDetail.setIssuer(issuer);
		
		Set<String> redirectUriSet = client.getRedirectUris();
		if(redirectUriSet!=null&&!redirectUriSet.isEmpty()){
			StringBuilder sb= new StringBuilder();
			for (String scope : redirectUriSet) {
					sb.append(" ");
					sb.append(scope);
			}
			clientDetail.setRedirectUris(sb.substring(1));
		}

		Set<String> scopeSet = client.getScope();
		if(scopeSet!=null&&!scopeSet.isEmpty()){
			StringBuilder sb= new StringBuilder();
			for (String scope : scopeSet) {
					sb.append(" ");
					sb.append(scope);
			}
			clientDetail.setScope(sb.substring(1));
		}
		save(clientDetail);
	}

}
