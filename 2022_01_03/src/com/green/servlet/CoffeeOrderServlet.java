package com.green.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web08.Coffee;
import web08.Order;

@WebServlet("/COS")
public class CoffeeOrderServlet extends HttpServlet {
	
	List<Order> oList = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> cList = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    	String uId = "scott";
    	String uPw = "tiger";
    	
    	String sql = "SELECT * FROM COFFEE"; // 쿼리를 작성하는 문자열에  ' ; ' 사용하면 안됨 (자동으로 붙여짐 )
    	
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	try{
    		Class.forName("oracle.jdbc.driver.OracleDriver"); // 인스턴스 만드는 방법 : oracle.jdbc.driver패키지에   OracleDriver 클래스 인스턴스를 만드는 거임
    		conn = DriverManager.getConnection(url,uId,uPw);
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(sql); // 데이터베이스에서 데이터를 읽어오기위한 쿼리를 보내는 메서드 => SELECT
    		
    		while(rs.next()){
    			cList.add(rs.getString("name"));
    		}
    		
    		request.setAttribute("cList", cList);
    		request.getRequestDispatcher("coffe_form.jsp").forward(request, response);
    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		try{
    			if(rs!=null) rs.close();
    			if(stmt!=null) stmt.close();
    			if(conn!=null) conn.close();
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	
    	oList = new ArrayList<>();
    	
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> cList = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    	String uId = "scott";
    	String uPw = "tiger";
    	
    	String sql = "SELECT * FROM COFFEE"; // 쿼리를 작성하는 문자열에  ' ; ' 사용하면 안됨 (자동으로 붙여짐 )
    	
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	try{
    		Class.forName("oracle.jdbc.driver.OracleDriver"); // 인스턴스 만드는 방법 : oracle.jdbc.driver패키지에   OracleDriver 클래스 인스턴스를 만드는 거임
    		conn = DriverManager.getConnection(url,uId,uPw);
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(sql); // 데이터베이스에서 데이터를 읽어오기위한 쿼리를 보내는 메서드 => SELECT
    		
    		while(rs.next()){
    			cList.add(rs.getString("name"));
    		}
    		
    		request.setAttribute("cList", cList);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		try{
    			if(rs!=null) rs.close();
    			if(stmt!=null) stmt.close();
    			if(conn!=null) conn.close();
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	
    	//////////////////////////////////////////////////////
		
		request.setCharacterEncoding("UTF-8");

		String coffeeName = request.getParameter("coffeeName");
		String type = request.getParameter("type");
		int count = Integer.parseInt(request.getParameter("count"));
		int price = 0;
		
		sql = "SELECT "+type+" FROM COFFEE WHERE NAME = '"+coffeeName+"'";
    	
    	
    	try{
    		Class.forName("oracle.jdbc.driver.OracleDriver"); // 인스턴스 만드는 방법 : oracle.jdbc.driver패키지에   OracleDriver 클래스 인스턴스를 만드는 거임
    		conn = DriverManager.getConnection(url,uId,uPw);
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(sql); // 데이터베이스에서 데이터를 읽어오기위한 쿼리를 보내는 메서드 => SELECT
    		
    		if(rs.next()) {
    			price = rs.getInt(type);
    		}
    		
    		Order o = new Order();
    		
    		o.setCoffeeName(coffeeName);
    		o.setType(type);
    		o.setPrice(price);
    		o.setTotal(price*count);
    		o.setCount(count);
    		
    		oList.add(o);
    		
    		request.setAttribute("oList", oList);
    		request.getRequestDispatcher("coffe_form.jsp").forward(request, response);
    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		try{
    			if(rs!=null) rs.close();
    			if(stmt!=null) stmt.close();
    			if(conn!=null) conn.close();
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
	}
}
