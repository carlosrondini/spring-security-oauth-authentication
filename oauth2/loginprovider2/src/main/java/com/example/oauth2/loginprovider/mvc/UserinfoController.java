package com.example.oauth2.loginprovider.mvc;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserinfoController {

	@ResponseBody
	@RequestMapping("/userinfo")
	public String userinfo(Principal principal) {
		Assert.notNull(principal);
		return principal.getName();
	}
}
