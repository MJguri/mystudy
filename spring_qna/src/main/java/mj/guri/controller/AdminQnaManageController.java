package mj.guri.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mj.guri.dao.QnaDAO;
import mj.guri.dao.QnaDetailDAO;
import mj.guri.vo.AdminQnaVO;
import mj.guri.vo.AuthInfo;
import mj.guri.vo.QnaDetailVO;

@Controller
public class AdminQnaManageController {
	
	@Autowired
	private QnaDAO dao;
	
	@Autowired
	private QnaDetailDAO qdao;

	@RequestMapping("/admin/qnaManage")
	public String qnaManage(HttpServletRequest request, HttpSession session, Model model) {
		
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
		List<AdminQnaVO> list = dao.selectAdminTargetBoard(section, pageNum);
		
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("section", section);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", list);
		
		return "admin/qnaManage";
	}
	
	@RequestMapping("/admin/detail/{qnaBoardNum}")
	public String qnaDetail(@PathVariable("qnaBoardNum") Long qnaBoardNum,  HttpSession session, Model model) {
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo != null) {
			model.addAttribute("memberName", authInfo.getMemberName());
		}
		
		QnaDetailVO qVo = qdao.selectQnaDetail(qnaBoardNum);
				
		model.addAttribute("qVo", qVo);
		model.addAttribute("qnaBoardNum", qnaBoardNum);
		
		return "admin/qnaManageDetail";
	}
	
	@RequestMapping("/admin/regiComment")
	public String regiComment(@RequestParam(value="qnaBoardNum")Long qnaBoardNum, @RequestParam(value="comments")String comments) {
		dao.insertComments(qnaBoardNum, comments);
		
		return "redirect:/admin/qnaManage";
	}
}
