<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/qna.css">
<title>QnA 상세보기</title>
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
		QnA게시판
		<table>
			<tr>
				<td>
					제목 :${qVo.qnaBoardTitle}
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
					${qVo.qnaBoardContent}
				</td>
			</tr>
			<tr>
				<td>
					<c:if test="${qVo.memberName == authInfo.memberName}">
						<input type="button" id="updateQna" name="updateQna" value="질문수정" onclick="location.href='<c:url value="/qna/updateQna/${qnaBoardNum}"/>'">
						<input type="button" id="delQna" name="delQna" value="질문삭제" onclick="location.href='<c:url value="/qna/delQna/${qnaBoardNum}"/>'">
					</c:if>
					<input type="button" id="goList" name="goList" value="목록으로" onclick="location.href='<c:url value="/"/>'">
				</td>
			</tr>
		</table>
		 
		
		<c:if test="${qVo.commentContent != null}">
			<table>
				<tr>
					<td>작성일 : <fmt:formatDate value="${qVo.commentRegdate}" pattern="yyyy-MM-dd"/> </td>
				</tr>
				<tr>
					<td>답변  : ${qVo.commentContent} </td>
				</tr>
			</table>
		</c:if>
    </section>
    <footer>
       Copyright (c) 2022 Mj_guri All right Reserved
    </footer>
</body>
</html>