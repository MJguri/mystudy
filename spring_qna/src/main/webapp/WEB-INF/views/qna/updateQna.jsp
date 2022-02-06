<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/qna.css">
<title>QnA 수정하기 </title>
</head>
<body>
	<header>
        Mj_guri 
        <c:if test="${authInfo.memberName == null }">
        	<input type="button" id="loginBtn" name="loginBtn" value="로그인" onclick="location.href='<c:url value="/login"/>'">
        	<input type="button" id="joinBtn" name="joinBtn" value="회원가입" onclick="location.href='<c:url value="/memberRegi"/>'">
        </c:if>
        
        <c:if test="${authInfo.memberName != null}">
        	${authInfo.memberName }님
        	<input type="button" id="memberInfoBtn" name="memberInfoBtn" value="정보보기" onclick="location.href='<c:url value="/memberInfo"/>'">
        	<input type="button" id="logoutBtn" name="logoutBtn" value="로그아웃" onclick="location.href='<c:url value="/logout"/>'">
        </c:if>
    </header>
    <section>
		QnA게시판 수정하기
		
		<form:form commandName="qnaRegiVO">
		<table>
			<tr>
				<td>
					제목 :<form:input path="qnaBoardTitle"/>
				</td>
			</tr>
			<tr>
				<td>
					작성일 :<fmt:formatDate value="${qVo.qnaBoardRegdate}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td>
					작성자 :${qVo.memberName}
				</td>
			</tr>
			<tr>
				<td>
					조회수 :${qVo.qnaBoardCount}
				</td>
			</tr>
			<tr>
				<td>
					<form:textarea path="qnaBoardContent"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="수정">
					<input type="button" id="goList" name="goList" value="목록으로" onclick="location.href='<c:url value="/"/>'">
				</td>
			</tr>
		</table>
		</form:form>
    </section>
    <footer>
       Copyright (c) 2022 Mj_guri All right Reserved
    </footer>
</body>
</html>