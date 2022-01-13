package com.mjguri.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.dao.CurriManageDAO;
import com.mjguri.dao.LecturerDAO;
import com.mjguri.vo.CourseVO;



public class ReadCurriculumFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "board/curriculumView.jsp";
		
		String id = request.getParameter("id");
		
		CurriManageDAO dao = CurriManageDAO.getInstance();
		LecturerDAO ldao = LecturerDAO.getInstance();
		
		CourseVO cVo = dao.selectBoardById(id);
		String lecName = ldao.selectLecturerNameByIdx(Integer.parseInt(id));
		
		System.out.println("lecName : " + lecName);
		
		request.setAttribute("lecName", lecName);
		request.setAttribute("cVo", cVo);

		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
