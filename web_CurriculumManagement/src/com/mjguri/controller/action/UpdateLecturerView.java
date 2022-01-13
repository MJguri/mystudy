package com.mjguri.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjguri.dao.CurriManageDAO;
import com.mjguri.dao.LecturerDAO;
import com.mjguri.vo.LecturerVO;

public class UpdateLecturerView implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/lecturerView.jsp";
		
		int idx = Integer.parseInt(request.getParameter("id"));
		
		LecturerDAO ldao = LecturerDAO.getInstance();
		CurriManageDAO cdao = CurriManageDAO.getInstance();
		
		LecturerVO lVo = new LecturerVO();
		List<String> cList = new ArrayList<>();
		
		lVo = ldao.selectLecturerByIdx(idx);
		cList = cdao.selectCurriNameById(idx);
		
		request.setAttribute("lVo", lVo);
		request.setAttribute("cList", cList);
		
		System.out.println(cList);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
