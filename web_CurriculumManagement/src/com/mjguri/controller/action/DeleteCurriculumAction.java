package com.mjguri.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.dao.CurriManageDAO;

public class DeleteCurriculumAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		CurriManageDAO dao = CurriManageDAO.getInstance();
		dao.deleteCourseById(id);
		
		response.sendRedirect("CMS?command=curriculum_List");
		
	}

}
