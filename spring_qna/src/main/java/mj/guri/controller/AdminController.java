package mj.guri.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mj.guri.vo.AuthInfo;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String adminPage(HttpSession session, Model model) {
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo != null) {
			model.addAttribute("memberName", authInfo.getMemberName());
		}
		
		return "admin/adminMain";
	}
}
