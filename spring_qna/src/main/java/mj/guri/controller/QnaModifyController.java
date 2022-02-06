package mj.guri.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mj.guri.dao.QnaDAO;
import mj.guri.dao.QnaDetailDAO;
import mj.guri.vo.QnaDetailVO;
import mj.guri.vo.QnaRegiVO;

@Controller
public class QnaModifyController {
	
	@Autowired
	private QnaDAO dao;
	
	@Autowired
	private QnaDetailDAO detailDao;
	
	@RequestMapping(value="/qna/updateQna/{qnaBoardNum}", method=RequestMethod.GET)
	public String updateQnaForm(QnaRegiVO qnaRegiVO, @PathVariable("qnaBoardNum") Long qnaBoardNum, Model model) {
		
		QnaDetailVO qVo = detailDao.selectQnaDetail(qnaBoardNum);
		
		model.addAttribute("qVo", qVo);
		model.addAttribute("qnaBoardNum", qnaBoardNum);
		
		return "qna/updateQna";
	}
	
	@RequestMapping(value="/qna/updateQna/{qnaBoardNum}", method=RequestMethod.POST)
	public String updateQna(QnaRegiVO qnaRegiVO, @PathVariable("qnaBoardNum") Long qnaBoardNum) {
		
		dao.updateQna(qnaBoardNum, qnaRegiVO);
		return "redirect:/";
	}
	
	@RequestMapping("/qna/delQna/{qnaBoardNum}")
	public String delQna(@PathVariable("qnaBoardNum") Long qnaBoardNum) {
		
		dao.delQna(qnaBoardNum);
		return "redirect:/";
	}

}
