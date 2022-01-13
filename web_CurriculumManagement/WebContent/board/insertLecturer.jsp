<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
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
    <div class='title'> 강사등록 </div>
    <form action="CMS" method="POST" >
    <input type="hidden" name="command" value="insertLecturerAction">
        <table>
            <thead>
                <tr>
                    <th>강사번호</th>
                    <td><input type="text" id="idx" name="idx" value="${seqNum}"readonly></td>
                </tr>
            </thead>
            <tbody>
            	<tr>
                    <th>강사명</th>
                    <td><input type="text" id="name" name="name"></td>
                </tr>
                <tr>
                    <th>전공</th>
                    <td><input type="text" id="major" name="major"></td>
                </tr>
                <tr>
                    <th>세부전공</th>
                    <td><input type="text" id="field" name="field"></td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td></td>
                    <td>
                    	<input type="button" value="목록" onclick="location.href='CMS?command=lecturerView'">
                    	<input type="submit" value="등록">
                    </td>
                </tr>
            </tfoot>
        </table>
    </form>

    </section>
    <footer class='headerFooter'>Copyright (c) 2022 MJguri All right Reserved</footer>   
</body>
</html>