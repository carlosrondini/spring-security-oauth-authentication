package org.springframework.security.oauth.examples.tonr.impl;

import org.springframework.security.oauth.consumer.client.OAuthRestTemplate;
import org.springframework.security.oauth.examples.tonr.OauthService;

public class OauthServiceImpl implements OauthService {

	private String sparklrUserinfoURL;
	private OAuthRestTemplate sparklrRestTemplate;

	public String getSparklUserInfo() {
		return sparklrRestTemplate.getForObject(sparklrUserinfoURL, String.class);
	}

	public void setSparklrRestTemplate(OAuthRestTemplate sparklrRestTemplate) {
		this.sparklrRestTemplate = sparklrRestTemplate;
	}

	public void setSparklrUserinfoURL(String sparklrUserinfoURL) {
		this.sparklrUserinfoURL = sparklrUserinfoURL;
	}
}
