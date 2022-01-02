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
<form action="COS" method="POST">
	<select name="coffeeName">
		<c:forEach items="${cList}" var="c">
			<option value="${c}"> ${c}
		</c:forEach>
	</select>
	<select name="type">
		<option value="tall">톨</option>
		<option value="grande">그란데</option>
		<option value="venti">벤티</option>
	</select>
	<input type="number" name="count">
	<input type="submit" value="선택">
</form>

<table border="1">
	<tr>
		<td>커피</td>
		<td>타입</td>
		<td>가격</td>
		<td>개수</td>
		<td>합계</td>
	</tr>
	<c:forEach items="${oList}" var="oL">
	<tr>
		<td>${oL.coffeeName }</td>
		<td>${oL.type }</td>
		<td>${oL.price }</td>
		<td>${oL.count }</td>
		<td>${oL.total }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>