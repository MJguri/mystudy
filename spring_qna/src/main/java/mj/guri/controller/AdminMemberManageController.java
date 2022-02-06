package mj.guri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mj.guri.dao.MemberDAO;
import mj.guri.vo.MemberVO;

@Controller
public class AdminMemberManageController {
	
	@Autowired
	MemberDAO dao;

	@RequestMapping("/admin/memberManage")
	public String memberManageList(Model model) {
		
		List<MemberVO> list = dao.selectAll();
		model.addAttribute("list", list);
		
		return "admin/memberManage";
	}
	
	@RequestMapping("/admin/memberdetail/{memberNum}")
	public String memberManageDetail(@PathVariable("memberNum") Long memberNum, Model model) {
		
		MemberVO mVo = dao.selectByNum(memberNum);
				
		model.addAttribute("mVo", mVo);
		
		return "admin/memberManageDetail";
	}
	
	@RequestMapping(value="/admin/memberupdate/{memberNum}", method=RequestMethod.GET)
	public String memberUpdateForm(MemberVO mVo, @PathVariable("memberNum") Long memberNum, Model model) {
		
		MemberVO _mVo = dao.selectByNum(memberNum);
		
		model.addAttribute("mVo", _mVo);
		
		return "admin/memberUpdate";
	}
	
	@RequestMapping(value="/admin/memberupdate/{memberNum}", method=RequestMethod.POST)
	public String memberUpdate(MemberVO mVo, @PathVariable("memberNum") Long memberNum, Model model) {
		dao.updateMember(mVo);
		
		return "redirect:/admin/memberManage";
	}
	
	@RequestMapping("/admin/memberdelete/{memberNum}")
	public String memberDel(@PathVariable("memberNum") Long memberNum) {
		dao.deleteMember(memberNum);
		
		return "redirect:/admin/memberManage";
	}
	
}
