package com.mjguri.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.dao.CurriManageDAO;
import com.mjguri.vo.CurriculumListVO;

public class CurriculumListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/curriculumList.jsp";
		
		CurriManageDAO dao = CurriManageDAO.getInstance();
		List<CurriculumListVO> currilist = dao.selectCurriculumList();
		int totalCnt = dao.selectTotalCntCurriculumList();
		
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("curriList", currilist);
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
