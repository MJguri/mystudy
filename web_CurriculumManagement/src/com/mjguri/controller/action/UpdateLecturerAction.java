package com.mjguri.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.dao.LecturerDAO;
import com.mjguri.vo.LecturerVO;

public class UpdateLecturerAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String major = request.getParameter("major");
		String field = request.getParameter("field");
		
		LecturerVO lVo = new LecturerVO();
		lVo.setIdx(idx);
		lVo.setName(name);
		lVo.setMajor(major);
		lVo.setField(field);
		
		LecturerDAO dao = LecturerDAO.getInstance();
		dao.updateLecturer(lVo);
		
		response.sendRedirect("CMS?command=lecturerView");
		
	}
	

}
