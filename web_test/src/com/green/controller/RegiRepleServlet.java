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

@WebServlet("/RRS")
public class RegiRepleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		RepleDAO dao = RepleDAO.getInstance();
		List<RepleVO> list = dao.selectAllText();
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);

		PrintWriter out = response.getWriter();
		
		out.println(jsonList);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String wordData = request.getParameter("wordData");
		System.out.println("얻어온 값 : "+wordData);
		
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(wordData);
		
		String c_user = data.getAsJsonObject().get("user").getAsString();
		String c_password = data.getAsJsonObject().get("userPwd").getAsString();
		String c_comment = data.getAsJsonObject().get("comment").getAsString();
		
		RepleDAO dao = RepleDAO.getInstance();
		dao.insertReple(c_user,c_password,c_comment);
		
		List<RepleVO> list = dao.selectAllText();
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);

		PrintWriter out = response.getWriter();
		
		out.println(jsonList);
		
	}

}
