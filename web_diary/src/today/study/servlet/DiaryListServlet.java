package today.study.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import today.study.dao.DiaryDAO;
import today.study.vo.DiaryVO;

/**
 * Servlet implementation class DiaryListServlet
 */
@WebServlet("/DLS")
public class DiaryListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiaryDAO dao = DiaryDAO.getInstance();
		
 		List<DiaryVO> dList = new ArrayList<>();
 		dList = dao.getDiary("박민영");
		
		request.setAttribute("dList", dList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("diary_main.jsp");
		dispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
