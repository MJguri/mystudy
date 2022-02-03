package mj.guri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mj.guri.exception.AlreadyExistingMemberException;
import mj.guri.service.MemberRegiService;
import mj.guri.vo.MemberRegiVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberRegiService memberRegiService;

	@RequestMapping(value="/memberRegi", method=RequestMethod.GET)
	public String memberRegiForm(MemberRegiVO memberRegiVO) {
		return "member/memberRegiForm";
	}
	
	@RequestMapping(value="/memberRegi", method=RequestMethod.POST)
	public String memberRegi(MemberRegiVO memberRegiVO, Errors errors) {
		
		if(!memberRegiVO.isPasswordEqualToConfirmPassword()) {
			errors.reject("passwordMisMatch");
			return "member/memberRegiForm";
		}
		
		try {
			   memberRegiService.regist(memberRegiVO);
			}
		catch(AlreadyExistingMemberException e) {
			errors.reject("duplicate");
		   return "member/memberRegiForm";
		}
		
		return "redirect:/";
	}
	
}
