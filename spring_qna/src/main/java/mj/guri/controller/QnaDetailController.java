package mj.guri.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mj.guri.dao.QnaDetailDAO;
import mj.guri.vo.AuthInfo;
import mj.guri.vo.QnaDetailVO;

@Controller
public class QnaDetailController {
	
	@Autowired
	private QnaDetailDAO dao;
	
	@RequestMapping("/qna/detail/{qnaBoardNum}")
	public String qnaDetail(@PathVariable("qnaBoardNum") Long qnaBoardNum,  HttpSession session, Model model) {
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo != null) {
			model.addAttribute("memberName", authInfo.getMemberName());
		}
		
		QnaDetailVO qVo = dao.selectQnaDetail(qnaBoardNum);
		
				
		model.addAttribute("qVo", qVo);
		model.addAttribute("qnaBoardNum", qnaBoardNum);
		
		return "qna/qnaDetail";
	}

}
