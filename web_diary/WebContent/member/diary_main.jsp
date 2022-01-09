<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


${message }
my diary
<table>
	<tr>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
	<c:forEach items="${dList}" var="d">
	<tr>
		<td><a href="RDS?diaryCode=${d.diaryCode }">${d.title }</a></td>
		<td>${d.userid }</td>
		<td>${d.diaryDate }</td>
	</tr>
	</c:forEach>
</table>

<input type="button" value="일기작성" onclick="go_create()">

<script>
function go_create(){
	location.href="create_diary.jsp";
}
</script>
</body>
</html>