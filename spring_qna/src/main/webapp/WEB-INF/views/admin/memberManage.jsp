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
<title>회원관리 페이지</title>
</head>
<body>
	<header>
        Mj_guri 
        ${memberName }님
       	<input type="button" id="logoutBtn" name="logoutBtn" value="로그아웃" onclick="location.href='logout'">
        
    </header>
	<section>
		회원관리 페이지 입니다.
		<table border="1">
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="m" items="${list}">
				<tr>
					<td>${m.memberNum}</td>
					<td> <a href='<c:url value="/admin/memberdetail/${m.memberNum}"/>'>${m.memberId}</a></td>
					<td>${m.memberName}</td>
					<td><input type="button" value="수정"></td>
					<td><input type="button" value="삭제"></td>
				</tr>
			</c:forEach>
		</table>
		
	</section>



    <footer>
       Copyright (c) 2022 Mj_guri All right Reserved
    </footer>
</body>
</html>