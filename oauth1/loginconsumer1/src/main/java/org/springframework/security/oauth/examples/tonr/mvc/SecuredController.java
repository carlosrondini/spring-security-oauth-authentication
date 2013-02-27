package org.springframework.security.oauth.examples.tonr.mvc;

import org.springframework.security.oauth.examples.tonr.OauthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecuredController {

	private OauthService oauthService;

	@RequestMapping("/secured")
	public String photos(Model model) throws Exception {
		model.addAttribute("userinfo", oauthService.getSparklUserInfo());
		return "secured";
	}

	public void setOauthService(OauthService oauthService) {
		this.oauthService = oauthService;
	}
}
