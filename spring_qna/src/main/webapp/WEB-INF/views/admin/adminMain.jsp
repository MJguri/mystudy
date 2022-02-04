<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/index.css">
<title>관리자페이지</title>
</head>
<body>
	<header>
        Mj_guri 
        ${memberName }님
       	<input type="button" id="logoutBtn" name="logoutBtn" value="로그아웃" onclick="location.href='logout'">
        
    </header>
	<section>
		관리자페이지입니다.
		<input type="button" value="회원관리" onclick="location.href='<c:url value="/admin/memberManage"/>'">
		<input type="button" value="게시물관리" onclick="location.href='<c:url value="/admin/qnaManage"/>'">
	</section>



    <footer>
       Copyright (c) 2022 Mj_guri All right Reserved
    </footer>
</body>
</html>