package com.mjguri.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.dao.CurriManageDAO;
import com.mjguri.vo.CourseVO;
import com.mjguri.vo.LecturerVO;

public class UpdateCurriculumFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/updatecurriculum.jsp";
		
		String id = request.getParameter("id");
		
		CurriManageDAO dao = CurriManageDAO.getInstance();
		CourseVO cVo = dao.selectBoardById(id);
		List<LecturerVO> lecturerList = dao.selectLecturerList();
		
		request.setAttribute("lecList", lecturerList);
		request.setAttribute("cVo", cVo);
		
	    request.getRequestDispatcher(url).forward(request, response);
		
	}

}
