package com.mjguri.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.dao.CurriManageDAO;
import com.mjguri.vo.LecturerVO;

public class InsertCurriculumFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/insertcurriculum.jsp";
		
		CurriManageDAO dao = CurriManageDAO.getInstance();
		List<LecturerVO> lecturerList = dao.selectLecturerList();
		
		request.setAttribute("lecList", lecturerList);
		
	    request.getRequestDispatcher(url).forward(request, response);
		
	}

}
