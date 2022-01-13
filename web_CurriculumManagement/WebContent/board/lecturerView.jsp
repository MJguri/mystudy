<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href ="./CSS/main.css">
<title>Insert title here</title>
</head>
<body>
    <header class='headerFooter'>교과목 관리 사이트</header>
    
    <section>
        <div class='title'>강사 수정</div>
        <form action="CMS" method="POST">
        	<input type="hidden" id="command" name="command" value="updateLecturerAction">
        	<input type="hidden" id="idx" name="idx" value="${lVo.idx}">
	        <table>
	            <tr>
	                <th>강사번호</th>
	                <td>${lVo.idx}</td>
	            </tr>
	            <tr>
	                <th>강사명</th>
	                <td><input type="text" id="name" name="name" value="${lVo.name}"></td>
	            </tr>
	            <tr>
	                <th>전공</th>
	                <td><input type="text" id="major" name="major" value="${lVo.major}"></td>
	            </tr>
	            <tr>
	                <th>세부전공</th>
	                <td><input type="text" id="field" name="field" value="${lVo.field}"></td>
	            </tr>
	            <tr>
	                <th>담당과목</th>
	                <td>
	                	<c:forEach var="cL" items="${cList}">
								${cL}
						</c:forEach>
	                </td>
	            </tr>
	        </table>
	        <div class="btnBox">
	            <input type="submit" value="수정하기">
	            <input type="button" value="목록으로" onclick="location.href='CMS?command=lecturerView'">
	        </div>
        </form>
    </section>

    <footer class='headerFooter'>Copyright (c) 2022 MJguri All right Reserved</footer>

</body>
</html>