package org.springframework.security.oauth.examples.sparklr.mvc;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserinfoController {

	@RequestMapping("userinfo")
	@ResponseBody
	public String userInfo() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Assert.notNull(authentication);
		return authentication.getName();
	}
}
