package mj.guri.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mj.guri.service.QnaRegiService;
import mj.guri.vo.AuthInfo;
import mj.guri.vo.QnaRegiVO;

@Controller
public class QnaRegiController {
	
	@Autowired
	private QnaRegiService qnaRegiSvc;

	@RequestMapping(value="/qnaRegi", method=RequestMethod.GET)
	public String qnaRegiForm(QnaRegiVO qnaRegiVO, HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo != null) {
			model.addAttribute("memberName", authInfo.getMemberName());
		}
		
		return "qna/qnaRegi";
	}
	
	@RequestMapping(value="/qnaRegi", method=RequestMethod.POST)
	public String qnaRegi(QnaRegiVO qnaRegiVO,  HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		qnaRegiSvc.regist(qnaRegiVO, authInfo.getMemberNum());
		
		return "redirect:/";
	}
	
}
