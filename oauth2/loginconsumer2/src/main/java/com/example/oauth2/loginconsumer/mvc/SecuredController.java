package com.example.oauth2.loginconsumer.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.oauth2.loginconsumer.SecuredService;

@Controller
public class SecuredController {

	private SecuredService securedService;

	@RequestMapping("/secured/")
	public String photos(Model model) throws Exception {
		model.addAttribute("userinfo", securedService.getUserInfo());
		return "secured";
	}

	public void setSparklrService(SecuredService sparklrService) {
		this.securedService = sparklrService;
	}

}
