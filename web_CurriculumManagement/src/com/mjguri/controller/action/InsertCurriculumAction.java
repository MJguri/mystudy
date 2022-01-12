package com.mjguri.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.dao.CurriManageDAO;
import com.mjguri.vo.CourseVO;

public class InsertCurriculumAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int credit = Integer.parseInt(request.getParameter("credit"));
		int lecturer = Integer.parseInt(request.getParameter("lecturer"));
		int week = Integer.parseInt(request.getParameter("week"));
		int start_hour = Integer.parseInt(request.getParameter("start_hour"));
		int end_hour = Integer.parseInt(request.getParameter("end_hour"));
		
		CourseVO cVo = new CourseVO();
		cVo.setId(id);
		cVo.setName(name);
		cVo.setCredit(credit);
		cVo.setLecturer(lecturer);
		cVo.setWeek(week);
		cVo.setStarthour(start_hour);
		cVo.setEndhour(end_hour);
		
		CurriManageDAO dao = CurriManageDAO.getInstance();
		dao.insertCurriculum(cVo);
		
		response.sendRedirect("CMS?command=curriculum_List");
		
	}

}
