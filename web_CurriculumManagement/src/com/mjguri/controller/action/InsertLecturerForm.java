package com.mjguri.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.dao.LecturerDAO;

public class InsertLecturerForm implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/insertLecturer.jsp";
		
		LecturerDAO dao = LecturerDAO.getInstance();
		int seqNum = dao.selectMaxIdx();
		
		System.out.println(seqNum);
		
		request.setAttribute("seqNum", seqNum);
		
	    request.getRequestDispatcher(url).forward(request, response);
		
	}

}
