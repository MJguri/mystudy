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
        <form action="CMS" method="POST">
        	<input type="hidden" name="command" value="insertCurriculum">
            <div class='title'>교과목 등록</div>
            <table>
                <tr>
                    <th>교과목 코드</th>
                    <td><input type="text" id="id" name="id"></td>
                </tr>
                <tr>
                    <th>과목 명</th>
                    <td><input type="text" id="name" name="name"></td>
                </tr>
                <tr>
                    <th>담당 강사</th>
                    <td>
                        <select id="lecturer" name="lecturer">
                            <c:forEach var="lecL" items="${lecList}">
                                <option value="${lecL.idx }"> ${lecL.name }</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>학점</th>
                    <td><input type="text" id="credit" name="credit"></td>
                </tr>
                <tr>
                    <th>요일</th>
                    <td>
                        <input type="radio" id="week" name="week" value="1">월 
                        <input type="radio" id="week" name="week" value="2">화 
                        <input type="radio" id="week" name="week" value="3">수 
                        <input type="radio" id="week" name="week" value="4">목 
                        <input type="radio" id="week" name="week" value="5">금 
                        <input type="radio" id="week" name="week" value="6">토 
                    </td>
                </tr>
                <tr>
                    <th>시작</th>
                    <td><input type="text" id="start_hour" name="start_hour"></td>
                </tr>
                <tr>
                    <th>종료</th>
                    <td><input type="text" id="end_hour" name="end_hour"></td>
                </tr>
            </table>
            <div class="btnBox">
                <input type="button" value="목록으로" onclick="location.href='CMS?command=curriculum_List'">
                <input type="submit" value="등록하기">
                
            </div>
        </form>
    </section>

    <footer class='headerFooter'>Copyright (c) 2022 MJguri All right Reserved</footer>

</body>
</html>