package mj.guri.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mj.guri.dao.QnaDAO;
import mj.guri.vo.AuthInfo;
import mj.guri.vo.QnaVO;

@Controller
public class QnaListController {
	
	@Autowired
	private QnaDAO dao;

	@RequestMapping("/")
	public String qnaListShow(HttpServletRequest request, HttpSession session, Model model) {
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo != null) {
			model.addAttribute("memberName", authInfo.getMemberName());
			model.addAttribute("memberNum", authInfo.getMemberNum());
		}
		
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		
		int section = Integer.parseInt((_section==null)?"1":_section);
		int pageNum = Integer.parseInt((_pageNum==null)?"1":_pageNum);
		
		int totalCnt = dao.selectAllNumBoard();
		List<QnaVO> list = dao.selectTargetBoard(section, pageNum);
		
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("section", section);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", list);
		
		return "index";
	}
}
