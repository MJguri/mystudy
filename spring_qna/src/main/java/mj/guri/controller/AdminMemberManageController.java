package mj.guri.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mj.guri.dao.MemberDAO;
import mj.guri.vo.AuthInfo;
import mj.guri.vo.MemberVO;

@Controller
public class AdminMemberManageController {
	
	@Autowired
	MemberDAO dao;

	@RequestMapping()
	public String memberManageList(HttpSession session, Model model) {
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo != null) {
			model.addAttribute("memberName", authInfo.getMemberName());
		}
		
		List<MemberVO> list = dao.selectAll();
		model.addAttribute("list", list);
		
		return "admin/memberManage";
	}
}
