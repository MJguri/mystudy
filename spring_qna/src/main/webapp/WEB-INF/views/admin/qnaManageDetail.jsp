<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/qna.css">
<title>QnA 상세보기 관리페이지</title>
</head>
<body>
	<header>
        Mj_guri 
       	${authInfo.memberName }님
       	<input type="button" id="logoutBtn" name="logoutBtn" value="로그아웃" onclick="location.href='<c:url value="/logout"/>'">
    </header>
    <section>
		QnA 상세보기 관리페이지
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
					<input type="button" id="goList" name="goList" value="목록으로" onclick="location.href='<c:url value="/admin/qnaManage"/>'">
				</td>
			</tr>
		</table>
		 
		
		<c:choose>

			<c:when test="${qVo.commentContent == null}">
				<form class="formBox" action="<c:url value="/admin/regiComment"/>" method="POST">
					<textarea id="comments" name="comments"></textarea><br>
					<input type="hidden" id="qnaBoardNum" name="qnaBoardNum" value="${qnaBoardNum}">
					<input type="submit" value="답변등록">
				</form>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>작성일 : <fmt:formatDate value="${qVo.commentRegdate}" pattern="yyyy-MM-dd"/> </td>
					</tr>
					<tr>
						<td>답변  : ${qVo.commentContent} </td>
					</tr>
				</table>
			</c:otherwise>

		</c:choose>
    </section>
    <footer>
       Copyright (c) 2022 Mj_guri All right Reserved
    </footer>
</body>
</html>