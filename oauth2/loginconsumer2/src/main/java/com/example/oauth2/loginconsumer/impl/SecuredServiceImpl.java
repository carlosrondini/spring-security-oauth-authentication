package com.example.oauth2.loginconsumer.impl;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.client.RestOperations;

import com.example.oauth2.loginconsumer.SecuredService;
import com.example.oauth2.loginconsumer.SparklrException;

public class SecuredServiceImpl implements SecuredService {

	private RestOperations restTemplate;

	private String userInfoUrl;

	public void setUserInfoUrl(String userInfoUrl) {
		this.userInfoUrl = userInfoUrl;
	}

	public void setRestTemplate(OAuth2RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getUserInfo() throws SparklrException {
		return restTemplate.getForObject(userInfoUrl, String.class);
	}

}
