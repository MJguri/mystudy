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
<title>회원관리 상세페이지</title>
</head>
<body>
	<header>
        Mj_guri 
        ${authInfo.memberName }님
       	<input type="button" id="logoutBtn" name="logoutBtn" value="로그아웃" onclick="location.href='<c:url value="/logout"/>'">
        
    </header>
	<section>
		회원관리 상세 페이지 입니다.

		<table border="1">
			<tr>
				<th colspan="2">회원번호 : ${mVo.memberNum}</th>
			</tr>
			<tr>
				<th>회원아이디</th>
				<td>${mVo.memberId} </td>
			</tr>
			<tr>
				<th>회원이름</th>
				<td>${mVo.memberName}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${mVo.memberEmail}</td>
			</tr>
			<tr>
				<th>전화</th>
				<td>${mVo.memberPhone}</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="location.href='<c:url value="/admin/memberupdate/${mVo.memberNum}"/>'">
					<input type="button" value="목록보기" onclick="location.href='<c:url value="/admin/memberManage"/>'">
				</td>
			</tr>
		</table>
		
	</section>

    <footer>
       Copyright (c) 2022 Mj_guri All right Reserved
    </footer>
</body>
</html>