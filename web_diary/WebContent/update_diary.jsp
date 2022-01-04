<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
수정페이지
${diaryCode }

<form action="UDS" method="POST">
	<fieldset>
		<legend>오늘의 일기 작성</legend>
		작성자 : <input type="text" name="userid" value="${dVo.userid }" readonly><br>
		작성일시 : <input type="text" name="diaryDate" value="${dVo.diaryDate }" readonly> <br>
		제목 :<input type="text" name="title" value="${dVo.title }"><br>
		내용 :<textarea name="content" >${dVo.content }</textarea> <br>
		<input type="hidden" name="diaryCode" value="${dVo.diaryCode}">
		<input type="submit" value="수정하기"> <input type="button" value="삭제하기" onclick="delete_diary()">
	</fieldset>
</form>

<script>
function delete_diary(){
	location.href="DDS?diaryCode="+${dVo.diaryCode};
}
</script>

</body>
</html>