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
        <div class='total'> 총 ${totalCnt } 개의 과목이 있습니다.</div>
        <div class='lecturerBtn'> <input type="button" value="강사보기" onclick="location.href='CMS?command=lecturerView'"> </div>
        
        <table>
            <thead>
                <tr>
                    <th>과목코드</th>
                    <th>과목명</th>
                    <th>학점</th>
                    <th>담당 강사</th>
                    <th>요일</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="cL" items="${curriList}">
					<tr>
						<td class="tdcenter">${cL.id}</td>
						<td class="tdcenter"><a href="CMS?command=readCurri_List&id=${cL.id}">${cL.name}</a></td>
						<td class="tdcenter">${cL.credit}</td>
						<td class="tdcenter">${cL.lecturer}</td>
						<td class="tdcenter">${cL.week}</td>
					</tr>
				</c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                    	<input type="button" value="교과목등록" onclick="go_curriculumInsert()">
                    </td>
                </tr>
            </tfoot>
        </table>

    </section>
    <footer class='headerFooter'>Copyright (c) 2022 MJguri All right Reserved</footer>

    <script>
        function go_curriculumInsert(){
            location.href="CMS?command=insertCurriculumForm";
        }
    
    </script>
</body>
</html>