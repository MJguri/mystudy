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
        <input type="button" id="loginBtn" name="loginBtn" value="로그인" onclick="location.href='login'">
        <input type="button" id="joinBtn" name="joinBtn" value="회원가입" onclick="location.href='memberRegi'">
    </header>

    <section>

	<c:if test="${totalCnt != null}">
		<table border="1">
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
					<td>${q.qnaBoardTitle}</td>
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
    
    </section>

    <footer>
       Copyright (c) 2022 Mj_guri All right Reserved
    </footer>

</body>
</html>