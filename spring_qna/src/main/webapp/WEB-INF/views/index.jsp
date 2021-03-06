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
<link rel="stylesheet" href="../../resources/CSS/index.css">
<title>QnA 게시판</title>
</head>
<body>
    <header>
        Mj_guri 
        <c:if test="${authInfo.memberName == null }">
        	<input type="button" id="loginBtn" name="loginBtn" value="로그인" onclick="location.href='login'">
        	<input type="button" id="joinBtn" name="joinBtn" value="회원가입" onclick="location.href='memberRegi'">
        </c:if>
        
        <c:if test="${authInfo.memberName != null}">
        	${authInfo.memberName }님
        	<input type="button" id="memberInfoBtn" name="memberInfoBtn" value="정보보기" onclick="location.href='<c:url value="/member/info/${authInfo.memberNum}"/>'">
        	<input type="button" id="logoutBtn" name="logoutBtn" value="로그아웃" onclick="location.href='logout'">
        </c:if>
    </header>

    <section>

	<c:if test="${totalCnt != null}">
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="q" items="${list}">
				<tr>
					<td>${q.qnaBoardNum}</td>
					<td><a href='<c:url value="/qna/detail/${q.qnaBoardNum}"/>'>${q.qnaBoardTitle}</a></td>
					<td>${q.memberName}</td>
					<td> <fmt:formatDate value="${q.qnaBoardRegdate}" pattern="yyyy-MM-dd"/>  </td>
					<td>${q.qnaBoardCount}</td>
				</tr>
			</c:forEach>
		</table>

		<div class="pagingbody">
		
			<c:choose>
				<c:when test="${totalCnt>100}">
					<c:if test="${(section)*100<totalCnt}"> <!--   >>(다음 섹션이 존재한다.)    -->
						<c:forEach var="page" begin="1" end="10" step="1" >
							<c:if test="${section >1 && page==1}"> <!--  이전 섹션 표시 << -->
								<a href="?section=${section-1}&pageNum=10"> << </a>
							</c:if>
								<a href="?section=${section}&pageNum=${page}">${(section-1)*10+page}</a>
							<c:if test="${page==10}"> <!--  다음 섹션 표시 >> -->
								<a href="?section=${section+1}&pageNum=1"> >> </a>
							</c:if>
						</c:forEach>
					</c:if>
					<c:if test="${(section)*100>totalCnt}"> <!--   (다음 섹션이 없다!!) -->
						<c:forEach  var="page" begin="1" end="${((totalCnt+9)-(section-1)*100)/10}" step="1" >
							<c:if test="${section >1 && page==1}"> <!--  이전 섹션 표시 << -->
								<a href="?section=${section-1}&pageNum=10"> << </a>
							</c:if>
								<a href="?section=${section}&pageNum=${page}">${(section-1)*10+page}</a>
						</c:forEach>
					</c:if>
				</c:when>	
				<c:when test="${totalCnt==100}">
					<c:forEach var="page" begin="1" end="10" step="1">
						<a href="?section=${section}&pageNum=${page}">${page}</a>
					</c:forEach>
				</c:when>	
				<c:when test="${totalCnt<100}">
					<c:forEach var="page" begin="1" end="${(totalCnt+9)/10}" step="1">
						<a href="?section=${section}&pageNum=${page}">${page}</a>
					</c:forEach>
				</c:when>	
			</c:choose>
		</div>
	</c:if>
	<c:if test="${authInfo.memberName != null }">
       	<input type="button" id="qnaRegiBtn" name="qnaRegiBtn" value="QnA작성" onclick="location.href='qnaRegi'">
    </c:if>
    
    </section>

    <footer>
       Copyright (c) 2022 Mj_guri All right Reserved
    </footer>

</body>
</html>