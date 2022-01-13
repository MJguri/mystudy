package com.mjguri.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.dao.LecturerDAO;
import com.mjguri.vo.LecturerVO;

public class InsertLecturerAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LecturerVO lVo = new LecturerVO();
		
		lVo.setIdx(Integer.parseInt(request.getParameter("idx")));
		lVo.setMajor(request.getParameter("major"));
		lVo.setName(request.getParameter("name"));
		lVo.setField(request.getParameter("field"));
		
		LecturerDAO dao = LecturerDAO.getInstance();
		dao.insertLecturer(lVo);
		
		response.sendRedirect("CMS?command=lecturerView");
		
	}

}
