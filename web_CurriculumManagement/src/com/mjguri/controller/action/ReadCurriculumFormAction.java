package com.mjguri.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.dao.CurriManageDAO;
import com.mjguri.vo.CourseVO;



public class ReadCurriculumFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "board/curriculumView.jsp";
		
		String id = request.getParameter("id");
		System.out.println("받아온 id : "+ id);
		
		CurriManageDAO dao = CurriManageDAO.getInstance();
		
		CourseVO cVo = dao.selectBoardById(id);
		
		request.setAttribute("cVo", cVo);

		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
