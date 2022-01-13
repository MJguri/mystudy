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
    	<div class='title'> 강사목록 </div>
        <div class='total'> 총 ${totalCnt } 개의 과목이 있습니다. ${fn:length(lecList)}</div>
        <div class='lecturerBtn'> <input type="button" value="교과목보기" onclick="location.href='CMS?command=curriculum_List'"> </div>
        
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>강사명</th>
                    <th>전공</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="cL" items="${lecList}">
					<tr>
						<td class="tdcenter">${cL.idx}</td>
						<td class="tdcenter"><a href="CMS?command=updateLecturerView&id=${cL.idx}">${cL.name}</a></td>
						<td class="tdcenter">${cL.major}</td>
					</tr>
				</c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td></td>
                    <td></td>
                    <td>
                    	<input type="button" value="강사등록" onclick="location.href='CMS?command=insertLecturerForm'">
                    </td>
                </tr>
            </tfoot>
        </table>

    </section>
    <footer class='headerFooter'>Copyright (c) 2022 MJguri All right Reserved</footer>   
</body>
</html>