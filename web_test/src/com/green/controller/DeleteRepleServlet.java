package com.green.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.green.dao.RepleDAO;
import com.green.vo.RepleVO;

@WebServlet("/DRS")
public class DeleteRepleServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String wordData = request.getParameter("wordData");
		System.out.println("얻어온 값 : "+wordData);
		
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(wordData);
		
		int C_code = data.getAsJsonObject().get("c_code").getAsInt();
		String C_password = data.getAsJsonObject().get("delPwd").getAsString();
		
		RepleDAO dao = RepleDAO.getInstance();
		
		String dbPwd = dao.selectPwdByCode(C_code);
		System.out.println("받아온값 : " + dbPwd);
		PrintWriter out = response.getWriter();
		
		int pwdError = 0;
		
		if(dbPwd.equals(C_password)) {
			dao.deleteReple(C_code);
			
			List<RepleVO> list = dao.selectAllText();
			
			System.out.println(list);
			
			Gson gson = new Gson();
			String jsonList = gson.toJson(list);
			
			out.println(jsonList);
		}
		else {
			
			Gson gson = new Gson();
			String jsonList = gson.toJson(pwdError);
			
			out.println(jsonList);
		}
		
	}

}
