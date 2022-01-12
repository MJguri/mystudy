package com.mjguri.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.controller.action.Action;


@WebServlet("/CMS")
public class CurriculumManagementServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
	
		System.out.println("CMS에서 요청 받음 확인 : "+command);
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		
		if(action != null) {
			action.execute(request,response);
		}
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
