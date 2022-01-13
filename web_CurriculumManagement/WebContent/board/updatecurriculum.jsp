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
        <div class='title'>교과목 수정하기</div>
        <form action="CMS" method="POST">
            <input type="hidden" id="command" name="command" value="updateCurriculum">
            <input type="hidden" id="originid" name="originid" value="${cVo.id}">
	        <table>
	            <tr>
	                <th>교과목 코드</th>
	                <td><input type="text" id="id" name="id" value="${cVo.id}"> </td>
	            </tr>
	            <tr>
	                <th>과목 명</th>
	                <td><input type="text" id="name" name="name" value="${cVo.name}"></td>
	            </tr>
	            <tr>
	                <th>담당 강사</th>
	                <td>
	                	<!-- <input type="text" id="lecturer" name="lecturer" value="${cVo.lecturer}"> -->
	                	<select id="lecturer" name="lecturer">
                            <c:forEach var="lecL" items="${lecList}">
                                <option value="${lecL.idx }"<c:if test="${cVo.lecturer == lecL.idx}"> selected </c:if> > ${lecL.name }</option>
                            </c:forEach>
                        </select> 
	                </td>
	            </tr>
	            <tr>
	                <th>학점</th>
	                <td><input type="text" id="credit" name="credit" value="${cVo.credit}"> </td>
	            </tr>
	            <tr>
	                <th>요일</th>
	                <td>
                        <input type="radio" id="week" name="week" value="1"<c:if test="${cVo.week == 1}"> checked </c:if>>월
                        <input type="radio" id="week" name="week" value="2"<c:if test="${cVo.week == 2}"> checked </c:if>>화 
                        <input type="radio" id="week" name="week" value="3"<c:if test="${cVo.week == 3}"> checked </c:if>>수 
                        <input type="radio" id="week" name="week" value="4"<c:if test="${cVo.week == 4}"> checked </c:if>>목 
                        <input type="radio" id="week" name="week" value="5"<c:if test="${cVo.week == 5}"> checked </c:if>>금 
                        <input type="radio" id="week" name="week" value="6"<c:if test="${cVo.week == 6}"> checked </c:if>>토 
                    </td>
	            </tr>
	            <tr>
	                <th>시작</th>
	                <td><input type="text" id="start_hour" name="start_hour" value="${cVo.starthour}"> </td>
	            </tr>
	            <tr>
	                <th>종료</th>
	                <td><input type="text" id="end_hour" name="end_hour" value="${cVo.endhour}"> </td>
	            </tr>
	        </table>
	        <div class="btnBox">
	            <input type="button" value="목록" onclick="location.href='CMS?command=curriculum_List'">
	            <input type="button" value="취소" onclick="location.href='CMS?command=readCurri_List&id=${cVo.id}'">
	            <input type="submit" value="완료" >
	        </div>
        </form>
    </section>

    <footer class='headerFooter'>Copyright (c) 2022 MJguri All right Reserved</footer>

</body>
</html>