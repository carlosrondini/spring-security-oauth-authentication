package com.example.oauth1.loginconsumer.impl;

import org.springframework.security.oauth.consumer.client.OAuthRestTemplate;

import com.example.oauth1.loginconsumer.OauthService;

public class OauthServiceImpl implements OauthService {

	private String userinfoURL;
	private OAuthRestTemplate oauthRestTemplate;

	public String getSparklUserInfo() {
		return oauthRestTemplate.getForObject(userinfoURL, String.class);
	}

	public void setOauthRestTemplate(OAuthRestTemplate oauthRestTemplate) {
		this.oauthRestTemplate = oauthRestTemplate;
	}

	public void setUserinfoURL(String userinfoURL) {
		this.userinfoURL = userinfoURL;
	}
}
