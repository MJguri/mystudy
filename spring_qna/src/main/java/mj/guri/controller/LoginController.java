package mj.guri.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mj.guri.exception.IdPasswordNotMatchingException;
import mj.guri.service.AuthService;
import mj.guri.vo.AuthInfo;
import mj.guri.vo.LoginVO;

@Controller
public class LoginController {
	
	@Autowired
	private AuthService authService;

//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public String loginForm(Model model) {
//		model.addAttribute("loginCommand",new LoginVO());
//		
//		return "login/loginForm";
//	}
	
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public String loginForm(@ModelAttribute LoginVO loginCommand) {
//		
//		return "login/loginForm";
//	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(LoginVO loginVO) {
		
		return "login/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String submit(LoginVO loginVO, Errors errors, HttpSession session) { // 폼에서 로그인 기능을 요청
		
		// 입력받은 이메일과 비밀번호로 로그인(서비스 객체) 시도 
		try {
			AuthInfo authInfo =  authService.authenticate(loginVO.getMemberId(), loginVO.getMemberPassword());
			//로그인 정보를 기록할 세션 코드
			session.setAttribute("authInfo", authInfo);
		}
		catch(IdPasswordNotMatchingException e) {
			//이메일이 없거나 비밀번호가 틀린 경우 
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
		
				
		return "redirect:/";
		
	}
	
}
