package com.mjguri.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.dao.LecturerDAO;
import com.mjguri.vo.LecturerVO;

public class LecturerListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/board/lecturerList.jsp";
		
		LecturerDAO dao = LecturerDAO.getInstance();
		List<LecturerVO> leclist = dao.selectLecturerList();
		int totalCnt = dao.selectTotalCntLecturerList();
		
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("lecList", leclist);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
