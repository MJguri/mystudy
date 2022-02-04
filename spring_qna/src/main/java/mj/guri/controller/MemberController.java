package mj.guri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mj.guri.dao.MemberDAO;
import mj.guri.exception.AlreadyExistingMemberException;
import mj.guri.service.MemberRegiService;
import mj.guri.vo.MemberRegiVO;
import mj.guri.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberRegiService memberRegiService;
	
	@Autowired
	MemberDAO dao;

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
	
	@RequestMapping("/member/info/{memberNum}")
	public String memberInfo(@PathVariable("memberNum") Long memberNum, Model model) {
		
		MemberVO mVo = dao.selectByNum(memberNum);
		
		model.addAttribute("mVo", mVo);
		
		return "member/memberinfo";
	}
	
}
